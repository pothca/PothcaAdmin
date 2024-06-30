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

public class godData {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final File godFile = new File("plugins/PothcaAdmin/godFile.json");
    private static Map<UUID, Boolean> godMap = new HashMap<>();

    public static void saveVanishData() {
        try {
            if (!godFile.getParentFile().exists()) {
                godFile.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(godFile)) {
                gson.toJson(godMap, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGodData() {
        if (!godFile.exists()) {
            return;
        }

        try (FileReader reader = new FileReader(godFile)) {
            godMap = gson.fromJson(reader, godMap.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGod(UUID uuid, boolean god) {
        godMap.put(uuid, god);
        saveVanishData();
    }

    public static boolean isGod(UUID uuid) {
        return godMap.getOrDefault(uuid, false);
    }
}
