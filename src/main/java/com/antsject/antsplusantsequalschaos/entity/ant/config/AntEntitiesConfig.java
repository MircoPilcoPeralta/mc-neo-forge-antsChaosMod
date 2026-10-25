package com.antsject.antsplusantsequalschaos.entity.ant.config;

import com.antsject.antsplusantsequalschaos.AntsPlusAntsEqualsChaos;
import com.antsject.antsplusantsequalschaos.entity.ant.AntExplorer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AntEntitiesConfig {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(AntsPlusAntsEqualsChaos.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<AntExplorer>>
            ANT_EXPLORER = ENTITIES.registerEntityType(
                    AntExplorer.ENTITY_NAME,
                    AntExplorer::new,
                    MobCategory.MONSTER,
                    antExplorerBuilder -> antExplorerBuilder.sized(0.6F, 1.95F)
            );

    public static void registerAttributes(
            EntityAttributeCreationEvent event
    ){
        event.put(
                ANT_EXPLORER.get(),
                AntExplorer.createAttributes().build()
        );
    }

}
