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
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DashboardPanel extends JPanel {

    private JLabel totalLogsLabel;
    private JLabel criticalLabel;
    private JLabel highLabel;
    private JLabel mediumLabel;
    private JLabel lowLabel;

    private JTable alertTable;
    private DefaultTableModel tableModel;
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

        statisticsPanel.add(totalLogsLabel);
        statisticsPanel.add(criticalLabel);
        statisticsPanel.add(highLabel);
        statisticsPanel.add(mediumLabel);
        statisticsPanel.add(lowLabel);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Severity");
        tableModel.addColumn("Rule");
        tableModel.addColumn("Source IP");
        tableModel.addColumn("Description");

        alertTable = new JTable(tableModel);

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
        add(scrollPane, BorderLayout.CENTER);

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

}