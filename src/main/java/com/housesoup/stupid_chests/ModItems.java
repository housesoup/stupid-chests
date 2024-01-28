package com.housesoup.stupid_chests;

import com.google.common.base.Supplier;
import com.housesoup.stupid_chests.common.item.StupidChestItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister
        .create(ForgeRegistries.ITEMS, StupidChestsMod.MODID);
    
    public static final RegistryObject<Item> STUPID_CHEST = register("stupid_chest", StupidChestItem::new);
    public static final RegistryObject<Item> STUPID_KEY = register("stupid_key", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    private static RegistryObject<Item> register(String name, Supplier<Item> sup) {
        return ITEMS.register(name, sup);
    }

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
