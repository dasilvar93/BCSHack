package model;

import model.Users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {
    private String name;
    private Integer zone;
    private List<Plant> plants;
    private List<User> users;
    private static final Double NEAR_THRESHOLD = 1000.00; //metres
    private HashMap<LocalDate, Integer> rainfallRecord; //mm
    private static final Integer RAINFALL_THRESHOLD = 5;


    public City(String name, Integer zone) {
        this.name = name;
        this.zone = zone;
        plants = new ArrayList<>();
        users = new ArrayList<>();
        rainfallRecord = new HashMap<>();
    }

    public List<Plant> getPlants(Double maxLong, Double minLong, Double maxLat, Double minLat) {
        List<Plant> returnPlants = new ArrayList<>();
        for (Plant p : plants) {
            if (withinThreshold(p, maxLong, minLong, maxLat, minLat)) {
                returnPlants.add(p);
            }
        }

        return returnPlants;
    }

    public void addRainfall(LocalDate date, Integer amount) {
        rainfallRecord.put(date, amount);
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.changeCity(this);
        }
    }

    public void removeUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
            user.changeCity(null);
        }
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void addPlant(Plant plant) {
        if(!plants.contains(plant)){
            plants.add(plant);
            plant.changeCity(this);
        }
    }

    public void removePlant(Plant plant) {
        if(plants.contains(plant)){
            plants.remove(plant);
            plant.changeCity(null);
        }
    }

    public List<User> usersNear(Double longitude, Double latitude) {

        List<User> returnUsers = new ArrayList<>();
        Double maxLong = longitude + (NEAR_THRESHOLD / 2);
        Double minLong = longitude - (NEAR_THRESHOLD / 2);
        Double maxLat = latitude + (NEAR_THRESHOLD / 2);
        Double minLat = latitude - (NEAR_THRESHOLD / 2);

        for (User u : users) {
            if (withinThreshold(u, maxLong, minLong, maxLat, minLat)) {
                returnUsers.add(u);
            }
        }

        return returnUsers;

    }

    private Boolean withinThreshold(Plant p, Double maxLong, Double minLong, Double maxLat, Double minLat) {
        return (p.getLong() <= maxLong) && (p.getLong() >= minLong) && (p.getLat() <= maxLat) && (p.getLat() >= minLat);
    }

    private Boolean withinThreshold(User u, Double maxLong, Double minLong, Double maxLat, Double minLat) {
        return (u.getLong() <= maxLong) && (u.getLong() >= minLong) && (u.getLat() <= maxLat) && (u.getLat() >= minLat);
    }

    public void waterFromRainfall() {
        if (rainfallRecord.get(LocalDate.now()) >= RAINFALL_THRESHOLD) {

            for (Plant p : plants) {
                p.watered();
            }
        }
    }


}
