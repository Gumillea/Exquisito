package com.gumillea.exquisito.common.item;

import com.gumillea.exquisito.core.ExquisitoConfig;
import com.gumillea.exquisito.core.reg.ExquisitoEffects;
import com.gumillea.exquisito.core.util.ExquisitoEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
public class ChocolateRinglingItem extends Item {
    public ChocolateRinglingItem(Properties builder) {
        super(builder);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!world.isClientSide() && user.getEffect(ExquisitoEffects.FUCHSIA_GOO.get()) != null) {
            if (ExquisitoConfig.Common.FUCHSIA_GOO_SPREAD.get()) {
                ExquisitoEvents.generateEnnegels(world, user);
            }
            user.removeEffect(ExquisitoEffects.FUCHSIA_GOO.get());
        }

        if (user instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        return super.finishUsingItem(stack, world, user);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }
}
