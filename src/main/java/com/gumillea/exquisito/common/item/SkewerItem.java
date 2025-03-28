package com.gumillea.exquisito.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SkewerItem extends Item {
    public SkewerItem(Properties builder) {
        super(builder);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {

        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.STICK);
        } else {
            if (user instanceof Player player) {
                if (!((Player)user).getAbilities().instabuild) {
                    ItemStack itemstack = new ItemStack(Items.STICK);
                    if (!player.getInventory().add(itemstack)) {
                        player.drop(itemstack, false);
                    }
                }
            }
        }

        return super.finishUsingItem(stack, world, user);
    }

}
