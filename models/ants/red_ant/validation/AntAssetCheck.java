import com.antsject.antsplusantsequalschaos.client.RedAntGeometry;
import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.neoforged.neoforge.client.entity.animation.json.AnimationParser;

/** Runs without a game window: checks the real NeoForge codec and actual baked model parts. */
public class AntAssetCheck {
    public static void main(String[] args) throws Exception {
        ModelPart root=RedAntGeometry.create();
        var lookup=root.createPartLookup();
        int checked=0;
        for (String name:new String[]{"idle","walk","grab","carry","release"}) {
            var json=JsonParser.parseString(Files.readString(Path.of(args[0],name+".json")));
            AnimationDefinition definition=AnimationParser.CODEC.parse(JsonOps.INSTANCE,json).getOrThrow();
            for (String bone:definition.boneAnimations().keySet())
                if (lookup.apply(bone)==null) throw new AssertionError("Missing bone "+bone);
            var animation=definition.bake(root);
            for (int millis:new int[]{0,50,200,400,600,800,1600,2000}) {
                root.getAllParts().forEach(ModelPart::resetPose);
                animation.apply(millis,1);
                root.getAllParts().forEach(p->{
                    if (!Float.isFinite(p.x+p.y+p.z+p.xRot+p.yRot+p.zRot)) throw new AssertionError("Nonfinite pose");
                });
            }
            System.out.println("PASS NeoForge codec + bake + samples: "+name);
            checked++;
        }
        if(checked!=5) throw new AssertionError();
        System.out.println("PASS 5 clips bound to actual exported geometry");
    }
}
