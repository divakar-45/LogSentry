package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DashboardPanel extends JPanel {

    private JLabel totalLogsLabel;
    private JLabel criticalLabel;
    private JLabel highLabel;
    private JLabel mediumLabel;
    private JLabel lowLabel;

    private JTextArea recentAlertsArea;

    public DashboardPanel() {

        setLayout(new BorderLayout(10,10));

        JPanel statisticsPanel = new JPanel(new GridLayout(5,1,5,5));
        statisticsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));

        totalLogsLabel = new JLabel("Total Logs : 0");
        criticalLabel = new JLabel("Critical : 0");
        highLabel = new JLabel("High : 0");
        mediumLabel = new JLabel("Medium : 0");
        lowLabel = new JLabel("Low : 0");

        statisticsPanel.add(totalLogsLabel);
        statisticsPanel.add(criticalLabel);
        statisticsPanel.add(highLabel);
        statisticsPanel.add(mediumLabel);
        statisticsPanel.add(lowLabel);

        recentAlertsArea = new JTextArea();
        recentAlertsArea.setEditable(false);
        recentAlertsArea.setFont(new Font("Monospaced",Font.PLAIN,13));

        JScrollPane scrollPane = new JScrollPane(recentAlertsArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Recent Alerts"));

        add(statisticsPanel,BorderLayout.WEST);
        add(scrollPane,BorderLayout.CENTER);

    }

    public void updateTotalLogs(int total){

        totalLogsLabel.setText("Total Logs : " + total);

    }

    public void addAlert(String alert){

        recentAlertsArea.append(alert + "\n");

    }

}
