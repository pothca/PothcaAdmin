package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.*;
import plugin.filled_sky24811.info.pothcaadmin.PothcaAdmin;

public class pothca_admin implements CommandExecutor {
    String PluginMessage = ChatColor.AQUA + "[ Pothca Admin]";
    private final PothcaAdmin plugin;
    private final help help;
    private final reload reload;
    private final kick kick;
    private final fly fly;
    private final god god;
    private final vanish vanish;

    public pothca_admin(PothcaAdmin pothcaAdmin) {
        plugin = pothcaAdmin;
        help = new help();
        reload = new reload();
        kick = new kick();
        fly = new fly();
        god = new god();
        vanish = new vanish();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            return help.sendHelp(sender, cmd, label, args, plugin, PluginMessage);
        }

        if(args[0].equalsIgnoreCase("reload")) {
            return reload.reloadMethod(sender, plugin, PluginMessage);
        }

        if(args[0].equalsIgnoreCase("kick")) {
            return kick.kickPlayers(sender, args, PluginMessage);
        }

        if(args[0].equalsIgnoreCase("fly")) {
            return fly.flySystem(sender, args, PluginMessage);
        }

        if(args[0].equalsIgnoreCase("god")) {
            return god.godSystem(sender, args, PluginMessage);
        }

        if(args[0].equalsIgnoreCase("vanish")) {
            return vanish.vanishSystem(sender, args, PluginMessage);
        }

        return false;
    }
}
