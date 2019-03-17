package model.Ui.InputBars;

import model.Plant;
import model.UrbanGrowers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static model.UrbanGrowers.newCity;

public class InputPlantTypePanel extends JPanel implements ActionListener{
    public static JTextField plantTextField;
    public Plant newPlant;
    private Double mockLat; // TODO MOCK - pass in with get lat from geolocation
    private Double mockLon; // TODO MOCK - pass in with get from geolocation
    String text;

    public InputPlantTypePanel(){
        plantTextField = new JTextField(20);
        plantTextField.addActionListener(this);
        add(plantTextField);
        makeEnterButton();
    }

    private void makeEnterButton() {
        JButton b = new JButton("Enter plant type");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = plantTextField.getText();
                plantTextField.selectAll();
                System.out.print(text + " was entered in the Input Plant Bar " + "\n");
                makeAndAddPlantToCity(text);
                plantTextField.setText("");
            }
        });
        add(b);
    }

    private void makeAndAddPlantToCity(String plantType) {
        newPlant = new Plant(plantType, mockLon, mockLat);
        newCity.plants.add(newPlant);
        UrbanGrowers.currentPlantName = plantType;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String text = plantTextField.getText();
        plantTextField.selectAll();

        plantTextField.setText("");
    }
}
