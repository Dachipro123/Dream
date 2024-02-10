package net.dachi.dream.world.feature.treedecorators;

import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;

public class DreamBiomeTrunkDecorator extends TrunkVineDecorator {
    public static final DreamBiomeTrunkDecorator INSTANCE = new DreamBiomeTrunkDecorator();
    public static com.mojang.serialization.Codec<DreamBiomeTrunkDecorator> codec;
    public static TreeDecoratorType<?> tdt;
    static {
        codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
        tdt = new TreeDecoratorType<>(codec);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("dream_biome_tree_trunk_decorator", tdt);
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return tdt;
    }

    @Override
    public void place(TreeDecorator.Context context) {
        context.logs().forEach(blockpos -> {
            if (context.random().nextInt(3) > 0) {
                BlockPos pos = blockpos.west();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.VINE.defaultBlockState());
                }
            }
            if (context.random().nextInt(3) > 0) {
                BlockPos pos = blockpos.east();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.VINE.defaultBlockState());
                }
            }
            if (context.random().nextInt(3) > 0) {
                BlockPos pos = blockpos.north();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.VINE.defaultBlockState());
                }
            }
            if (context.random().nextInt(3) > 0) {
                BlockPos pos = blockpos.south();
                if (context.isAir(pos)) {
                    context.setBlock(pos, Blocks.VINE.defaultBlockState());
                }
            }
        });
    }
}
