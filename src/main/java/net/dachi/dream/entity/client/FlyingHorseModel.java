package net.dachi.dream.entity.client;

import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.FlyingHorseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FlyingHorseModel extends AnimatedGeoModel<FlyingHorseEntity> {

    @Override
    public ResourceLocation getModelResource(FlyingHorseEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "geo/flying_horse.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FlyingHorseEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "textures/entity/flying_horse/flying_horse.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FlyingHorseEntity animatable) {
        return new ResourceLocation(Dream.MOD_ID, "animations/flying_horse.animation.json");
    }
}
