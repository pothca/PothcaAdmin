package plugin.filled_sky24811.info.pothcaadmin.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getServer;


public class playerlocation implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("p-playerlocation")){
            Player p = (Player) commandSender;

            if(strings.length == 0){
                commandSender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "プレイヤー名を入力してください。");
                return true;
            }
            Player target = getServer().getPlayerExact(strings[0]);
            if(target != null && target.isOnline()){
                int x = (int) target.getLocation().getX();
                int y = (int) target.getLocation().getY();
                int z = (int) target.getLocation().getZ();
                p.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + strings[0] + "の座標は" + x + "," + y + "," + z + "です。");
            }
            else{
                commandSender.sendMessage(ChatColor.RED + "[Information] " + ChatColor.AQUA + "プレイヤー名を入力してください。");
            }
            return true;
        }
        return false;
    }
}