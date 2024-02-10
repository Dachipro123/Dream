package net.dachi.dream.entity.client;

import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.NightmareBlazeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NightmareBlazeModel extends AnimatedGeoModel<NightmareBlazeEntity> {

    @Override
    public ResourceLocation getModelResource(NightmareBlazeEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "geo/nightmare_blaze.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NightmareBlazeEntity object) {
        return new ResourceLocation(Dream.MOD_ID, "textures/entity/nightmare_blaze/nightmare_blaze.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NightmareBlazeEntity animatable) {
        return new ResourceLocation(Dream.MOD_ID, "animations/nightmare_blaze.animation.json");
    }
}
