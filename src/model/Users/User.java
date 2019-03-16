package model.Users;

import model.City;
import model.Plant;

import java.util.List;

public abstract class User {

    private City city;
    private Double longitude;
    private Double latitude;
    private String name;
    private static final Double NEAR_THRESHOLD = 1000.00; //metres


    public User(Double longitude, Double latitude, String name, City city){
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public List<Plant> plantsNear(){
        return null;
    }

}
