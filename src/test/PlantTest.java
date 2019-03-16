package test;

import model.Plant;
import org.junit.jupiter.api.Test;

public class PlantTest {

    private Plant plant = new Plant("apple", 0.0, 0.0);

    @Test
    public void testNotification() {
        plant.changeHarvestable();
    }
}
