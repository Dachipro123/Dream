package net.dachi.dream.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DreamPieceItem extends Item {
    public DreamPieceItem(Properties properties) {
        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        components.add(Component.literal("Forge This with The NIGHTMARE PIECE and unlock POWER").withStyle(ChatFormatting.AQUA));
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

}
