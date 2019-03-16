package test;

import model.City;
import model.Plant;
import model.Users.Eater;
import model.Users.User;
import parsers.PlantsParser;

import java.util.List;

public class CityTest {

    List<Plant> plants = PlantsParser.parseDefault();
    City vancouver = new City("Vancouver", 7);
    User user1 = new Eater(49.261210, -123.248383, "Bob", vancouver);
    User user2 = new Eater(49.262210, -123.247383, "Jim", vancouver);

}
