"""Export the red ant rig, Blockbench clips, NeoForge JSON and Java geometry without external dependencies."""
import json,math,uuid,shutil,argparse
from pathlib import Path
HERE=Path(__file__).resolve().parent.parent/'ants/red_ant'
DEST=HERE/'exports/neoforge/src/main'
PACKAGE='com.antsject.antsplusantsequalschaos'
MODID='antsplusantsequalschaos'
def uid():return str(uuid.uuid4())
def group(n,p,ch):return dict(name=n,uuid=uid(),origin=p,rotation=[0,0,0],export=True,isOpen=False,children=ch)
def save(p,v):p.parent.mkdir(parents=True,exist_ok=True);p.write_text(json.dumps(v,indent=2,ensure_ascii=False)+'\n')
def export(recreate=False):
 m=json.loads((HERE/'blockbench/red_ant.bbmodel').read_text());els={e['uuid']:e for e in m['elements']};root=m['outliner'][0]
 # Normalize the original authored XYZ cube angles to Blockbench's actual ZYX order.
 # This preserves the intended rest geometry and makes Java and Blockbench agree.
 if not m.get('ant_euler_zyx'):
  for e in els.values():
   rx,ry,rz=map(math.radians,e['rotation']);cx,sx=math.cos(rx),math.sin(rx);cy,sy=math.cos(ry),math.sin(ry);cz,sz=math.cos(rz),math.sin(rz)
   R=[[cy*cz,-cy*sz,sy],[sx*sy*cz+cx*sz,cx*cz-sx*sy*sz,-sx*cy],[sx*sz-cx*sy*cz,sx*cz+cx*sy*sz,cx*cy]]
   y=math.asin(max(-1,min(1,-R[2][0])))
   if abs(math.cos(y))>1e-8:x,z=math.atan2(R[2][1],R[2][2]),math.atan2(R[1][0],R[0][0])
   else:x,z=0,math.atan2(-R[0][1],R[1][1])
   e['rotation']=[math.degrees(x),math.degrees(y),math.degrees(z)]
   # Verify an arbitrary vertex under both rotation orders.
   v=[1.3,-.7,.4];old=[sum(R[i][j]*v[j] for j in range(3)) for i in range(3)]
   vx,vy,vz=v;vx,vy,vz=vx,vy*math.cos(x)-vz*math.sin(x),vy*math.sin(x)+vz*math.cos(x)
   vx,vz=vx*math.cos(y)+vz*math.sin(y),-vx*math.sin(y)+vz*math.cos(y)
   vx,vy=vx*math.cos(z)-vy*math.sin(z),vx*math.sin(z)+vy*math.cos(z)
   assert max(abs(a-b) for a,b in zip(old,[vx,vy,vz]))<1e-8
  m['ant_euler_zyx']=True
 if m.get('ant_rig_version') != 1:
  # Joint hierarchy changes only: existing cubes and their rest transforms stay untouched.
  for g in list(root['children']):
   if not g['name'].startswith('pata_'):continue
   first,second=g['children'];e=els[first];a,b=map(math.radians,[e['rotation'][1],e['rotation'][2]])
   length=e['to'][0]-e['from'][0];mid=e['origin']
   knee=[mid[0]+math.cos(a)*math.cos(b)*length/2,mid[1]+math.sin(b)*math.cos(a)*length/2,mid[2]-math.sin(a)*length/2]
   g['children']=[first,group('codo_'+g['name'][5:],knee,[second])]
  torso=next(g for g in root['children'] if g['name']=='torax')
  attached=[g for g in root['children'] if g['name']=='cabeza' or g['name'] in ('pata_izquierda_1','pata_derecha_1')]
  root['children']=[g for g in root['children'] if g not in attached]
  torso['children']+=attached
  # Marker stays under torso so carrying follows the body animation.
  marker=group('agarre_item',[0,8.3,-10.0],[]);torso['children'].append(marker)
  # Sentinel is an explicit rig version, not a format change.
  m['ant_rig_version']=1
 else:pass
 # The sentinel below makes regeneration idempotent for already nested rigs.
 groups={}
 def collect(g):
  groups[g['name']]=g
  for c in g['children']:
   if isinstance(c,dict):collect(c)
 collect(root)
 clips={}
 def clip(name,length,loop):clips[name]={'length':length,'loop':loop,'channels':{}};return clips[name]
 def track(c,bone,channel,frames):c['channels'][bone,channel]=frames
 idle=clip('idle',2,True)
 track(idle,'torax','rotation',[(0,[0,0,0]),(1,[1,0,0]),(2,[0,0,0])])
 track(idle,'abdomen','rotation',[(0,[0,0,0]),(1,[-1.5,0,0]),(2,[0,0,0])])
 for side,s in [('izquierda',-1),('derecha',1)]:
  track(idle,'antena_'+side,'rotation',[(0,[0,s*3,0]),(.5,[2,s*-5,0]),(1,[0,s*5,0]),(1.5,[-2,s*-3,0]),(2,[0,s*3,0])])
 walk=clip('walk',.8,True)
 for side,s in [('izquierda',-1),('derecha',1)]:
  for i in (2,3):
   phase=s*(1 if i==2 else -1)
   track(walk,f'pata_{side}_{i}','rotation',[(0,[0,phase*14,0]),(.2,[0,0,0]),(.4,[0,-phase*14,0]),(.6,[0,0,0]),(.8,[0,phase*14,0])])
   values=[0,14,0,0,0] if phase>0 else [0,0,0,14,0]
   track(walk,f'codo_{side}_{i}','rotation',[(j*.2,[s*v,0,0]) for j,v in enumerate(values)])
 poses={}
 for side,s in [('izquierda',-1),('derecha',1)]:
  poses[f'pata_{side}_1']=[-3,s*8,0];poses[f'codo_{side}_1']=[0,-s*12,0]
 grab=clip('grab',.6,False);carry=clip('carry',1.6,True);release=clip('release',.6,False)
 for bone,target in poses.items():
  track(grab,bone,'rotation',[(0,[0,0,0]),(.2,[v*-.25 for v in target]),(.5,target),(.6,target)])
  track(carry,bone,'rotation',[(0,target),(.8,target),(1.6,target)])
  track(release,bone,'rotation',[(0,target),(.3,[v*.7 for v in target]),(.6,[0,0,0])])
 track(carry,'agarre_item','position',[(0,[0,0,0]),(.8,[0,.15,0]),(1.6,[0,0,0])])
 animations=[]
 for name,c in clips.items():
  anim={'uuid':uid(),'name':name,'loop':'loop' if c['loop'] else 'hold','override':False,'length':c['length'],'snapping':20,'anim_time_update':'','blend_weight':'','start_delay':'','loop_delay':'','animators':{}}
  neo={'length':c['length'],'loop':c['loop'],'animations':[]}
  for (bone,ch),frames in c['channels'].items():
   g=groups[bone];a=anim['animators'].setdefault(g['uuid'],{'name':bone,'type':'bone','keyframes':[]})
   nk=[]
   for t,v in frames:
    a['keyframes'].append({'uuid':uid(),'channel':ch,'time':round(t,6),'color':-1,'interpolation':'linear','data_points':[dict(zip(('x','y','z'),map(str,v)))]})
    # Java's model axes: C=diag(-1,-1,1). Position codec itself flips Y.
    jv=[-v[0],-v[1],v[2]] if ch=='rotation' else [-v[0],v[1],v[2]]
    nk.append({'timestamp':round(t,6),'target':jv,'interpolation':'minecraft:linear'})
   neo['animations'].append({'bone':bone,'target':'minecraft:'+ch,'keyframes':nk})
  animations.append(anim);save(DEST/f'resources/assets/{MODID}/neoforge/animations/entity/red_ant/{name}.json',neo)
 if not recreate and m.get('animations'):
  animations=m['animations']
  for anim in animations:
   name=anim['name']
   assert name and all(c.islower() or c.isdigit() or c=='_' for c in name), 'Use snake_case animation names'
   neo={'length':anim['length'],'loop':anim.get('loop')=='loop','animations':[]}
   for key,a in anim.get('animators',{}).items():
    if a.get('type')!='bone':continue
    bone=a.get('name')
    assert bone in groups, f'Unknown bone {bone}'
    bychannel={}
    for k in a.get('keyframes',[]):bychannel.setdefault(k['channel'],[]).append(k)
    for channel,keys in bychannel.items():
     assert channel in ('rotation','position'), 'This exporter supports rotation and position channels'
     frames=[]
     for k in sorted(keys,key=lambda k:k['time']):
      assert len(k['data_points'])==1, 'Split keyframes require a dedicated exporter'
      assert k.get('interpolation','linear') in ('linear','catmullrom'), 'Use linear or catmullrom interpolation'
      point=k['data_points'][0];v=[float(point[c]) for c in ('x','y','z')]
      jv=[-v[0],-v[1],v[2]] if channel=='rotation' else [-v[0],v[1],v[2]]
      frames.append({'timestamp':k['time'],'target':jv,'interpolation':'minecraft:'+k.get('interpolation','linear')})
     neo['animations'].append({'bone':bone,'target':'minecraft:'+channel,'keyframes':frames})
   save(DEST/f'resources/assets/{MODID}/neoforge/animations/entity/red_ant/{name}.json',neo)
 m['animations']=animations;m['ant_rig_version']=1
 save(HERE/'blockbench/red_ant.bbmodel',m)
 texdest=DEST/f'resources/assets/{MODID}/textures/entity/red_ant.png';texdest.parent.mkdir(parents=True,exist_ok=True);shutil.copy2(HERE/'textures/red_ant.png',texdest)
 # Export a ModelPart hierarchy that preserves every per-face UV and rotated cuboid.
 def f(v):return f'{float(v):.9g}f' if '.' in f'{float(v):.9g}' or 'e' in f'{float(v):.9g}' else f'{int(v)}.0f'
 def vec(v):return ', '.join(map(f,v))
 lines=[];counter=[0]
 def node(g,parent=None):
  kids=[]
  for child in g['children']:
   if isinstance(child,dict):kids.append((child['name'],node(child,g['origin'])))
   else:
    e=els[child];n=f'p{counter[0]}';counter[0]+=1
    a=[e['from'][i]-e['origin'][i] for i in range(3)];b=[e['to'][i]-e['origin'][i] for i in range(3)]
    uv=[v for face in ('north','east','south','west','up','down') for v in e['faces'][face]['uv']]
    lines.append(f'        ModelPart {n} = part(List.of(cube(new float[]{{{vec(a+b)}}}, new float[]{{{vec(uv)}}})), new LinkedHashMap<>(), {vec([- (e["origin"][0]-g["origin"][0]),-(e["origin"][1]-g["origin"][1]),e["origin"][2]-g["origin"][2]])}, {vec([-math.radians(e["rotation"][0]),-math.radians(e["rotation"][1]),math.radians(e["rotation"][2])])});')
    kids.append(('mesh_'+str(counter[0]),n))
  n=f'p{counter[0]}';counter[0]+=1
  if parent is None:offset=[-g['origin'][0],24-g['origin'][1],g['origin'][2]]
  else:offset=[-(g['origin'][0]-parent[0]),-(g['origin'][1]-parent[1]),g['origin'][2]-parent[2]]
  mapname=n+'Children';lines.append(f'        Map<String, ModelPart> {mapname} = new LinkedHashMap<>();')
  for k,v in kids:lines.append(f'        {mapname}.put("{k}", {v});')
  lines.append(f'        ModelPart {n} = part(List.of(), {mapname}, {vec(offset)}, 0.0f, 0.0f, 0.0f);');return n
 top=node(root);lines.append(f'        return part(List.of(), Map.of("red_ant", {top}), 0, 0, 0, 0, 0, 0);')
 template='''package com.antsject.antsplusantsequalschaos.client;

import java.util.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.core.Direction;
import org.joml.Vector3f;

/** Generated by models/tools/export_red_ant.py. Per-face UVs are preserved. */
public final class RedAntGeometry {
    private RedAntGeometry() {}
    public static ModelPart create() {
__PARTS__
    }
    private static ModelPart part(List<ModelPart.Cube> cubes, Map<String, ModelPart> children,
            float x, float y, float z, float rx, float ry, float rz) {
        ModelPart p = new ModelPart(cubes, children);
        PartPose pose = PartPose.offsetAndRotation(x,y,z,rx,ry,rz);
        p.setInitialPose(pose); p.loadPose(pose); return p;
    }
    private static ModelPart.Cube cube(float[] b, float[] uv) {
        float x=b[0],y=b[1],z=b[2],X=b[3],Y=b[4],Z=b[5];
        ModelPart.Cube cube = new ModelPart.Cube(0,0,-X,-Y,z,X-x,Y-y,Z-z,0,0,0,false,128,128,EnumSet.allOf(Direction.class));
        float[][][] vertices={
            {{x,y,z},{X,y,z},{X,Y,z},{x,Y,z}},
            {{X,y,z},{X,y,Z},{X,Y,Z},{X,Y,z}},
            {{X,y,Z},{x,y,Z},{x,Y,Z},{X,Y,Z}},
            {{x,y,Z},{x,y,z},{x,Y,z},{x,Y,Z}},
            {{x,Y,z},{X,Y,z},{X,Y,Z},{x,Y,Z}},
            {{x,y,Z},{X,y,Z},{X,y,z},{x,y,z}}
        };
        float[][] normals={{0,0,-1},{1,0,0},{0,0,1},{-1,0,0},{0,1,0},{0,-1,0}};
        for(int face=0;face<6;face++) {
            int o=face*4;
            float[][] tex={{uv[o],uv[o+3]},{uv[o+2],uv[o+3]},{uv[o+2],uv[o+1]},{uv[o],uv[o+1]}};
            ModelPart.Vertex[] quad=new ModelPart.Vertex[4];
            for(int j=0;j<4;j++) {
                int k=3-j; float[] v=vertices[face][k];
                quad[j]=new ModelPart.Vertex(-v[0],-v[1],v[2],tex[k][0]/128,tex[k][1]/128);
            }
            float[] n=normals[face];
            cube.polygons[face]=new ModelPart.Polygon(quad,new Vector3f(-n[0],-n[1],n[2]));
        }
        return cube;
    }
}
'''
 java=DEST/'java'/Path(*PACKAGE.split('.'))/'client/RedAntGeometry.java';java.parent.mkdir(parents=True,exist_ok=True);java.write_text(template.replace('__PARTS__','\n'.join(lines)))
 # Check the exported references and loops before integration.
 assert len(groups)==len(set(groups))
 assert len(animations)==5
 for c in clips.values():
  for (bone,ch),frames in c['channels'].items():
   assert bone in groups and frames[0][0]==0 and abs(frames[-1][0]-c['length'])<1e-7
   if c['loop']:assert frames[0][1]==frames[-1][1]
 print(f'Rig: {len(groups)} bones; {len(els)} preserved cubes; {len(animations)} animations; Java geometry and NeoForge JSON exported.')
if __name__=='__main__':
 parser=argparse.ArgumentParser(description=__doc__)
 parser.add_argument('--reset-animations',action='store_true',help='Replace edited animations with the five default clips')
 export(parser.parse_args().reset_animations)
