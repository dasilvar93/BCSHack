package model;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plant {

    private String species;
    private Double longitude;
    private Double latitude;
    private List<Image> images;
    private LocalDate datePlanted;
    private String comments;
    private Status healthStatus;
    private Boolean harvestable;
    private Boolean mature;

     public Plant(String species, Double longitude, Double latitude) {
        this.species = species;
        this.latitude = latitude;
        this.longitude = longitude;
        images = new ArrayList<>();
        datePlanted = LocalDate.now();
        healthStatus = Status.HEALTHY;
        harvestable = false;
        mature = true;
    }

    public Double getLong() {
         return longitude;
    }

    public Double getLat() {
         return latitude;
    }

}
