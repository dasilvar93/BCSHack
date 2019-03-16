package model.Ui.InputBars;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class InputPanel extends JPanel implements ActionListener {
    private JLabel inputLabel;
    public static JTextField textField;
    //textField stuff from: https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html

    public InputPanel(String title){
        inputLabel = new JLabel("Enter input: ");
        add(inputLabel);
        textField = new JTextField(20);
        textField.addActionListener(this);
        add(textField);
        makeEnterButton();
    }

    private void makeEnterButton() {
        JButton b = new JButton("Enter");
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
