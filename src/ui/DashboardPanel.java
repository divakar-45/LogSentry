package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import model.Alert;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class DashboardPanel extends JPanel {

    private JLabel totalLogsLabel;
    private JLabel criticalLabel;
    private JLabel highLabel;
    private JLabel mediumLabel;
    private JLabel lowLabel;
    private JLabel topIpLabel;
    private JLabel topUserLabel;
    private JLabel topRuleLabel;
    private JLabel highestRiskLabel;

    private JTable alertTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JComboBox<String> severityFilter;
    private JButton searchButton;

    private TableRowSorter<DefaultTableModel> sorter;
    private List<Alert> displayedAlerts =new ArrayList<>();    


    public DashboardPanel() {

        setLayout(new BorderLayout(10,10));

        JPanel statisticsPanel = new JPanel(new GridLayout(5,1,5,5));

        statisticsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));

        totalLogsLabel = new JLabel("Total Logs : 0");
        criticalLabel = new JLabel("Critical : 0");
        highLabel = new JLabel("High : 0");
        mediumLabel = new JLabel("Medium : 0");
        lowLabel = new JLabel("Low : 0");
        topIpLabel = new JLabel("Top Attacking IP : -");

topUserLabel = new JLabel("Most Targeted User : -");

topRuleLabel = new JLabel("Most Triggered Rule : -");

highestRiskLabel = new JLabel("Highest Risk Alert : 0/100");

        statisticsPanel.add(totalLogsLabel);
        statisticsPanel.add(criticalLabel);
        statisticsPanel.add(highLabel);
        statisticsPanel.add(mediumLabel);
        statisticsPanel.add(lowLabel);
        statisticsPanel.add(new JSeparator());

statisticsPanel.add(topIpLabel);

statisticsPanel.add(topUserLabel);

statisticsPanel.add(topRuleLabel);

statisticsPanel.add(highestRiskLabel);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Severity");
        tableModel.addColumn("Rule");
        tableModel.addColumn("Source IP");
        tableModel.addColumn("Description");

        alertTable = new JTable(tableModel);
        sorter = new TableRowSorter<>(tableModel);

        alertTable.setRowSorter(sorter);
        JPanel searchPanel = new JPanel();

        searchField = new JTextField(20);

        severityFilter = new JComboBox<>();

        severityFilter.addItem("ALL");
        severityFilter.addItem("LOW");
        severityFilter.addItem("MEDIUM");
        severityFilter.addItem("HIGH");
        severityFilter.addItem("CRITICAL");

        searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Search"));

        searchPanel.add(searchField);

        searchPanel.add(new JLabel("Severity"));

        searchPanel.add(severityFilter);

        searchPanel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane(alertTable);

        scrollPane.setBorder(BorderFactory.createTitledBorder("Detected Alerts"));
      alertTable.addMouseListener(new java.awt.event.MouseAdapter() {

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

        if (e.getClickCount() >= 2 && SwingUtilities.isLeftMouseButton(e)) {

            int row = alertTable.rowAtPoint(e.getPoint());

            if (row != -1) {

                Alert alert = displayedAlerts.get(row);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(DashboardPanel.this);

                new AlertDetailsDialog(frame, alert).setVisible(true);
            }
        }
    }

});

        add(statisticsPanel, BorderLayout.WEST);
       JPanel centerPanel = new JPanel(new BorderLayout());

        centerPanel.add(searchPanel, BorderLayout.NORTH);

        centerPanel.add(scrollPane, BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);
        searchButton.addActionListener(e -> applyFilter());

        severityFilter.addActionListener(e -> applyFilter());

    }

    public void updateTotalLogs(int total) {

        totalLogsLabel.setText("Total Logs : " + total);

    }

    public void clearAlerts() {

    tableModel.setRowCount(0);

    displayedAlerts.clear();

}

   public void addAlert(Alert alert) {

    displayedAlerts.add(alert);

    tableModel.addRow(new Object[]{

            alert.getSeverity(),
            alert.getRuleName(),
            alert.getSourceIP(),
            alert.getDescription()

    });

}
private void applyFilter() {

    String text = searchField.getText().trim();

    String severity = severityFilter.getSelectedItem().toString();

    RowFilter<DefaultTableModel, Object> filter = new RowFilter<>() {

        @Override
        public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {

            boolean textMatch = text.isEmpty();

            if (!textMatch) {

                for (int i = 0; i < entry.getValueCount(); i++) {

                    if (entry.getStringValue(i).toLowerCase().contains(text.toLowerCase())) {

                        textMatch = true;

                        break;

                    }

                }

            }

            boolean severityMatch = severity.equals("ALL") ||
                    entry.getStringValue(0).equalsIgnoreCase(severity);

            return textMatch && severityMatch;

        }

    };

    sorter.setRowFilter(filter);

}
public List<Alert> getDisplayedAlerts() {

    return displayedAlerts;

}
public void updateCriticalCount(int value) {

    criticalLabel.setText("Critical : " + value);

}

public void updateHighCount(int value) {

    highLabel.setText("High : " + value);

}

public void updateMediumCount(int value) {

    mediumLabel.setText("Medium : " + value);

}

public void updateLowCount(int value) {

    lowLabel.setText("Low : " + value);

}
public void updateTopIp(String ip){

    topIpLabel.setText("Top Attacking IP : " + ip);

}

public void updateTopUser(String user){

    topUserLabel.setText("Most Targeted User : " + user);

}

public void updateTopRule(String rule){

    topRuleLabel.setText("Most Triggered Rule : " + rule);

}

public void updateHighestRisk(int risk){

    highestRiskLabel.setText("Highest Risk Alert : " + risk + "/100");

}

}