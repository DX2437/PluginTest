package org.zapto.dx2437.ci;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class ci implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p;
        boolean flag = false;
        if (args.length >= 1) {
            p = Bukkit.getServer().getPlayer(args[0]);
        } else {
            if (sender instanceof Player) {
                if (!sender.hasPermission("plugin_test.use")) {
                    sender.sendMessage(ChatColor.RED + "Permission denied.");
                    return true;
                }
                p = (Player) sender;
                flag = true;
            } else {
                sender.sendMessage(ChatColor.RED + "Cannot clear Console's inventory.");
                return true;
            }
        }
        if (p == null) {
            sender.sendMessage(ChatColor.RED + "Could not find player: " + args[0]);
            return true;
        }
        p.getInventory().clear();
        if (p == sender) {
            flag = true;
        }
        if (flag) {
            p.sendMessage(ChatColor.GREEN + "You cleared your inventory.");
        } else {
            p.sendMessage(ChatColor.GREEN + "Your inventory has been cleared.");
            sender.sendMessage(ChatColor.GREEN + "You cleared " + p.getName() + "'s inventory.");
        }
        return true;
    }
}