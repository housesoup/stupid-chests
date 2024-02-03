package com.housesoup.stupid_chests;

import com.google.common.base.Supplier;
import com.housesoup.stupid_chests.common.block.StupidChestBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister
        .create(ForgeRegistries.BLOCKS, StupidChestsMod.MODID);
    
    public static final RegistryObject<Block> STUPID_CHEST = register("stupid_chest", () -> new StupidChestBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).noOcclusion()));

    private static RegistryObject<Block> register(String name, Supplier<Block> sup) {
        return BLOCKS.register(name, sup);
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
