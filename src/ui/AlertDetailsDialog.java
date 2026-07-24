package ui;

import mitre.MitreMapper;
import model.Alert;
import model.RiskScore;
import model.IncidentStatus;
import repository.IncidentRepository;

import javax.swing.*;
import java.awt.*;

public class AlertDetailsDialog extends JDialog {

    public AlertDetailsDialog(JFrame parent, Alert alert) {

        super(parent, "Alert Details", true);

        setSize(600, 400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Severity : " + alert.getSeverity()));
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("Rule : " + alert.getRuleName()));
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("MITRE ATTACK : "
                + MitreMapper.getTechniqueId(alert.getRuleName())));
                panel.add(Box.createVerticalStrut(10));

panel.add(new JLabel(
        "Risk Score : "
        + RiskScore.calculate(alert)
        + "/100"
));
        panel.add(Box.createVerticalStrut(10));

        panel.add(new JLabel("Source IP : " + alert.getSourceIP()));
        panel.add(Box.createVerticalStrut(10));

        JTextArea description = new JTextArea(alert.getDescription());

        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        description.setBackground(getBackground());

        panel.add(new JLabel("Description"));
        panel.add(description);

        add(panel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        JComboBox<IncidentStatus> statusBox =
        new JComboBox<>(IncidentStatus.values());

panel.add(Box.createVerticalStrut(15));

panel.add(new JLabel("Incident Status"));

panel.add(statusBox);

panel.add(Box.createVerticalStrut(15));

JTextArea notes = new JTextArea(6,30);

notes.setLineWrap(true);

notes.setWrapStyleWord(true);

panel.add(new JLabel("Analyst Notes"));

panel.add(new JScrollPane(notes));

        closeButton.addActionListener(e -> dispose());

        JButton saveButton = new JButton("Save Case");

saveButton.addActionListener(e -> {

    try {

        IncidentRepository repository = new IncidentRepository();

        repository.saveIncident(alert);

        JOptionPane.showMessageDialog(

                this,

                "Incident saved successfully."

        );

    } catch (Exception ex) {

        JOptionPane.showMessageDialog(

                this,

                ex.getMessage(),

                "Database Error",

                JOptionPane.ERROR_MESSAGE

        );

    }

});

JPanel buttonPanel = new JPanel();

buttonPanel.add(saveButton);

buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);

    }

}