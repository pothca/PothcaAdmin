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
import java.util.concurrent.ConcurrentHashMap;

public class flyData {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File flyFile = new File("plugins/PothcaAdmin/flyData.json");
    private static final Map<UUID, Boolean> flyMap = new HashMap<>();

    public static void saveFlyData() {
        try {
            if (!flyFile.getParentFile().exists()) {
                flyFile.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(flyFile)) {
                gson.toJson(flyMap, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFlyData() {
        if (!flyFile.exists()) {
            return;
        }

        try (FileReader reader = new FileReader(flyFile)) {
            flyMap.clear();
            flyMap.putAll(gson.fromJson(reader, ConcurrentHashMap.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setFly(UUID uuid, boolean fly) {
        flyMap.put(uuid, fly);
        saveFlyData();
    }

    public static boolean isFly(UUID uuid) {
        return flyMap.getOrDefault(uuid, false);
    }
}
