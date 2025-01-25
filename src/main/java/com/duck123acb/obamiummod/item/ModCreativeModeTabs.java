package com.duck123acb.obamiummod.item;

import com.duck123acb.obamiummod.ObamiumMod;
import com.duck123acb.obamiummod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ObamiumMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OBAMIUM_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("obamium_items_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.OBAMIUM_GEM.get()))
                    .title(Component.translatable("creativetab.obamiummod.obamium_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OBAMIUM_GEM.get());
                        output.accept(ModBlocks.OBAMIUM_ORE.get());
                        output.accept(ModBlocks.SUPER_OBAMIUM.get());
                        output.accept(ModBlocks.BIDENITE_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
