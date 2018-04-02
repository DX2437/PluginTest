package org.zapto.dx2437.cmd;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("plugin_test.use")) {
                sender.sendMessage(ChatColor.RED + "Permission denied.");
                return true;
            }
            Player player = (Player) sender;
            ItemStack cmd;
            if (args.length >= 1) {
                cmd = new ItemStack(Material.COMMAND, Integer.parseInt(args[0]));
            } else {
                cmd = new ItemStack(Material.COMMAND);
            }
            player.getInventory().addItem(cmd);
        } else {
            sender.sendMessage(ChatColor.RED + "This command cannot be used in console.");
        }


        return true;
    }
}
