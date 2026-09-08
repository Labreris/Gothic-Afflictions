package net.larchfen.gothicafflictions.block.custom;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.block.custom.properties.LargeDiscType;
import net.larchfen.gothicafflictions.block.custom.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WideColumnBlock extends ModFlammableRotatedPillarBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<LargeDiscType> TYPE = ModBlockStateProperties.LARGE_DISC_TYPE;

    public WideColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, LargeDiscType.NONE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction.Axis axis = context.getClickedFace().getAxis();
        BlockState state = this.defaultBlockState().setValue(AXIS, axis);

        state = state.setValue(
                TYPE,
                getType(level, pos, ModBlocks.HEARTWOOD_LOG.get(), context));
        return state;
    }
/*
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide) return;

        LargeDiscType type = getType(level, pos);
        if (state.getValue(TYPE) == type) return;

        state = state.setValue(
                TYPE,
                type);
        level.setBlock(pos, state, 3);
    }
*/
    public BlockState[] getSurroundingNeighborsY(Level level, BlockPos pos) {
        BlockState[] allNeighborBlocksY = new BlockState[8];

        int i = 0;
        int y = 0;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                    if (x == 0 && z == 0) continue;
                    allNeighborBlocksY[i] = level.getBlockState(pos.offset(x, y, z));
                    i++;
            }
        }

        return allNeighborBlocksY;
    }
    /*
        public BlockState[] getSurroundingNeighborsX(Level level, BlockPos pos) {
            BlockState[] allNeighborBlocksX = new BlockState[8];

            int x = 0;
            int i = 0;
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (y == 0 && z == 0) continue;
                    allNeighborBlocksX[i] = level.getBlockState(pos.offset(x, y, z));
                    i++;
                }
            }

            return allNeighborBlocksX;
        }

        public BlockState[] getSurroundingNeighborsZ(Level level, BlockPos pos) {
            BlockState[] allNeighborBlocksZ = new BlockState[8];

            int z = 0;
            int i = 0;
            for (int y = -1; y <= 1; y++) {
                for (int x = -1; x <= 1; x++) {
                    if (y == 0 && x == 0) continue;
                    allNeighborBlocksZ[i] = level.getBlockState(pos.offset(x, y, z));
                    i++;
                }
            }

            return allNeighborBlocksZ;
        }

        public BlockState[] getCardinalNeighbors(BlockState state, Level level, BlockPos pos, Direction direction) {
            BlockState[] cardinalNeighborBlocks = new BlockState[8];

            int y = 0;
            int i = 0;
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && z == 0) continue;
                    cardinalNeighborBlocks[i] = level.getBlockState(pos.offset(1, direction));
                    i++;
                }
            }

            return cardinalNeighborBlocks;
        }


        public LargeDiscType getTypeWithAxis(Level level, BlockPos pos, Block center) {

        }
    */
    public LargeDiscType getType(Level level, BlockPos pos, Block centerBlock, BlockPlaceContext context) {
        BlockState[] neighborsY = getSurroundingNeighborsY(level, pos);

        LargeDiscType[] relativePositions = {
                LargeDiscType.NE_CORNER,
                LargeDiscType.EAST_SIDE,
                LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,
                LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER,
                LargeDiscType.WEST_SIDE,
                LargeDiscType.SW_CORNER
        };


        for (int i = 0; i < neighborsY.length; i++) {

            if (neighborsY[i].getBlock() == centerBlock && neighborsY[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                return relativePositions[i];
            }

        }
        return LargeDiscType.NONE;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, AXIS);
    }
}

