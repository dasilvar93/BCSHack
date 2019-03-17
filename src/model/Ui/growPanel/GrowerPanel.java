package model.Ui.growPanel;

import model.Ui.MapPanel;

import javax.swing.*;
import java.awt.*;

public class GrowerPanel extends JPanel {
    private MapPanel growMap;
    private GrowInputPanel giPanel;

    public GrowerPanel() {
        giPanel = new GrowInputPanel();
        growMap = new MapPanel();

        add(giPanel, BorderLayout.WEST);
        add(growMap, BorderLayout.EAST);

    }
}
