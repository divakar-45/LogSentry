package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBarPanel extends JPanel {

    private JLabel statusLabel;

    public StatusBarPanel() {

        setLayout(new BorderLayout());

        setBorder(new EmptyBorder(5, 10, 5, 10));

        statusLabel = new JLabel("Ready");

        add(statusLabel, BorderLayout.WEST);

    }

    public void setStatus(String message) {

        statusLabel.setText(message);

    }

}