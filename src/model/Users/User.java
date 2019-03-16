package model.Users;

import model.City;
import model.Plant;

import java.util.List;
import java.util.Objects;

public abstract class User {

    private City city;
    private Double longitude;
    private Double latitude;
    private String name;
    private static final Double NEAR_THRESHOLD = 1000.00; //metres

    public User(){

    }


    public User(Double longitude, Double latitude, String name, City city){
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.city = city;
        this.city.addUser(this);
    }

    public List<Plant> AllPlantsNear(){
        Double maxLong = longitude + (NEAR_THRESHOLD/2);
        Double minLong = longitude - (NEAR_THRESHOLD/2);
        Double maxLat = latitude + (NEAR_THRESHOLD/2);
        Double minLat = latitude - (NEAR_THRESHOLD/2);

        return this.city.getPlants(maxLong, minLong, maxLat, minLat);
    }

    public List<Plant> plantTypeNear() {
        return null;
    }

    public void changeCity(City city) {
        this.city = city;
    }

    public Double getLong() {
        return this.longitude;
    }

    public Double getLat() {
        return this.latitude;
    }

    public abstract void notify(Plant plant, String message);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
