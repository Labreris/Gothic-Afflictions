package net.larchfen.gothicafflictions.block.custom;

import net.larchfen.gothicafflictions.block.ModBlocks;
import net.larchfen.gothicafflictions.block.custom.properties.LargeDiscType;
import net.larchfen.gothicafflictions.block.custom.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.Nullable;

import static java.lang.Math.abs;

public class WideColumnBlock extends ModFlammableRotatedPillarBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final EnumProperty<LargeDiscType> TYPE = ModBlockStateProperties.LARGE_DISC_TYPE;

    public WideColumnBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(TYPE, LargeDiscType.NONE));
    }

    //Because all of the 8 sections of the tree are locked in place and dont handle being rotated well, this code is there to help
    //It's not very efficient but it works
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        state = super.rotate(state, rotation);

        return switch (rotation) {
            case NONE -> state;

            case CLOCKWISE_90 ->
                    state.setValue(TYPE, rotateClockwise90(state.getValue(TYPE)));

            case CLOCKWISE_180 ->
                    state.setValue(TYPE, rotate180(state.getValue(TYPE)));

            case COUNTERCLOCKWISE_90 ->
                    state.setValue(TYPE, rotateCounterClockwise90(state.getValue(TYPE)));
        };
    }
    //Helper method for turning the directional types into what they need to be on a rotation
    private static LargeDiscType rotateCounterClockwise90(LargeDiscType type) {
        return switch (type) {
            case NW_CORNER -> LargeDiscType.NE_CORNER;
            case NORTH_SIDE -> LargeDiscType.EAST_SIDE;
            case NE_CORNER -> LargeDiscType.SE_CORNER;

            case EAST_SIDE -> LargeDiscType.SOUTH_SIDE;
            case SE_CORNER -> LargeDiscType.SW_CORNER;

            case SOUTH_SIDE -> LargeDiscType.WEST_SIDE;
            case SW_CORNER -> LargeDiscType.NW_CORNER;

            case WEST_SIDE -> LargeDiscType.NORTH_SIDE;

            case MIDDLE, NONE -> type;
        };
    }
    //Helper method for turning the directional types into what they need to be on a rotation
    private static LargeDiscType rotate180(LargeDiscType type) {
        return switch (type) {
            case NW_CORNER -> LargeDiscType.SE_CORNER;
            case NORTH_SIDE -> LargeDiscType.SOUTH_SIDE;
            case NE_CORNER -> LargeDiscType.SW_CORNER;

            case EAST_SIDE -> LargeDiscType.WEST_SIDE;
            case SE_CORNER -> LargeDiscType.NW_CORNER;

            case SOUTH_SIDE -> LargeDiscType.NORTH_SIDE;
            case SW_CORNER -> LargeDiscType.NE_CORNER;

            case WEST_SIDE -> LargeDiscType.EAST_SIDE;

            case MIDDLE, NONE -> type;
        };
    }
    //Helper method for turning the directional types into what they need to be on a rotation
    private static LargeDiscType rotateClockwise90(LargeDiscType type) {
        return switch (type) {
            case NW_CORNER -> LargeDiscType.SW_CORNER;
            case NORTH_SIDE -> LargeDiscType.WEST_SIDE;
            case NE_CORNER -> LargeDiscType.NW_CORNER;

            case EAST_SIDE -> LargeDiscType.NORTH_SIDE;
            case SE_CORNER -> LargeDiscType.NE_CORNER;

            case SOUTH_SIDE -> LargeDiscType.EAST_SIDE;
            case SW_CORNER -> LargeDiscType.SE_CORNER;

            case WEST_SIDE -> LargeDiscType.SOUTH_SIDE;

            case MIDDLE, NONE -> type;
        };
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
                getType(level, pos, ModBlocks.HEARTWOOD_LOG.get(), ModBlocks.ANCIENT_OAK_LOG.get(), context));
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
    public BlockState[] getSurroundingNeighbors(Level level, BlockPos pos, int axis) {
        BlockState[] allNeighborBlocks = new BlockState[26];
        BlockState[] allNeighborBlocksY = new BlockState[8];
        BlockState[] allNeighborBlocksX = new BlockState[8];
        BlockState[] allNeighborBlocksZ = new BlockState[8];

        int i = 0;
        int l = 0;
        int t = 0;
        int j = 0;
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                for (int y = -1; y <= 1; y++) {
                    if (x == 0 && z == 0 && y == 0) continue;
                    if(y == 0) {
                        allNeighborBlocksY[l] = level.getBlockState(pos.offset(x, y, z));
                        l++;
                    }
                    if (x == 0) {
                        allNeighborBlocksX[t] = level.getBlockState(pos.offset(x, y, z));
                        t++;
                    }
                    if (z == 0) {
                        allNeighborBlocksZ[j] = level.getBlockState(pos.offset(x, y, z));
                        j++;
                    }
                    allNeighborBlocks[i] = level.getBlockState(pos.offset(x, y, z));
                    i++;
                }

            }
        }
        if(axis == 1) {
            // Y axis
            return allNeighborBlocksY;
        } else if(axis == 2) {
            // X axis
            return allNeighborBlocksX;
        } else if(axis == 3) {
            // Z axis
            return allNeighborBlocksZ;
        } else return allNeighborBlocks;
    }

    public LargeDiscType getType(Level level, BlockPos pos, Block centerBlock, Block sideBlock, BlockPlaceContext context) {
        BlockState[] neighbors = getSurroundingNeighbors(level, pos, 0);
        BlockState[] neighborsY = getSurroundingNeighbors(level, pos, 1);
        BlockState[] neighborsX = getSurroundingNeighbors(level, pos, 2);
        BlockState[] neighborsZ = getSurroundingNeighbors(level, pos, 3);

        // 3x3 PLACEMENT
        LargeDiscType[] relativePositionsY = {
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,                         LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
        };

        LargeDiscType[] relativePositionsX = {
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,                         LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
        };

        LargeDiscType[] relativePositionsZ = {
                LargeDiscType.SE_CORNER,    LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SOUTH_SIDE,                            LargeDiscType.NORTH_SIDE,
                LargeDiscType.SW_CORNER,    LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER,
        };
        // 2x2 PLACEMENT (corners)
        LargeDiscType[] cornerPositionsY_SW = {
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER,                          LargeDiscType.SW_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE
        };

        LargeDiscType[] cornerPositionsY_SE = {
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER,                          LargeDiscType.SE_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE
        };

        LargeDiscType[] cornerPositionsY_NW = {
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NW_CORNER,                          LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE
        };

        LargeDiscType[] cornerPositionsY_NE = {
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER,                          LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER
        };

        LargeDiscType[] cornerPositionsX_SW = {
                LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.NONE,
                LargeDiscType.NW_CORNER,                          LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE
        };

        LargeDiscType[] cornerPositionsX_SE = {
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER,                          LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.NONE,
                LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.NONE,
        };

        LargeDiscType[] cornerPositionsX_NW = {
                LargeDiscType.NONE, LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE, LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE,                          LargeDiscType.SW_CORNER,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE, LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
        };

        LargeDiscType[] cornerPositionsX_NE = {
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE, LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,                          LargeDiscType.SE_CORNER,
                LargeDiscType.NONE, LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NONE, LargeDiscType.NW_CORNER, LargeDiscType.SW_CORNER,
        };

        LargeDiscType[] cornerPositionsZ_SW = {
                LargeDiscType.NONE,     LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.NONE,     LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.NONE,     LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.NONE,     LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.NONE,                              LargeDiscType.NW_CORNER,
                LargeDiscType.NONE,     LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,

        };

        LargeDiscType[] cornerPositionsZ_SE = {
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE,      LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.NONE,                               LargeDiscType.NE_CORNER,
                LargeDiscType.NONE,      LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.NONE, LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.NONE, LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.NONE, LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER
        };

        LargeDiscType[] cornerPositionsZ_NW = {
                LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NONE,
                LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NONE,
                LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NONE,
                LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
                LargeDiscType.SW_CORNER,                          LargeDiscType.NONE,
                LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
        };

        LargeDiscType[] cornerPositionsZ_NE = {
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.NONE,      LargeDiscType.NONE,
                LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NONE,
                LargeDiscType.SE_CORNER,                          LargeDiscType.NONE,
                LargeDiscType.SE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NONE,
                LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
                LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
                LargeDiscType.SW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
        };

        /*
        LargeDiscType[] relativePositionsY = {
                LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER, LargeDiscType.NE_CORNER,
                LargeDiscType.EAST_SIDE, LargeDiscType.EAST_SIDE, LargeDiscType.EAST_SIDE,
                LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.NORTH_SIDE,LargeDiscType.NORTH_SIDE,
                LargeDiscType.MIDDLE,                             LargeDiscType.MIDDLE,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.SOUTH_SIDE,LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NW_CORNER,
                LargeDiscType.WEST_SIDE, LargeDiscType.WEST_SIDE, LargeDiscType.WEST_SIDE,
                LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER, LargeDiscType.SW_CORNER
        };

        LargeDiscType[] relativePositionsX = {
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.MIDDLE,    LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,                         LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
                LargeDiscType.NE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.SE_CORNER,
                LargeDiscType.NORTH_SIDE,LargeDiscType.MIDDLE,    LargeDiscType.SOUTH_SIDE,
                LargeDiscType.NW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.SW_CORNER,
        };

        LargeDiscType[] relativePositionsZ = {
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SE_CORNER, LargeDiscType.EAST_SIDE, LargeDiscType.NE_CORNER,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.MIDDLE,    LargeDiscType.NORTH_SIDE,
                LargeDiscType.SOUTH_SIDE,                         LargeDiscType.NORTH_SIDE,
                LargeDiscType.SOUTH_SIDE,LargeDiscType.MIDDLE,    LargeDiscType.NORTH_SIDE,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER,
                LargeDiscType.SW_CORNER, LargeDiscType.WEST_SIDE, LargeDiscType.NW_CORNER
        };

        LargeDiscType[] cardinalPositionsY = {
                LargeDiscType.EAST_SIDE, LargeDiscType.NORTH_SIDE, LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.SOUTH_SIDE, LargeDiscType.WEST_SIDE,
        };

        LargeDiscType[] cornerPositionsY = {
                LargeDiscType.NE_CORNER, LargeDiscType.NW_CORNER, LargeDiscType.NONE,
                LargeDiscType.NONE, LargeDiscType.SE_CORNER, LargeDiscType.SW_CORNER,
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
        */

        // Detects 3x3 heartwood centers in the Y axis
        for (int i = 0; i < neighborsY.length; i++) {

            if (neighborsY[i].getBlock() == centerBlock && neighborsY[i].getBlock() != sideBlock && neighborsY[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighborsY[i].getValue(AXIS) == Direction.Axis.Y) {
                    return relativePositionsY[i];
                }
            }
        }
        // Detects 3x3 heartwood centers in the X axis
        for (int i = 0; i < neighborsX.length; i++) {

            if (neighborsX[i].getBlock() == centerBlock && neighborsX[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighborsX[i].getValue(AXIS) == Direction.Axis.X) {
                    return relativePositionsX[i];
                }
            }

        }
        // Detects 3x3 heartwood centers in the Z axis
        for (int i = 0; i < neighborsZ.length; i++) {

            if (neighborsZ[i].getBlock() == centerBlock && neighborsZ[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighborsZ[i].getValue(AXIS) == Direction.Axis.Z) {
                    return relativePositionsZ[i];
                }
            }

        }
        // Detects 2x2 corners in the Y axis
        for (int i = 0; i < neighbors.length; i++) {

            if (neighbors[i].getBlock() != centerBlock && neighbors[i].getBlock() == sideBlock && neighbors[i].getValue(AXIS) == context.getClickedFace().getAxis()) {

                if(neighbors[i].getValue(AXIS) == Direction.Axis.Y) {
                    if(neighbors[i].getValue(TYPE) == LargeDiscType.NE_CORNER) {
                        return cornerPositionsY_NE[i];
                    } else if(neighbors[i].getValue(TYPE) == LargeDiscType.NW_CORNER) {
                        return cornerPositionsY_NW[i];
                    } else if(neighbors[i].getValue(TYPE) == LargeDiscType.SE_CORNER) {
                        return cornerPositionsY_SE[i];
                    } else if(neighbors[i].getValue(TYPE) == LargeDiscType.SW_CORNER) {
                        return cornerPositionsY_SW[i];
                    }
                }

            }
        }
        // Detects 2x2 corners in the X axis
        for (int i = 0; i < neighbors.length; i++) {

            if (neighbors[i].getBlock() != centerBlock && neighbors[i].getBlock() == sideBlock && neighbors[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighbors[i].getValue(AXIS) == Direction.Axis.X && neighbors[i].getValue(TYPE) == LargeDiscType.NE_CORNER) {
                    return cornerPositionsX_NE[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.X && neighbors[i].getValue(TYPE) == LargeDiscType.NW_CORNER) {
                    return cornerPositionsX_NW[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.X && neighbors[i].getValue(TYPE) == LargeDiscType.SE_CORNER) {
                    return cornerPositionsX_SE[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.X && neighbors[i].getValue(TYPE) == LargeDiscType.SW_CORNER) {
                    return cornerPositionsX_SW[i];
                }
            }
        }
        // Detects 2x2 corners in the Z axis
        for (int i = 0; i < neighbors.length; i++) {

            if (neighbors[i].getBlock() != centerBlock && neighbors[i].getBlock() == sideBlock && neighbors[i].getValue(AXIS) == context.getClickedFace().getAxis()) {
                if(neighbors[i].getValue(AXIS) == Direction.Axis.Z && neighbors[i].getValue(TYPE) == LargeDiscType.NE_CORNER) {
                    return cornerPositionsZ_NE[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.Z && neighbors[i].getValue(TYPE) == LargeDiscType.NW_CORNER) {
                    return cornerPositionsZ_NW[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.Z && neighbors[i].getValue(TYPE) == LargeDiscType.SE_CORNER) {
                    return cornerPositionsZ_SE[i];
                } else if(neighbors[i].getValue(AXIS) == Direction.Axis.Z && neighbors[i].getValue(TYPE) == LargeDiscType.SW_CORNER) {
                    return cornerPositionsZ_SW[i];
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

