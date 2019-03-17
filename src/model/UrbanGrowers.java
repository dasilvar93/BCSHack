package model;

import model.Ui.MainUi;

import java.io.IOException;

public class UrbanGrowers {
    private static MainUi ui;
    public static City newCity;


    public static void main(String[] args) throws IOException {
        System.out.print("UrbanGrowers has started" + "\n");
        newCity = new City("Vancouver", 1);

        ui = new MainUi();

    }
}
