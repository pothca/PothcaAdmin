package plugin.filled_sky24811.info.pothcaadmin.EventListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.fly;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.god;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.vanish;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.godData;

public class EventListener implements Listener {
    private final vanish vanish;
    private final god god;
    private final fly fly;

    public EventListener(vanish vanish, god god, fly fly) {
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

    @EventHandler
    public void playerTargeted(EntityTargetEvent event) {
        if(!(event.getTarget() instanceof Player)) return;
        if(godData.isGod(event.getTarget().getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void damageReceived(EntityDamageEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        if(event.getCause() != EntityDamageEvent.DamageCause.FALL) return;
        if(godData.isGod(event.getEntity().getUniqueId())){
            event.getEntity().setFallDistance(0);
            event.setCancelled(true);
        }
    }
}
