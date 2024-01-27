package com.housesoup.stupid_chests.common.block;

import com.housesoup.stupid_chests.ModBlockEntities;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class StupidChestBlock extends Block implements EntityBlock {
    public StupidChestBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.STUPID_CHEST.get().create(pos, state);
    }

    @Override
    protected MapCodec<StupidChestBlock> codec() {
        return null;//simpleCodec(StupidChestBlock::new);
    }
}