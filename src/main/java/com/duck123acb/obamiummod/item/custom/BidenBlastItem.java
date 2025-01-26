package com.duck123acb.obamiummod.item.custom;

import com.duck123acb.obamiummod.ObamiumMod;
import com.duck123acb.obamiummod.entity.custom.BidenBlastEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BidenBlastItem extends Item implements ProjectileItem { // throws a snowball for testing purposes
    public BidenBlastItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound(
                null,
                pPlayer.getX(),
                pPlayer.getY(),
                pPlayer.getZ(),
                SoundEvents.SNOWBALL_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!pLevel.isClientSide) {
            BidenBlastEntity bidenBlast = new BidenBlastEntity(pLevel, pPlayer);
            bidenBlast.setItem(itemstack);
            bidenBlast.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(bidenBlast);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, pPlayer);
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public @NotNull Projectile asProjectile(Level pLevel, Position pPos, ItemStack pStack, Direction pDirection) {
        BidenBlastEntity bidenBlast = new BidenBlastEntity(pLevel, pPos.x(), pPos.y(), pPos.z());
        bidenBlast.setItem(pStack);
        return bidenBlast;
    }
}
