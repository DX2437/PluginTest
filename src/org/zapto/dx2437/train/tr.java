package org.zapto.dx2437.train;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tr implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("plugin_test.use")) {
                sender.sendMessage(ChatColor.RED + "Permission denied.");
                return true;
            }
            ((Player) sender).performCommand("train remove");
            //sender.sendMessage(ChatColor.GREEN + "Shortcut of \"/train remove\" used.");
        } else {
            sender.sendMessage(ChatColor.RED + "This command cannot be used in console.");
        }
        return true;
    }
}
