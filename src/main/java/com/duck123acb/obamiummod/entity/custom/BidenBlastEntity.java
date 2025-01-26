package com.duck123acb.obamiummod.entity.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class BidenBlastEntity extends Snowball {
    public BidenBlastEntity(Level pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ);
    }
    public BidenBlastEntity(Level pLevel, LivingEntity pShooter) {
        super(pLevel, pShooter);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(this.damageSources().magic(), 10.0f);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    10.0f,
                    true,
                    Level.ExplosionInteraction.BLOCK
            );
        }
    }
}