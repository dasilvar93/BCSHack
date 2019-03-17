package model.Ui.growPanel;

import javax.swing.*;
import java.awt.*;

public class GrowInputPanel extends JPanel {
    private GrowOptionsSetterPanel growOptionsSetterPanel;
    private PlantStatusPanel plantStatusPanel;

    public GrowInputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.red);
        setPreferredSize(new Dimension(600, 900));
        growOptionsSetterPanel = new GrowOptionsSetterPanel();
        add(growOptionsSetterPanel);

        plantStatusPanel = new PlantStatusPanel();
        add(plantStatusPanel);
    }
}
