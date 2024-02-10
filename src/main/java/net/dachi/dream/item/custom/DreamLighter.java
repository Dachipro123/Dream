package net.dachi.dream.item.custom;


import net.dachi.dream.block.custom.DreamPortalBlock;
import net.dachi.dream.creativetab.ModCreativeModeTab;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class DreamLighter extends Item {
    public DreamLighter() {
        super(new Properties()
                .tab(ModCreativeModeTab.DREAM_TAB)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player entity = context.getPlayer();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        ItemStack itemstack = context.getItemInHand();
        Level world = context.getLevel();
        if (!entity.mayUseItemAt(pos, context.getClickedFace(), itemstack)) {
            return InteractionResult.FAIL;
        } else {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            boolean success = false;
            if (world.isEmptyBlock(pos) && true) {
                DreamPortalBlock.portalSpawn(world, pos);
                itemstack.hurtAndBreak(1, entity, c -> c.broadcastBreakEvent(context.getHand()));
                success = true;
                world.playSound(entity, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.4F + 0.8F);
            }
            return success ? InteractionResult.SUCCESS : InteractionResult.FAIL;
        }
    }
}

