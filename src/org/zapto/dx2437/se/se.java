package org.zapto.dx2437.se;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Set;

public class se implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("plugin_test.use")) {
                sender.sendMessage(ChatColor.RED + "Permission denied.");
                return true;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                return false;
            }
            if (!(player.getTargetBlock((Set<Material>) null, 100).getType() == Material.SIGN_POST) &&
                !(player.getTargetBlock((Set<Material>) null, 100).getType() == Material.WALL_SIGN)) {
                player.sendMessage("That's not a sign!");
                return true;
            }
            Sign sign = (Sign) player.getTargetBlock((Set<Material>) null, 100).getState();
            if (args.length == 1) {
                sign.setLine(Integer.parseInt(args[0])-1, "");
            } else {
                String data = args[1];
                int len = args.length;
                for (int i=1; i<len-1; i++) {
                    data = data +  " " + args[i+1];
                }
                int index;
                try {
                    index = Integer.parseInt(args[0]);
                    sign.setLine(index-1, data);
                } catch (NumberFormatException e) {
                    player.sendMessage("a");
                    return true;
                }
            }
            sign.update();
        } else {
            sender.sendMessage(ChatColor.RED + "This command cannot be used in console.");
        }
        return true;
    }
}
