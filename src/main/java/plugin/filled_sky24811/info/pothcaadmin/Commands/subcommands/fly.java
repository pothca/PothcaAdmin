package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly {

    public boolean flySystem(CommandSender sender, String[] args, String PluginMessage) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "このコマンドはプレイヤー専用です！");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
        }
        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("enable")) {
            player.setAllowFlight(true);
            player.setFlying(true);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "flyを有効化しました");
            return true;
        } else if (args[0].equalsIgnoreCase("disable")) {
            player.setAllowFlight(false);
            player.setFlying(false);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "flyを無効化しました");
            return true;
        } else {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
            return true;
        }
    }
}