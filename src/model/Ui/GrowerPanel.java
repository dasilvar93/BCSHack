package model.Ui;

import javax.swing.*;
import java.awt.*;

public class GrowerPanel extends JPanel {
    private MapPanel growMap;
    private GrowInputPanel giPanel;

    public GrowerPanel() {
        giPanel = new GrowInputPanel();
        giPanel.setPreferredSize(new Dimension(600, 900));
        growMap = new MapPanel();
        growMap.setPreferredSize(new Dimension(1000, 900));

        add(giPanel, BorderLayout.WEST);
        add(growMap, BorderLayout.EAST);

    }
}
