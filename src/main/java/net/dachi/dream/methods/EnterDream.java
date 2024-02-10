package net.dachi.dream.methods;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class EnterDream {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer player && !player.level.isClientSide()) {
            ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("dream:dream"));
            if (player.level.dimension() == destinationType)
                return;
            ServerLevel nextLevel = player.server.getLevel(destinationType);
            if (nextLevel != null) {
                player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                player.teleportTo(nextLevel, player.getX(), player.getY(), player.getZ(), player.getYRot(), player.getXRot());
                player.connection.send(new ClientboundPlayerAbilitiesPacket(player.getAbilities()));
                for (MobEffectInstance effectInstance : player.getActiveEffects())
                    player.connection.send(new ClientboundUpdateMobEffectPacket(player.getId(), effectInstance));
                player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
            }
        }
    }
}
