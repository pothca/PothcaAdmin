package plugin.filled_sky24811.info.pothcaadmin.EventListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.fly;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.god;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.vanish;

public class PlayerJoinListener implements Listener {
    private final vanish vanish;
    private final god god;
    private final fly fly;

    public PlayerJoinListener(vanish vanish, god god, fly fly) {
        this.vanish = vanish;
        this.god = god;
        this.fly = fly;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        vanish.handlePlayerJoin(event.getPlayer());
        god.handlePlayerJoin(event.getPlayer());
        fly.handlePlayerJoin(event.getPlayer());
    }
}
