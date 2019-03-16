package model.Ui;

import javax.swing.*;
import java.awt.*;

public class MainUi {
    private static JFrame jFrame;
    private static JPanel interactionPanel;
    private static JPanel mapPanel;
    private static EaterPanel eaterPanel;
    private static GrowerPanel growerPanel;
    private static UserStartingPanel userStartingPanel;
    private static CardLayout cl = new CardLayout();


    public MainUi() {
        jFrame = new JFrame();
        appendAndShowPanels();
        makeAndShowFrame();
    }

    private void makeAndShowFrame() {
        jFrame.setLayout(new BorderLayout());
        jFrame.add(interactionPanel, BorderLayout.EAST);
        jFrame.add(mapPanel, BorderLayout.WEST);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(800, 450);
        jFrame.setLocation(50, 20);
        jFrame.setVisible(true);
    }

    private void appendAndShowPanels() {
        interactionPanel = new JPanel();
        mapPanel = new JPanel();
        makeUserStartingPanel();
        makeGrowerPanel();
        makeEaterPanel();

        interactionPanel.setLayout(cl);
        interactionPanel.add(userStartingPanel, "1");
        interactionPanel.add(growerPanel, "2");
        interactionPanel.add(eaterPanel, "3");
        cl.show(interactionPanel,"1");
    }

    private void makeEaterPanel() {
        eaterPanel = new EaterPanel();
    }

    private void makeGrowerPanel() {
        growerPanel = new GrowerPanel();
    }

    private void makeUserStartingPanel() {
        userStartingPanel = new UserStartingPanel();
    }
}
