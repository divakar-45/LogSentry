package controller;

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

    public ImportController(
            DashboardPanel dashboardPanel,
            StatusBarPanel statusBarPanel
    ) {

        this.dashboardPanel = dashboardPanel;
        this.statusBarPanel = statusBarPanel;

        logService = new LogService();

    }

    public void importLogs(JFrame parent) {

        JFileChooser chooser = new JFileChooser();

        chooser.setDialogTitle("Select Log File");

        int result = chooser.showOpenDialog(parent);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            try {

                List<LogEntry> logs = logService.importLogs(file);

                dashboardPanel.updateTotalLogs(logs.size());

                dashboardPanel.addAlert(
                        "Imported : " + file.getName()
                );

                statusBarPanel.setStatus(
                        "Imported " + logs.size() + " log entries."
                );

            } catch (Exception ex) {

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