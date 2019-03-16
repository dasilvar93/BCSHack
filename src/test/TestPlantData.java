package test;

import model.Plant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static parsers.PlantsParser.parseDefault;

public class TestPlantData {

    @Test
    public void testPlantParsing() {
        List<Plant> trees = parseDefault();
        System.out.println(trees.get(0).getSpecies());
        System.out.println(trees.get(0).getLong());
        System.out.println(trees.get(0).getLat());
    }
}
