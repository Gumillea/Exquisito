package com.gumillea.exquisito.common.item;

import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class LollipopItem extends Item {
    public LollipopItem(Properties builder) {
        super(builder);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            if (user.getRandom().nextFloat() <= 0.5F) {
            return new ItemStack(Items.STICK);
            } else {
                return stack;
            }
        } else {
            if (user instanceof Player player && !((Player)user).getAbilities().instabuild) {
                if (user.getRandom().nextFloat() <= 0.5F) {
                    ItemStack itemstack = new ItemStack(Items.STICK);
                    if (!player.getInventory().add(itemstack)) {
                        player.drop(itemstack, false);
                    }
                } else {
                    ItemStack itemstack = new ItemStack(this);
                    if (!player.getInventory().add(itemstack)) {
                        player.drop(itemstack, false);
                    }
                }
            } else {
                return stack;
            }
        }
        return super.finishUsingItem(stack, world, user);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return NeapolitanSoundEvents.ITEM_ICE_CUBES_EAT.get();
    }

}
