package model;

import model.Users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {
    private String name;
    private Integer zone;
    private HashMap<String, List<Plant>> plants;
    private List<User> users;
    private static final Double NEAR_THRESHOLD = 1000.00; //metres


    public City(String name, Integer zone) {
        this.name = name;
        this.zone = zone;
        plants = new HashMap<>();
        users = new ArrayList<>();
    }

    public List<Plant> getPlants(Double maxLong, Double minLong, Double maxLat, Double minLat) {
        List<Plant> returnPlants = new ArrayList<>();
        for (List<Plant> list: plants.values()) {
            for (Plant p: list) {
                if (withinThreshold(p, maxLong, minLong, maxLat, minLat)) {
                    returnPlants.add(p);
                }
            }
        }
        return returnPlants;
    }

    public void addUser(User user){
        if (!users.contains(user)) {
            users.add(user);
            user.changeCity(this);
        }
    }

    public void removeUser(User user){
        if (users.contains(user)){
            users.remove(user);
            user.changeCity(null);
        }
    }

    public List<User> usersNear(Double longitude, Double latitude) {

        List<User> returnUsers = new ArrayList<>();
        Double maxLong = longitude + (NEAR_THRESHOLD/2);
        Double minLong = longitude - (NEAR_THRESHOLD/2);
        Double maxLat = latitude + (NEAR_THRESHOLD/2);
        Double minLat = latitude - (NEAR_THRESHOLD/2);

        for (User u: users) {
            if (u.getClass().getName().equals("Grower")){
                if (withinThreshold(u, maxLong, minLong, maxLat, minLat)) {
                    returnUsers.add(u);
                }
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

}
