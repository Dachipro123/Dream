package net.dachi.dream.block.custom;

import net.dachi.dream.particle.ModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DreamRainbow extends Block {
    public DreamRainbow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        float chance = 0.2f;
        if (chance < pRandom.nextFloat()){
            pLevel.addParticle(ModParticleTypes.RAINBOW_PARTICLES.get(),pPos.getX() + pRandom.nextDouble(),pPos.getY(),
                    pPos.getZ()+ pRandom.nextDouble(),0d,0.05d,0d);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }
}
