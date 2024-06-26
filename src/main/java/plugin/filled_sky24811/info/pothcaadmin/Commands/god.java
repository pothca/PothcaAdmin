package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
public class god implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("p-god")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "このコマンドはプレイヤーのみ実行可能です");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                return true;
            } else {
                if (args[0].equalsIgnoreCase("enable")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, Integer.MAX_VALUE, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 10));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 1));
                    sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "godモードが有効になりました");
                    return true;
                } else
                    if (args[0].equalsIgnoreCase("disable")) {
                        player.removePotionEffect(PotionEffectType.HEAL);
                        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                        player.removePotionEffect(PotionEffectType.SATURATION);
                        sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "godモードが無効になりました");
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                        return true;
                    }
            }
        }
        return true;
    }
}
