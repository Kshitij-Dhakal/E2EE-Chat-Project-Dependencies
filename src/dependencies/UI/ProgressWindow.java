package dependencies.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ProgressWindow extends JWindow {
    JPanel panel = new JPanel();
    JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
    JProgressBar progressBar;

    public ProgressWindow(int n) {
        progressBar = new JProgressBar(0, n);
        setSize(480, 100);
        setLocationRelativeTo(null);//put it in center of screen

        progressBar.setValue(0);

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout());
        panel.add(messageLabel, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
        add(new JPanel() {{
            setLayout(new BorderLayout());
            setBorder(new LineBorder(Color.DARK_GRAY));
            add(panel, BorderLayout.CENTER);
        }});
    }

    public static void main(String[] args) {

    }

    public void addProgress() {
        this.progressBar.setValue(this.progressBar.getValue() + 1);
    }

    public void addProgress(String message) {
        this.progressBar.setValue(this.progressBar.getValue() + 1);
        this.messageLabel.setText(message);
    }
}

