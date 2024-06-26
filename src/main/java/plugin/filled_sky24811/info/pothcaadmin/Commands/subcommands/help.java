package plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import plugin.filled_sky24811.info.pothcaadmin.PothcaAdmin;

public class help {

    public void sendHelp(CommandSender sender, Command cmd, String label, String[] args, PothcaAdmin plugin, String PluginMessage){
        sender.sendMessage(ChatColor.AQUA +
                "------Pothca Admin Help------\n" + ChatColor.RESET +
                "/pothca_admin help\n" +  ChatColor.GRAY +
                "コマンドのヘルプを表示します\n" + ChatColor.RESET +
                "/pothca_admin reload\n" + ChatColor.GRAY +
                "configファイルをreloadします\n" + ChatColor.RESET +
                ""
        );
    }
}
