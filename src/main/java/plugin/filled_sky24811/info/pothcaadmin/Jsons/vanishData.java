package plugin.filled_sky24811.info.pothcaadmin.Jsons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class vanishData {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File file = new File("plugins/PothcaAdmin/vanishData.json");
    private static Map<UUID, Boolean> vanishMap = new HashMap<>();

    public static void saveVanishData() {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(vanishMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadVanishData() {
        if (!file.exists()) {
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            vanishMap = gson.fromJson(reader, vanishMap.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setVanish(UUID uuid, boolean vanish) {
        vanishMap.put(uuid, vanish);
        saveVanishData();
    }

    public static boolean isVanished(UUID uuid) {
        return vanishMap.getOrDefault(uuid, false);
    }
}
