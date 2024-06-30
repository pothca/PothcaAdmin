package plugin.filled_sky24811.info.pothcaadmin.EventListener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.vanish;

public class PlayerJoinListener implements Listener {
    private final vanish vanish;

    public PlayerJoinListener(vanish vanish) {
        this.vanish = vanish;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        vanish.handlePlayerJoin(event.getPlayer());
    }
}
