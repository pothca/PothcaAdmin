package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class allkick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("p-allkick")){
            for (Player player : Bukkit.getOnlinePlayers()){
                player.kickPlayer("管理者によってサーバーから強制退出されました。");
            }
        }
        return true;
    }
}