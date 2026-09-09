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
    public BlockState[] getSurroundingNeighbors(Level level, BlockPos pos) {
        BlockState[] allNeighborBlocksY = new BlockState[26];

        int i = 0;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && z == 0 && y == 0) continue;
                    allNeighborBlocksY[i] = level.getBlockState(pos.offset(x, y, z));
                    i++;
                }

            }
        }

        return allNeighborBlocksY;
    }

    public LargeDiscType getType(Level level, BlockPos pos, Block centerBlock, BlockPlaceContext context) {
        BlockState[] neighbors = getSurroundingNeighbors(level, pos);

        LargeDiscType[] relativePositionsY = {
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.EAST_SIDE, LargeDiscType.EAST_SIDE, LargeDiscType.EAST_SIDE,
                LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.NORTH_SIDE,LargeDiscType.NORTH_SIDE,
                LargeDiscType.NONE,                               LargeDiscType.NONE,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.SOUTH_SIDE,LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.WEST_SIDE, LargeDiscType.WEST_SIDE, LargeDiscType.WEST_SIDE,
                LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER
        };

        LargeDiscType[] relativePositionsX = {
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.NONE,      LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,                         LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.NONE,      LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
        };

        LargeDiscType[] relativePositionsZ = {
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.NONE,      LargeDiscType.NORTH_SIDE,
                LargeDiscType.SOUTH_SIDE,                         LargeDiscType.NORTH_SIDE,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.NONE,      LargeDiscType.NORTH_SIDE,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER
        };


        for (int i = 0; i < neighbors.length; i++) {

            if (neighbors[i].getBlock() == centerBlock && neighbors[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighbors[i].getValue(AXIS) == Direction.Axis.Y) {
                    return relativePositionsY[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.X) {
                    return relativePositionsX[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.Z) {
                    return relativePositionsZ[i];
                }
            }

        }
        return LargeDiscType.NONE;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, AXIS);
    }
}

