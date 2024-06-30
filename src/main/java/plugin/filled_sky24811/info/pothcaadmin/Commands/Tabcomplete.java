package plugin.filled_sky24811.info.pothcaadmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tabcomplete implements TabCompleter {
    private static final List<String> FIRST_ARGS = Arrays.asList("help", "reload", "kick", "fly", "god", "vanish");
    private static final List<String> booleanFLAGS = Arrays.asList("enable", "disable");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if(args.length == 1) {
            for(String arg : FIRST_ARGS) {
                if(arg.startsWith(args[0].toLowerCase())) {
                    completions.add(arg);
                }
            }
        } else if (args.length == 2) {

            if(args[0].equalsIgnoreCase("kick")) {
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(player.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
                        completions.add(player.getName());
                    }
                }
                completions.add("all_members");
            }

            if(args[0].equalsIgnoreCase("fly")) {
                for(String arg : booleanFLAGS){
                    if(arg.toLowerCase().startsWith(args[1].toLowerCase())) {
                        completions.add(arg);
                    }
                }
            }

            if(args[0].equalsIgnoreCase("god")) {
                for(String arg : booleanFLAGS){
                    if(arg.toLowerCase().startsWith(args[1].toLowerCase())) {
                        completions.add(arg);
                    }
                }
            }

            if(args[0].equalsIgnoreCase("vanish")) {
                for(String arg : booleanFLAGS){
                    if(arg.toLowerCase().startsWith(args[1].toLowerCase())) {
                        completions.add(arg);
                    }
                }
            }

        }
        return completions;
    }
}
