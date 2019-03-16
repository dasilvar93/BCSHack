package test;

import model.Plant;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.random;
import static persistance.Jsonifier.plantsToJson;


public class GeneratePlantData {

    private String folder = "./src/data/";
    private double centralLong = 49.261210;
    private double centralLat = -123.248383;
    private double cornerLong = 49.256268;
    private double cornerLat = -123.255120;
    private double maxLongVar = abs(centralLong - cornerLong);
    private double maxLatVar = abs(centralLat - cornerLat);

    @Test
    public void generateTestData() {
        String fileName = "appletrees.json";
        List<Plant> trees = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            trees.add(new Plant("apple", (centralLong + (random()-0.5) * 2 * maxLongVar),
                    centralLat + ((random()-0.5) * 2 * maxLatVar)));
        }
        for (int i = 0; i < 15; i++) {
            trees.add(new Plant("pear", (centralLong + (random()-0.5) * 2 * maxLongVar),
                    centralLat + ((random()-0.5) * 2 * maxLatVar)));
        }
        try {
            FileWriter file = new FileWriter(folder + fileName);
            file.write(plantsToJson(trees).toString());
            file.close();
        } catch (Exception e) {
            System.out.println("JSON write failed.");
        }
    }
}
