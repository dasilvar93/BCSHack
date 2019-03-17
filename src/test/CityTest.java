package test;

import model.City;
import model.Plant;
import model.Users.Eater;
import model.Users.Grower;
import model.Users.User;
import org.junit.jupiter.api.Test;
import parsers.PlantsParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CityTest {

    private List<Plant> plants = PlantsParser.parseDefault();
    private City vancouver = new City("Vancouver", 7);
    private User user1 = new Eater(49.261210, -123.248383, "Bob", vancouver);
    private User user2 = new Eater(49.262210, -123.247383, "Jim", vancouver);
    private User user3 = new Grower(49.261210, -123.248383, "Jane", vancouver);
    private User user4 = new Grower(49.262210, -123.247383, "Ellie", vancouver);

    @Test
    public void testAddPlantsToCity() {
        for (Plant p : plants) {
            vancouver.addPlant(p);
        }
        Plant plant = plants.get(0);
        plant.changeHarvestable();
        plant.readyToHarvest();
    }

    @Test
    public void testNotify() {
        List<User> users = vancouver.getUsers();
        assertFalse(plants.isEmpty());
        assertFalse(users.isEmpty());
        for (User u : users) {
            u.notify(plants.get(0), "harvest");
            u.notify(plants.get(0), "water");
        }
    }

}
