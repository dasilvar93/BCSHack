package model;

import model.Ui.Users.User;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plant {

    private City city;
    private String species;
    private Double longitude;
    private Double latitude;
    private List<Image> images;
    private LocalDate datePlanted;
    private List<String> comments;
    private Status healthStatus;
    private Boolean harvestable;
    private Boolean mature;
    private Long daysToHarvest;
    private Long waterFrequency; //days
    private LocalDate dateLastWatered;

     public Plant(String species, Double longitude, Double latitude) {
        this.species = species;
        this.latitude = latitude;
        this.longitude = longitude;
        images = new ArrayList<>();
        datePlanted = LocalDate.now();
        healthStatus = Status.HEALTHY;
        harvestable = false;
        mature = true;
        comments = new ArrayList<>();
        dateLastWatered = LocalDate.now();

    }

    public Double getLong() {
         return longitude;
    }

    public Double getLat() {
         return latitude;
    }

    public String getSpecies(){
         return this.species;
    }

    public Status getStatus() {
         return this.healthStatus;
    }

    public Boolean isMature() {
         return this.mature;
    }

    public Long getWaterFreq() {
         return this.waterFrequency;
    }

    public LocalDate getDateLastWatered() {
         return this.dateLastWatered;
    }

    public void changeDate(LocalDate date) {
         this.datePlanted = date;
    }

    public void changeStatus(Status status){
         this.healthStatus = status;
    }

    public void changeHarvestable() {
         if (harvestable) {
             harvestable = false;
         } else {
             harvestable = true;
         }
    }

    public void changeDaysToHarvest(Long days){
         this.daysToHarvest = days;
    }

    public void changeCity(City city) {
         this.city = city;
         city.addPlant(this);
    }

    public void makeHarvestable() {
          LocalDate today = LocalDate.now();
          if (today.isAfter(datePlanted.plusDays(daysToHarvest))){
              harvestable = true;
          }
    }

    public void addComment(String comment){
         comments.add(comment);
    }

    public void changeWaterFreq(Long days) {
         this.waterFrequency = days;
    }

    public void setDateLastWatered(LocalDate date) {
             dateLastWatered = date;
    }
    public void watered(){
         dateLastWatered = LocalDate.now();
    }

    public void needWater() {
         LocalDate dateToWater = dateLastWatered.plusDays(waterFrequency);
         LocalDate today = LocalDate.now();

         if (today.isAfter(dateToWater)) {
             for (User u: city.usersNear(longitude, latitude)) {
                 u.notify(this, "water");
             }
         }
    }

    public void readyToHarvest() {
         if (harvestable) {
             for (User u: city.usersNear(longitude, latitude)) {
                 u.notify(this, "harvest");
             }
         }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(species, plant.species) &&
                Objects.equals(longitude, plant.longitude) &&
                Objects.equals(latitude, plant.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, longitude, latitude);
    }
}
