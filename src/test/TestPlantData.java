package test;

import model.Plant;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static parsers.PlantsParser.jsonToPlants;

public class TestPlantData {

    @Test
    public void testPlantParsing() {
        String plantDataPath = "./src/data/appletrees.json";
        try {
            String plantsJson = new String(Files.readAllBytes(Paths.get(plantDataPath)));
            List<Plant> plants = jsonToPlants(plantsJson);
            System.out.println(plants.get(0).getSpecies());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("huge failure!");
        }
    }
}
