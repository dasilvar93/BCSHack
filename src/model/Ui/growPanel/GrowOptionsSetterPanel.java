package model.Ui.growPanel;

import model.Ui.InputBars.HarvestableDropDown;
import model.Ui.InputBars.InputPlantTypePanel;

import javax.swing.*;
import java.awt.*;

public class GrowOptionsSetterPanel extends JPanel {
    private static InputPlantTypePanel inputPlant;
    private static HarvestableDropDown harvestableDropDown;

    public GrowOptionsSetterPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(600, 450));

        inputPlant = new InputPlantTypePanel();
        add(inputPlant);

        harvestableDropDown = new HarvestableDropDown();
        add(harvestableDropDown);
    }



}
