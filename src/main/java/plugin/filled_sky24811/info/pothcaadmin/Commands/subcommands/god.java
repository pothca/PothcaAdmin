package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class god {

    public boolean godSystem(CommandSender sender, String[] args, String PluginMessage){
        if(!(sender instanceof Player)){
            sender.sendMessage(PluginMessage + ChatColor.RED + "このコマンドはプレイヤー専用です！");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
            return true;
        }
        Player player = (Player) sender;

        if (args[1].equalsIgnoreCase("enable")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INSTANT_HEALTH, Integer.MAX_VALUE, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, Integer.MAX_VALUE, 10));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 1));
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "godを有効化しました");
            return true;
        } else if (args[1].equalsIgnoreCase("disable")) {
            player.removePotionEffect(PotionEffectType.INSTANT_HEALTH);
            player.removePotionEffect(PotionEffectType.RESISTANCE);
            player.removePotionEffect(PotionEffectType.SATURATION);
            sender.sendMessage(PluginMessage + ChatColor.GREEN + "godを無効化しました");
            return true;
        } else {
            sender.sendMessage(PluginMessage + ChatColor.RED + "enableかdisableを指定してください！");
            return true;
        }
    }
}
