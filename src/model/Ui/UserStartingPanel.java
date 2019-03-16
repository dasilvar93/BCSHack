package model.Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserStartingPanel extends JPanel {
    private static JButton growerButton;
    private static JButton eaterButton;

    public UserStartingPanel() {
        makeInitialButtons();
        setSize(1600, 900);
        add(eaterButton);
        add(growerButton);
    }

    private void makeInitialButtons() {
        growerButton = new JButton("I want to grow stuff!");
        eaterButton = new JButton("I want to find stuff to eat!");

        growerButton.setPreferredSize(new Dimension(500, 40));
        eaterButton.setPreferredSize(new Dimension(500, 40));

        growerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainUi.cl.show(MainUi.interactionPanel, "2");
            }});

        eaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainUi.cl.show(MainUi.interactionPanel, "3");
            }});
    }
}
