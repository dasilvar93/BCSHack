package model;

import model.Ui.MainUi;
import model.Ui.growPanel.PlantStatusPanel;

import java.io.IOException;
import java.util.Scanner;

public class UrbanGrowers {
    private static MainUi ui;
    public static City newCity;
    public static Boolean gottenPlantHarvestable;
    public static String gottenPlantSpecies;


    public static void main(String[] args) throws IOException {
        System.out.print("UrbanGrowers has started" + "\n");
        newCity = new City("Vancouver", 1);

        ui = new MainUi();

        System.out.println("Name your plant: ");
        Scanner scanner = new Scanner(System.in);
        String plantTy = scanner.nextLine();

        for (Plant p: newCity.plants) {
            if (p.getSpecies() == plantTy) {
                gottenPlantHarvestable = p.harvestable;
                gottenPlantSpecies = p.getSpecies();
            }
        }
        System.out.println("Plant is harvestable: " + gottenPlantHarvestable);

        PlantStatusPanel.textArea.append("Plant type is: " + gottenPlantHarvestable + "\n");
        PlantStatusPanel.textArea.append("Plant is harvestable: " + gottenPlantHarvestable  + "\n");

    }
}
