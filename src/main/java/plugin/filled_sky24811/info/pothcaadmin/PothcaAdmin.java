package plugin.filled_sky24811.info.pothcaadmin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.filled_sky24811.info.pothcaadmin.Commands.*;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.fly;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.god;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.vanish;
import plugin.filled_sky24811.info.pothcaadmin.EventListener.EventListener;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.flyData;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.godData;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.vanishData;

public final class PothcaAdmin extends JavaPlugin {

    public static PothcaAdmin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        vanishData.loadVanishData();
        godData.loadGodData();
        flyData.loadFlyData();
        vanish vanish = new vanish();
        god god = new god();
        fly fly = new fly();

        getCommand("pothca_admin").setExecutor(new pothca_admin(this));
        getCommand("pothca_admin").setTabCompleter(new Tabcomplete());

        Bukkit.getLogger().info("[PothcaAdminPlugin]が起動されました");
        getServer().getPluginManager().registerEvents(new EventListener(vanish, god, fly), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        vanishData.saveVanishData();
        godData.saveGodData();
        flyData.saveFlyData();
        Bukkit.getLogger().info("[PothcaAdminPlugin]が終了しました");
    }
    public static PothcaAdmin getInstance(){
        return instance;
    }
}