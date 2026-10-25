package com.antsject.antsplusantsequalschaos.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class RedAntRenderState extends LivingEntityRenderState {
    // Populated by the entity renderer; no entity behavior is defined in these assets.
    public static final int IDLE=0, GRAB=1, CARRY=2, RELEASE=3;
    public int phase;
    public float actionTicks;
    public final ItemStackRenderState carriedItem = new ItemStackRenderState();
}
