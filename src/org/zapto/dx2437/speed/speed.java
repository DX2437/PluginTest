package org.zapto.dx2437.speed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class speed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("plugin_test.use")) {
                sender.sendMessage(ChatColor.RED + "Permission denied.");
                return true;
            }
            Player player = (Player) sender;
            Float f = (float) 0.1;
            if (args.length >= 1) {
                float temp = Float.parseFloat(args[0]);
                if (temp >= 0 && temp <= 10) {
                    f = temp/10;
                } else {
                    player.sendMessage(ChatColor.RED + "Please only input value between 0 and 10.");
                    return true;
                }
            }
            player.setFlySpeed(f);
            player.sendMessage(ChatColor.GREEN + "Fly speed set to " + Math.round(f/0.1) + "X original.");
        } else {
            sender.sendMessage(ChatColor.RED + "This command cannot be used in console.");
        }
        return true;
    }
}
