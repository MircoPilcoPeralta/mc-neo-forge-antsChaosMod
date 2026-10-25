package com.antsject.antsplusantsequalschaos.client;

import com.antsject.antsplusantsequalschaos.AntsPlusAntsEqualsChaos;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.entity.animation.json.AnimationHolder;

public class RedAntModel extends EntityModel<RedAntRenderState> {
    private static final Map<String, AnimationHolder> CLIPS = new HashMap<>();
    static {
        for (String name: new String[]{"idle","walk","grab","carry","release"})
            CLIPS.put(name, getAnimation(Identifier.fromNamespaceAndPath(AntsPlusAntsEqualsChaos.MODID,"red_ant/"+name)));
    }
    private final Map<String, AnimationDefinition> definitions=new HashMap<>();
    private final Map<String, KeyframeAnimation> baked=new HashMap<>();
    public RedAntModel() { super(RedAntGeometry.create()); }
    private KeyframeAnimation clip(String name) {
        AnimationDefinition definition=CLIPS.get(name).get();
        // Reloading resources replaces the definitions. Re-bake against this instance's bones.
        if (definitions.get(name)!=definition) {
            definitions.put(name,definition);
            baked.put(name,definition.bake(this.root()));
        }
        return baked.get(name);
    }
    @Override public void setupAnim(RedAntRenderState state) {
        super.setupAnim(state);
        boolean moving=state.walkAnimationSpeed>0.01F;
        long time=(long)(state.ageInTicks*50);
        this.clip("idle").apply(time, moving?0.35F:1.0F);
        if (state.phase!=RedAntRenderState.GRAB && state.phase!=RedAntRenderState.RELEASE)
            this.clip("walk").applyWalk(state.walkAnimationPos,state.walkAnimationSpeed,1.0F,2.0F);
        switch(state.phase) {
            case RedAntRenderState.GRAB -> this.clip("grab").apply((long)(state.actionTicks*50),1);
            case RedAntRenderState.CARRY -> this.clip("carry").apply(time,1);
            case RedAntRenderState.RELEASE -> this.clip("release").apply((long)(state.actionTicks*50),1);
            default -> { }
        }
    }
    public void translateToGrip(PoseStack pose) {
        this.root().translateAndRotate(pose);
        var ant=this.root().getChild("red_ant"); ant.translateAndRotate(pose);
        var torso=ant.getChild("torax"); torso.translateAndRotate(pose);
        torso.getChild("agarre_item").translateAndRotate(pose);
    }
}
