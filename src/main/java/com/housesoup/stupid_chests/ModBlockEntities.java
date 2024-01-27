package com.housesoup.stupid_chests;

import com.google.common.base.Supplier;
import com.housesoup.stupid_chests.common.block.entity.StupidChestBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister
        .create(ForgeRegistries.BLOCK_ENTITY_TYPES, StupidChestsMod.MODID);
    
    public static final RegistryObject<BlockEntityType<StupidChestBlockEntity>> STUPID_CHEST =
        register("stupid_chest", () -> BlockEntityType.Builder.of(StupidChestBlockEntity::new, ModBlocks.STUPID_CHEST.get()).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, Supplier<BlockEntityType<T>> sup) {
        return REGISTER.register(name, sup);
    }

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
