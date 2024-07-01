package plugin.filled_sky24811.info.pothcaadmin.Jsons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class vanishData {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File vanishFile = new File("plugins/PothcaAdmin/vanishData.json");
    private static final Map<UUID, Boolean> vanishMap = new ConcurrentHashMap<>();

    public static void saveVanishData() {
        try {
            if (!vanishFile.getParentFile().exists()) {
                vanishFile.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(vanishFile)) {
                gson.toJson(vanishMap, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadVanishData() {
        if (!vanishFile.exists()) {
            return;
        }

        try (FileReader reader = new FileReader(vanishFile)) {
            vanishMap.clear();
            vanishMap.putAll(gson.fromJson(reader, ConcurrentHashMap.class));
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
