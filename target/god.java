package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import plugin.filled_sky24811.info.pothcaadmin.PothcaAdmin;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class god implements CommandExecutor {
    private List<UUID> godPlayers = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("p-god")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "[Information]　このコマンドはプレイヤーのみ実行可能です");
                return true;
            }
            Player player = (Player) sender;
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "[Information]　" + ChatColor.AQUA + "enableかdisableか指定してください");
                return true;
            } else {
                if (args[0].equalsIgnoreCase("enable")) {
                    godPlayers.add(((Player) sender).getUniqueId());
                    sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "godモードが有効になりました");
                    return true;
                } else
                    if (args[0].equalsIgnoreCase("disable")) {
                        godPlayers.remove(((Player) sender).getUniqueId());
                        sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "godモードが無効になりました");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                        return true;
                    }
            }
        }
        new BukkitRunnable(){
            @Override
            public void run(){
                for(UUID uuid : godPlayers){
                    Player godPlayer = Bukkit.getPlayer(uuid);
                    if(godPlayer != null){
                        godPlayer.setFoodLevel(Math.min(godPlayer.getFoodLevel() + 20, 20));
                        godPlayer.setSaturation(Math.min(godPlayer.getSaturation() + 20, 20));
                        godPlayer.setHealth(Math.min(godPlayer.getHealth() + 20, 20));
                    }
                }
            }
        }.runTaskTimer(PothcaAdmin.getInstance(),0L,200L);
        return false;
    }
}