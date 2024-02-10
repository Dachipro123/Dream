package net.dachi.dream.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.FlyingHorseEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class FlyingHorseRenderer extends GeoEntityRenderer<FlyingHorseEntity> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Dream.MOD_ID, "textures/entity/flying_horse/flying_horse.png");

    public FlyingHorseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FlyingHorseModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public RenderType getRenderType(FlyingHorseEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    @Override
    public ResourceLocation getTextureLocation(FlyingHorseEntity animatable) {
        return TEXTURE;
    }
}
