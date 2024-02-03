package com.housesoup.stupid_chests.common.block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class StupidChestBlock extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public StupidChestBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
            .setValue(NORTH, false)
            .setValue(EAST, false)
            .setValue(SOUTH, false)
            .setValue(WEST, false)
            .setValue(UP, false)
            .setValue(DOWN, false));
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        return defaultBlockState()
            .setValue(NORTH, attachesTo(level, pos, Direction.NORTH))
            .setValue(EAST, attachesTo(level, pos, Direction.EAST))
            .setValue(SOUTH, attachesTo(level, pos, Direction.SOUTH))
            .setValue(WEST, attachesTo(level, pos, Direction.WEST))
            .setValue(UP, attachesTo(level, pos, Direction.UP))
            .setValue(DOWN, attachesTo(level, pos, Direction.DOWN));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction neighborDir, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        BooleanProperty property = PipeBlock.PROPERTY_BY_DIRECTION.get(neighborDir);
        Boolean attaches = attachesTo(level, pos, neighborDir);

        // If the face changed, update the block state
        if (state.getValue(property) != attaches) {
            return state.setValue(property, attaches);
        }

        return state;
    }

    private @Nonnull Boolean attachesTo(LevelReader level, BlockPos pos, Direction dir) {
        BlockPos otherPos = pos.relative(dir);
        return attachesTo(level, otherPos);
    }

    private @Nonnull Boolean attachesTo(LevelReader level, BlockPos target) {
        return (Boolean)level.getBlockState(target).is(this);
    }
}