package model.Ui.growPanel;

import javax.swing.*;
import java.awt.*;

public class PlantStatusPanel extends JPanel {

    public final static String newline = "\n";
    public static JTextArea textArea;

    public PlantStatusPanel(){
        super(new GridBagLayout());
        setBackground(Color.yellow);
        setPreferredSize(new Dimension(600, 450));

        textArea = new JTextArea(7, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

    }
}
