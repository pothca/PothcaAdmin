package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.vanishData;

import java.util.ArrayList;
import java.util.List;

public class vanish {
    double min = 0.1;
    double max = 2.00000;

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
            ((Player) sender).getWorld().spawnParticle(Particle.CLOUD, ((Player) sender).getLocation(), 50);
            List<Player> players = getNearbyPlayers((Player) sender);
            for(Player p : players){
                p.playSound(p, Sound.BLOCK_FIRE_EXTINGUISH,1, 1);
            }
            vanishData.setVanish(player.getUniqueId(), true);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "vanishを有効化しました");
            return true;
        } else if (args[1].equalsIgnoreCase("disable")) {
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(player);
            }
            List<Player> players = getNearbyPlayers((Player) sender);
            for(Player p : players){
                p.playSound(p, Sound.BLOCK_FIRE_EXTINGUISH,1, 1);
            }
                ((Player) sender).getWorld().spawnParticle(Particle.CLOUD, ((Player) sender).getLocation(), 50);
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

    public static List<Player> getNearbyPlayers(Player player) {
        List<Player> nearbyPlayers = new ArrayList<>();
        Location playerLocation = player.getLocation();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getLocation().distance(playerLocation) <= 3) {
                nearbyPlayers.add(onlinePlayer);
            }
        }
        return nearbyPlayers;
    }
}
