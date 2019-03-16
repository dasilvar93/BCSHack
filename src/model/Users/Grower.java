package model.Users;

import model.City;
import model.Plant;

public class Grower extends User {


    public Grower() {
        super();
    }


    public Grower(Double longitude, Double latitude, String name, City city) {
        super(longitude, latitude, name, city);
    }

    public void notify(Plant plant, String message) {
        if (message.equalsIgnoreCase("water")) {
            System.out.println(plant.getSpecies() + "needs to be watered!");
        }
    }

}
