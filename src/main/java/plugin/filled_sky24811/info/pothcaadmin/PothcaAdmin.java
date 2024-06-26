package plugin.filled_sky24811.info.pothcaadmin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.filled_sky24811.info.pothcaadmin.Commands.*;

public final class PothcaAdmin extends JavaPlugin {


    public static PothcaAdmin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getCommand("pothca_admin").setExecutor(new pothca_admin(this));

        Bukkit.getLogger().info("[PothcaAdminPlugin] が起動されました");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        Bukkit.getLogger().info("[PothcaAdminPlugin] が終了しました");
    }
    public static PothcaAdmin getInstance(){
        return instance;
    }
}