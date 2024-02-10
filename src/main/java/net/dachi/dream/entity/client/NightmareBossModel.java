package net.dachi.dream.entity.client;

import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.NightmareBossEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NightmareBossModel extends AnimatedGeoModel<NightmareBossEntity> {

    @Override
    public ResourceLocation getModelResource(NightmareBossEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "geo/nightmare_boss.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NightmareBossEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "textures/entity/nightmare_boss/nightmare_boss.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NightmareBossEntity animatable) {
        return new ResourceLocation(Dream.MOD_ID, "animations/nightmare_boss.animation.json");
    }
}
