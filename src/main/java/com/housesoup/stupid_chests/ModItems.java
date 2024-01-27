package com.housesoup.stupid_chests;

import com.google.common.base.Supplier;
import com.housesoup.stupid_chests.common.item.StupidChestItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    private static final DeferredRegister<Item> BLOCKS = DeferredRegister
        .create(ForgeRegistries.ITEMS, StupidChestsMod.MODID);
    
    public static final RegistryObject<Item> STUPID_CHEST = register("stupid_chest", StupidChestItem::new);

    private static RegistryObject<Item> register(String name, Supplier<Item> sup) {
        return BLOCKS.register(name, sup);
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
