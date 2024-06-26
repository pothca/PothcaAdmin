package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class vanish implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("p-vanish")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみ実行可能です");
                return true;
            }
            Player player = (Player) sender;
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                return true;
            }
            if (args[0].equalsIgnoreCase("enable")) {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (!onlinePlayer.equals(player)) {
                        onlinePlayer.hidePlayer(player);
                    }
                }
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "vanishモードが有効になりました");
                return true;
            } else
                if (args[0].equalsIgnoreCase("disable")) {
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (!onlinePlayer.equals(player)) {
                            onlinePlayer.showPlayer(player);
                        }
                    }
                    sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "vanishモードが無効になりました");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                }
        }
        return false;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player newPlayer = event.getPlayer();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.equals(newPlayer)) {
                onlinePlayer.hidePlayer(newPlayer);
            }
            if (!newPlayer.equals(onlinePlayer)) {
                newPlayer.hidePlayer(onlinePlayer);
            }
        }
    }
}