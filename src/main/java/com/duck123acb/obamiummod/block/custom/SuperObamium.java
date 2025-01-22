package com.duck123acb.obamiummod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SuperObamium extends Block {

    public SuperObamium(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide) {
            // Create an AABB to define the area
            AABB area = new AABB(pPos).inflate(20.0);

            List<Entity> allEntities = pLevel.getEntities(null, area);

            // smite each entity except the player
            for (Entity entity : allEntities) {
                if (entity == pPlayer) {
                    continue;
                }
                smiteEntity(pLevel, entity);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void smiteEntity(Level pLevel, Entity entity) {
        LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(pLevel);
        if (lightning != null) {
            lightning.moveTo(entity.getX(), entity.getY(), entity.getZ());
            pLevel.addFreshEntity(lightning);
        }
    }
}
