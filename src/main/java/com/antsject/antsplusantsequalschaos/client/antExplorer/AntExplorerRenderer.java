package com.antsject.antsplusantsequalschaos.client.antExplorer;

import com.antsject.antsplusantsequalschaos.AntsPlusAntsEqualsChaos;
import com.antsject.antsplusantsequalschaos.client.RedAntModel;
import com.antsject.antsplusantsequalschaos.client.RedAntRenderState;
import com.antsject.antsplusantsequalschaos.entity.ant.AntExplorer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class AntExplorerRenderer extends MobRenderer<AntExplorer, RedAntRenderState, RedAntModel> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(
            AntsPlusAntsEqualsChaos.MODID,
            "textures/entity/red_ant.png"
    );

    public AntExplorerRenderer(EntityRendererProvider.Context context) {
        super(context, new RedAntModel(), 0.55f);
    }

    @Override
    public Identifier getTextureLocation(RedAntRenderState redAntRenderState) {
        return TEXTURE;
    }

    @Override
    public RedAntRenderState createRenderState() {
        return new RedAntRenderState();
    }

    //Para dibujarla ahora, usa la fase normal y ningún gesto especial en progreso
    @Override
    public void extractRenderState(
            AntExplorer entity,
            RedAntRenderState state,
            float partialTick
    ) {
        super.extractRenderState(entity, state, partialTick);

        state.phase = RedAntRenderState.IDLE;
        state.actionTicks = 0;
    }

}
