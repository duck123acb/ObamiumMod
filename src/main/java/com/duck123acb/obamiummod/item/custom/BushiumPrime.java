package com.duck123acb.obamiummod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BushiumPrime extends Item {
    public BushiumPrime(Properties properties) {
        super(properties);
    }

     @Override
     public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        int duration = 20;

        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        applyEffects(pPlayer, duration * 20);
        itemstack.consume(1, pPlayer);

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
     }

     private void applyEffects(Player player, int durationTicks) {
         player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, durationTicks, 10));
         player.addEffect(new MobEffectInstance(MobEffects.JUMP, durationTicks, 3));
         player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, durationTicks, 5));
         player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, durationTicks, 1));
         player.addEffect(new MobEffectInstance(MobEffects.SATURATION, durationTicks, 2));
         player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, durationTicks, 3));
     }
}
