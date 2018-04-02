package org.zapto.dx2437.event;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Event implements Listener {


    @EventHandler
    public void onMove(PlayerInteractEvent e) {
        /*if (e.getPlayer().getItemInHand().getType() == Material.SIGN && e.getPlayer().isFlying()) {
            e.getPlayer().setFlySpeed((float) 0.05);
            e.getPlayer().sendMessage(ChatColor.GREEN + "Fly speed set to 0.5X original.");
            return;
        }
        if (e.getPlayer().getItemInHand().getType() == Material.BEDROCK && e.getPlayer().isFlying()) {
            e.getPlayer().setFlySpeed((float) 0.2);
            e.getPlayer().sendMessage(ChatColor.GREEN + "Fly speed set to 2X original.");
        }*/
        return;
    }

}
