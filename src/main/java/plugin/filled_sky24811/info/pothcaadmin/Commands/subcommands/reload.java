package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import plugin.filled_sky24811.info.pothcaadmin.PothcaAdmin;

public class reload {

    public boolean reloadMethod(CommandSender sender, PothcaAdmin plugin, String PluginMessage){
        plugin.reloadConfig();
        sender.sendMessage(PluginMessage + ChatColor.GREEN + "configをreloadしました");
        return true;
    }
}
