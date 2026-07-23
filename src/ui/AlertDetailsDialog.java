package ui;

import model.Alert;

import javax.swing.*;
import java.awt.*;

public class AlertDetailsDialog extends JDialog {

    public AlertDetailsDialog(JFrame parent, Alert alert) {

        super(parent, "Alert Details", true);

        setSize(500,300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(4,1,10,10));

        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Severity : " + alert.getSeverity()));

        panel.add(new JLabel("Rule : " + alert.getRuleName()));

        panel.add(new JLabel("Source IP : " + alert.getSourceIP()));

        panel.add(new JLabel("Description : " + alert.getDescription()));

        add(panel);

    }

}