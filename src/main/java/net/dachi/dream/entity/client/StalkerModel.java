package net.dachi.dream.entity.client;

import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.StalkerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StalkerModel extends AnimatedGeoModel<StalkerEntity> {

    @Override
    public ResourceLocation getModelResource(StalkerEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "geo/stalker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StalkerEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "textures/entity/stalker/stalker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StalkerEntity animatable) {
        return new ResourceLocation(Dream.MOD_ID, "animations/stalker.animation.json");
    }
}
