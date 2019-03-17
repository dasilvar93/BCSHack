package model.Ui.InputBars;

import model.Plant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPlantTypePanel extends JPanel implements ActionListener{
    public static JTextField plantTextField;
    public Plant newPlant;
    private Double mockLat; // TODO MOCK - pass in with get lat from geolocation
    private Double mockLon; // TODO MOCK - pass in with get from geolocation

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
                String text = plantTextField.getText();
                plantTextField.selectAll();
                System.out.print(text + " was entered in the Input Plant Bar " + "\n");
                newPlant = new Plant(text, mockLon, mockLat);

                plantTextField.setText("");
            }
        });
        add(b);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String text = plantTextField.getText();
        plantTextField.selectAll();

        plantTextField.setText("");
    }
}
