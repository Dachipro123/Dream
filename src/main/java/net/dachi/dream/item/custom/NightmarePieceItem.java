package net.dachi.dream.item.custom;

import net.dachi.dream.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NightmarePieceItem extends Item {
    public NightmarePieceItem(Properties properties) {
        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Forge This with The DREAM PIECE and unlock POWER").withStyle(ChatFormatting.BLACK));
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
