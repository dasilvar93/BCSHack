package model.Ui.Users;

import model.City;
import model.Plant;

public class Eater extends User {

    public Eater() {
        super();
    }

    public Eater(Double longitude, Double latitude, String name, City city){
        super(longitude, latitude, name, city);
    }

    public void notify(Plant plant, String message) {
        if (message.equalsIgnoreCase("harvest")) {
            System.out.println(plant.getSpecies() + " is ready to harvest!");
        }
    }
}
