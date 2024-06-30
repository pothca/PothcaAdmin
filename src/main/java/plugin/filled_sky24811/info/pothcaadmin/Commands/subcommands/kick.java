package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kick {

    public boolean kickPlayers(CommandSender sender, String[] args, String PluginMessage) {
        if (args.length == 1) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "Player名/all_members を入力してください");
            return true;
        }
        if (args.length == 2) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "Reasonを入力してください");
            return true;
        }
        if (args.length == 3) {
            Player player = Bukkit.getPlayer(args[1]);
            if (player != null && player.isOnline()) {
                player.kickPlayer(args[2]);
                sender.sendMessage(PluginMessage + ChatColor.GREEN + player.getName() + " をkickしました");
            } else if (args[1].equalsIgnoreCase("all_members")) {
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    p.kickPlayer(args[2]);
                }
                sender.sendMessage(PluginMessage + ChatColor.GREEN + "全プレイヤーをkickしました");
            } else {
                sender.sendMessage(PluginMessage + ChatColor.RED + "プレイヤーが見つかりませんでした");
            }
        }
        return false;
    }
}
