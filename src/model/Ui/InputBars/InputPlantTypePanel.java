package model.Ui.InputBars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPlantTypePanel extends JPanel implements ActionListener{
    public static JTextField textField;

    public InputPlantTypePanel(){
        textField = new JTextField(20);
        textField.addActionListener(this);
        add(textField);
        makeEnterButton();
    }

    private void makeEnterButton() {
        JButton b = new JButton("Enter plant type");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(b);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textField.selectAll();

        textField.setText("");
    }
}
