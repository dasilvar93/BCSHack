package parsers;

import model.Plant;
import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static parsers.PlantParser.jsonToPlant;

public class PlantsParser {

    public static List<Plant> jsonToPlants(String input) {
        JSONArray plantsJson = new JSONArray(input);
        List<Plant> plants = new ArrayList<>();
        for (Object o : plantsJson) {
            plants.add(jsonToPlant(o.toString()));
        }
        return plants;
    }

    public static List<Plant> parseDefault() {
        String plantDataPath = "./src/data/appletrees.json";
        try {
            String plantsJson = new String(Files.readAllBytes(Paths.get(plantDataPath)));
            List<Plant> plants = jsonToPlants(plantsJson);
            return plants;
        } catch (Exception e) {
            System.out.println("Default plant data parser failed.");
            return new ArrayList<>();
        }
    }
}