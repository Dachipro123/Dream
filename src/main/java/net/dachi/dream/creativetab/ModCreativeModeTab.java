package net.dachi.dream.creativetab;

import net.dachi.dream.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DREAM_TAB = new CreativeModeTab("dreamtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DREAM_INGOT.get());
        }
    };
}
