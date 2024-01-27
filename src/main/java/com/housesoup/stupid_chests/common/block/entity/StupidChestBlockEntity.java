package com.housesoup.stupid_chests.common.block.entity;

import com.housesoup.stupid_chests.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StupidChestBlockEntity extends BlockEntity {

    public StupidChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STUPID_CHEST.get(), pos, state);
    }
    
}
