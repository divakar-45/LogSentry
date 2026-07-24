package ui;

import javax.swing.*;
import java.awt.*;

public class TimelinePanel extends JPanel {

    private JTextArea timelineArea;

    public TimelinePanel() {

        setLayout(new BorderLayout());

        timelineArea = new JTextArea();

        timelineArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(timelineArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Threat Timeline")
        );

        add(scrollPane, BorderLayout.CENTER);

    }

    public void clearTimeline() {

        timelineArea.setText("");

    }

    public void addEvent(String event) {

        timelineArea.append(event + "\n");

    }

}