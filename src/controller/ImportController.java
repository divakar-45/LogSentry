package controller;

import detection.DetectionEngine;
import model.Alert;
import model.LogEntry;
import service.LogService;
import ui.DashboardPanel;
import ui.StatusBarPanel;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class ImportController {

    private DashboardPanel dashboardPanel;
    private StatusBarPanel statusBarPanel;
    private LogService logService;
    private DetectionEngine detectionEngine;

    public ImportController(DashboardPanel dashboardPanel,
                            StatusBarPanel statusBarPanel) {

        this.dashboardPanel = dashboardPanel;
        this.statusBarPanel = statusBarPanel;

        logService = new LogService();
        detectionEngine = new DetectionEngine();

    }

    public void importLogs(JFrame parent) {

        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle("Select Log File");

        int result = chooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();
            System.out.println("Selected File: " + file.getAbsolutePath());

            try {

                List<LogEntry> logs = logService.importLogs(file);

                dashboardPanel.updateTotalLogs(logs.size());

                List<Alert> alerts = detectionEngine.analyze(logs);

                dashboardPanel.clearAlerts();

                for (Alert alert : alerts) {

                    dashboardPanel.addAlert(
                            "[" + alert.getSeverity() + "] "
                                    + alert.getRuleName()
                                    + " | "
                                    + alert.getSourceIP()
                    );

                }

                statusBarPanel.setStatus(
                        "Imported "
                                + logs.size()
                                + " logs | "
                                + alerts.size()
                                + " alerts detected."
                );

            }

            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        parent,
                        ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            }

        }

    }

}