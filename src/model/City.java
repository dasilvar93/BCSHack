package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {
    public String name;
    public Integer zone;
    public HashMap<String, List<Plant>> plants;

    public City(String name, Integer zone) {
        this.name = name;
        this.zone = zone;
        plants = new HashMap<>();
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

    private Boolean withinThreshold(Plant p, Double maxLong, Double minLong, Double maxLat, Double minLat) {
        return (p.getLong() <= maxLong) && (p.getLong() >= minLong) && (p.getLat() <= maxLat) && (p.getLat() >= minLat);
    }


}
