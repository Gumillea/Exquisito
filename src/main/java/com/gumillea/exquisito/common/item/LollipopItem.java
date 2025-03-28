package com.gumillea.exquisito.common.item;

import com.teamabnormals.neapolitan.core.registry.NeapolitanSoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class LollipopItem extends Item {
    public LollipopItem(Properties builder) {
        super(builder);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        Item item = user.getRandom().nextFloat() <= 0.5F ? Items.STICK : this;
        ItemStack itemstack = new ItemStack(item);

        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (stack.isEmpty()) {
            return itemstack;
        } else {
            if (user instanceof Player player) {
                if (!((Player)user).getAbilities().instabuild) {
                    if (!player.getInventory().add(itemstack)) {
                        player.drop(itemstack, false);
                    }
                }
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
        return NeapolitanSoundEvents.ICE_CUBES_EAT.get();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.exquisito.lollipop").withStyle(ChatFormatting.BLUE));
    }

}
