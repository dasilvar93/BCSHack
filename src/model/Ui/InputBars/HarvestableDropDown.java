package model.Ui.InputBars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HarvestableDropDown extends JComboBox implements ActionListener {


    public HarvestableDropDown() {
        addItem(true);
        addItem(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
