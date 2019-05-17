package dependencies.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddPlaceHolder implements FocusListener {
    String placeHolder;
    JTextField textField;

    public AddPlaceHolder(String placeHolder, JTextField textField) {
        this.placeHolder = placeHolder;
        this.textField = textField;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().trim().equals(placeHolder)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().trim().isEmpty()) {
            textField.setText(placeHolder);
            textField.setForeground(Color.GRAY);
        }
    }
}
