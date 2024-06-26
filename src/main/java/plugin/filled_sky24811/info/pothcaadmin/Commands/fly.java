package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("p-fly")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "このコマンドはプレイヤーのみ実行可能です");
                return true;
            }
            Player player = (Player) sender;
            if(args.length == 0){
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                return true;
            }
            if(args[0].equalsIgnoreCase("enable")){
                player.setAllowFlight(true);
                player.setFlying(true);
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "flyモードが有効になりました");
                return true;
            }else if(args[0].equalsIgnoreCase("disable")){
                player.setFlying(false);
                player.setAllowFlight(false);
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "flyモードが無効になりました");
                return true;
            }else{
                sender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "enableかdisableを指定してください");
                return true;
            }
        }
        return false;
    }
}
