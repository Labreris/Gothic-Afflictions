package net.larchfen.gothicafflictions.worldgen.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.function.BiConsumer;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class ModTrunkPlacer extends TrunkPlacer {
    public static final MapCodec<ModTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> trunkPlacerParts(instance).apply(instance, ModTrunkPlacer::new));

    public ModTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacers.MOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level,
            BiConsumer<BlockPos, BlockState> blockSetter,
            RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        /*
         * Dirt underneath the 3x3 trunk.
         */
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {

                setDirtAt(
                        level,
                        blockSetter,
                        random,
                        pos.offset(x, -1, z),
                        config
                );
            }
        }

        /*
         * The actual 3x3 trunk.
         */
        BlockPos.MutableBlockPos mutablePos =
                new BlockPos.MutableBlockPos();

        for (int y = 0; y < freeTreeHeight; y++) {

            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {

                    mutablePos.setWithOffset(
                            pos,
                            x,
                            y,
                            z
                    );

                    /*
                     * Center block.
                     */
                    if (x == 0 && z == 0) {

                        if (level.isStateAtPosition(
                                mutablePos,
                                BlockBehaviour.BlockStateBase::canBeReplaced
                        )) {
                            blockSetter.accept(
                                    mutablePos,
                                    ModBlocks.HEARTWOOD_LOG
                                            .get()
                                            .defaultBlockState()
                            );
                        }

                        /*
                         * Outer 8 blocks.
                         */
                    } else {

                        this.placeLogIfFree(
                                level,
                                blockSetter,
                                random,
                                mutablePos,
                                config
                        );
                    }
                }
            }
        }

        /*
         * Foliage attaches to the top center
         * of the trunk.
         */
        return ImmutableList.of(
                new FoliagePlacer.FoliageAttachment(
                        pos.above(freeTreeHeight),
                        0,
                        true
                )
        );
    }
}
