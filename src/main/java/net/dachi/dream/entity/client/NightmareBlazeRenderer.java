package net.dachi.dream.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.NightmareBlazeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class NightmareBlazeRenderer extends GeoEntityRenderer<NightmareBlazeEntity> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Dream.MOD_ID, "textures/entity/nightmare_blaze/nightmare_blaze.png");

    public NightmareBlazeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NightmareBlazeModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public RenderType getRenderType(NightmareBlazeEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    @Override
    public ResourceLocation getTextureLocation(NightmareBlazeEntity animatable) {
        return TEXTURE;
    }
}
