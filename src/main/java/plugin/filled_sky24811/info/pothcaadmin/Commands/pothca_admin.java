package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.help;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.reload;
import plugin.filled_sky24811.info.pothcaadmin.PothcaAdmin;

public class pothca_admin implements CommandExecutor {
    String PluginMessage = ChatColor.AQUA + "[ Pothca Admin]";
    private PothcaAdmin plugin;
    private help help;
    private reload reload;

    public pothca_admin(PothcaAdmin pothcaAdmin) {
        plugin = pothcaAdmin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            help.sendHelp(sender, cmd, label, args, plugin, PluginMessage);
            return true;
        }

        if(args[0].equalsIgnoreCase("reload")) {
            reload.reloadMethod(sender, plugin, PluginMessage);
            return true;
        }

        if(args[0].equalsIgnoreCase("kick")) {

        }

        return false;
    }
}
