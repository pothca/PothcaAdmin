package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.vanishData;

public class vanish {

    public boolean vanishSystem(CommandSender sender, String[] args, String PluginMessage) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "このコマンドはプレイヤー専用です！");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
            return true;
        }

        Player player = (Player) sender;

        if (args[1].equalsIgnoreCase("enable")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.equals(player)) {
                    onlinePlayer.hidePlayer(player);
                }
            }
            vanishData.setVanish(player.getUniqueId(), true);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "vanishを有効化しました");
            return true;
        } else if (args[1].equalsIgnoreCase("disable")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(player);
            }
            vanishData.setVanish(player.getUniqueId(), false);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "vanishを無効化しました");
            return true;
        } else {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
            return true;
        }
    }
    public void handlePlayerJoin(Player player) {
        if (vanishData.isVanished(player.getUniqueId())) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.equals(player)) {
                    onlinePlayer.hidePlayer(player);
                }
            }
        }
    }
}
