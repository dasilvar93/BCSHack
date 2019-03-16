package model.Ui;

import model.Ui.growPanel.GrowerPanel;

import javax.swing.*;
import java.awt.*;

public class MainUi {
    private static JFrame jFrame;
    protected static JPanel interactionPanel;
    private static JPanel mapPanel;
    private static EaterPanel eaterPanel;
    private static GrowerPanel growerPanel;
    private static UserStartingPanel userStartingPanel;
    protected static CardLayout cl = new CardLayout();


    public MainUi() {
        jFrame = new JFrame();
        appendAndShowPanels();
        makeAndShowFrame();
    }

    private void makeAndShowFrame() {
        jFrame.setLayout(new BorderLayout());
        jFrame.add(interactionPanel, BorderLayout.WEST);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(1600, 900);
        jFrame.setLocation(50, 20);
        jFrame.setVisible(true);
    }

    private void appendAndShowPanels() {
        interactionPanel = new JPanel();
        interactionPanel.setSize(1600, 900);

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
