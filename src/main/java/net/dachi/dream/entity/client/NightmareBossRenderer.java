package net.dachi.dream.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.NightmareBlazeEntity;
import net.dachi.dream.entity.custom.NightmareBossEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class NightmareBossRenderer extends GeoEntityRenderer<NightmareBossEntity> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Dream.MOD_ID, "textures/entity/nightmare_boss/nightmare_boss.png");

    public NightmareBossRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NightmareBossModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public RenderType getRenderType(NightmareBossEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    @Override
    public ResourceLocation getTextureLocation(NightmareBossEntity animatable) {
        return TEXTURE;
    }
}
