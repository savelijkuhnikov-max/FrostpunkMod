package com.frostpunk.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WinterArmorItem extends ArmorItem {
    public static final float FROST_RESISTANCE = 0.3f; // 30% frost damage reduction

    public WinterArmorItem(ArmorMaterial material, ArmorItem.Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide) {
            if (isWearingFullSet(player)) {
                // Apply warmth effect
                player.removeEffect(net.minecraft.world.effect.MobEffects.FREEZE);
            }
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof WinterArmorItem &&
               player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof WinterArmorItem &&
               player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof WinterArmorItem &&
               player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof WinterArmorItem;
    }
}
