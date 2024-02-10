package net.dachi.dream.item.custom;

import net.dachi.dream.world.dimension.ModDimensions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningSucker extends Item {
    public LightningSucker(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Sucks The lightning out of the nightmare dimension").withStyle(ChatFormatting.RED));
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player entity = pContext.getPlayer();
        BlockPos pos = pContext.getClickedPos();
        if (entity.level.dimension() == ModDimensions.NIGHTMARE_KEY && !entity.level.isClientSide()){
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
            EntityType.LIGHTNING_BOLT.spawn((ServerLevel) entity.level, null, (Player)null, pos,
                    MobSpawnType.TRIGGERED, true, true);
        }


        return super.useOn(pContext);
    }
}
