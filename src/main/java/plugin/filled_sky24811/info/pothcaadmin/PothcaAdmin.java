package plugin.filled_sky24811.info.pothcaadmin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.filled_sky24811.info.pothcaadmin.Commands.*;
import plugin.filled_sky24811.info.pothcaadmin.Commands.subcommands.vanish;
import plugin.filled_sky24811.info.pothcaadmin.EventListener.PlayerJoinListener;
import plugin.filled_sky24811.info.pothcaadmin.Jsons.vanishData;

public final class PothcaAdmin extends JavaPlugin {


    public static PothcaAdmin instance;
    private vanish vanish;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        vanishData.loadVanishData();
        vanish = new vanish();
        getCommand("pothca_admin").setExecutor(new pothca_admin(this));
        getCommand("pothca_admin").setTabCompleter(new Tabcomplete());

        Bukkit.getLogger().info("[PothcaAdminPlugin]が起動されました");
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(vanish), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        vanishData.saveVanishData();
        Bukkit.getLogger().info("[PothcaAdminPlugin]が終了しました");
    }
    public static PothcaAdmin getInstance(){
        return instance;
    }
}