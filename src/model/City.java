package model;

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


}
