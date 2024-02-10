package net.dachi.dream.item.custom;

import net.dachi.dream.world.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class DreamFlight extends Item {
    public DreamFlight(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player entity = pContext.getPlayer();
        if (!entity.level.isClientSide()){

            if (entity.getAbilities().mayfly == false){
                entity.getAbilities().mayfly = true;
                entity.onUpdateAbilities();
                System.out.println("Fly set to : "+entity.getAbilities().mayfly);
                entity.getAbilities().flying = true;
            }else if (entity.getAbilities().mayfly == true){
                entity.getAbilities().mayfly = false;
                System.out.println("Fly set to : "+entity.getAbilities().mayfly);
                entity.getAbilities().flying = false;
                entity.onUpdateAbilities();
            }

        }
        return super.useOn(pContext);
    }
}
