package de.hglabor.plugins.ffa.world;

import de.hglabor.plugins.ffa.player.FFAPlayer;
import de.hglabor.plugins.ffa.player.PlayerList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class ArenaSettings implements Listener {

    @EventHandler
    public void cancelDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getDamager());
            if (ffaPlayer.isInKitSelection()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void cancelInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getWhoClicked());
            if (ffaPlayer.isInKitSelection()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void cancelDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getEntity());
            if (ffaPlayer.isInKitSelection()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void cancelItemPickUp(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getEntity());
            if (ffaPlayer.isInKitSelection()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void cancelDropping(PlayerDropItemEvent event) {
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer(event.getPlayer());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void cancelFoodLoose(FoodLevelChangeEvent event) {
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getEntity());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer(event.getPlayer());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer(event.getPlayer());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleDamageEvent(VehicleDamageEvent event) {
        if (!(event.getAttacker() instanceof Player)) return;
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getAttacker());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onVehicleDamageEvent(HangingBreakByEntityEvent event) {
        if (!(event.getRemover() instanceof Player)) return;
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getRemover());
        if (ffaPlayer.isInKitSelection()) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void cancelEntityTargetInValidPlayer(EntityTargetLivingEntityEvent event) {
        if (!(event.getTarget() instanceof Player)) return;
        FFAPlayer ffaPlayer = PlayerList.getInstance().getPlayer((Player) event.getTarget());
        if (!ffaPlayer.isValid()) {
            event.setCancelled(true);
        }
    }
}
