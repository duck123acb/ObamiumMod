package com.duck123acb.obamiummod.item;

import com.duck123acb.obamiummod.ObamiumMod;
import com.duck123acb.obamiummod.item.custom.BidenBlastItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ObamiumMod.MOD_ID); // register the custom items

    public static final RegistryObject<Item> OBAMIUM_GEM = ITEMS.register("obamium_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIDENITE_GEM = ITEMS.register("bidenite_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BUSHIUM_GEM = ITEMS.register("bushium_gem", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIDEN_BLAST_ITEM = ITEMS.register("biden_blast_item", () -> new BidenBlastItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}