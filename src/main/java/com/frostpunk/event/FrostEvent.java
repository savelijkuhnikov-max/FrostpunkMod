package com.frostpunk.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerTickEvent;
import net.minecraft.world.entity.player.Player;

@EventBusSubscriber(modid = "frostpunkmod", bus = EventBusSubscriber.Bus.GAME)
public class FrostEvent {
    private static final double FROST_DAMAGE_PER_TICK = 0.05;
    private static final int FROST_CHECK_INTERVAL = 20;
    private static int frostCounter = 0;

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        
        if (player.level().isClientSide) return;
        
        if (frostCounter++ >= FROST_CHECK_INTERVAL) {
            frostCounter = 0;
            applyFrostDamage(player);
        }
    }

    private static void applyFrostDamage(Player player) {
        // Damage if player is in cold biome and not near heat source
        if (isInColdBiome(player) && !isNearHeatSource(player)) {
            player.hurt(player.level().damageSources().freeze(), (float) FROST_DAMAGE_PER_TICK * 20);
        }
    }

    private static boolean isInColdBiome(Player player) {
        return player.level().getBiome(player.blockPosition()).is(net.minecraft.tags.BiomeTags.IS_SNOWY);
    }

    private static boolean isNearHeatSource(Player player) {
        // TODO: Implement heat source detection
        return false;
    }
}
