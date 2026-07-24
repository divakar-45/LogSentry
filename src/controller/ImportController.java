package controller;

import detection.DetectionEngine;
import model.Alert;
import model.LogEntry;
import service.LogService;
import ui.DashboardPanel;
import ui.StatusBarPanel;
import ui.TimelinePanel;

import javax.swing.*;
import java.io.File;
import java.util.List;
import model.RiskScore;
import java.util.HashMap;
import java.util.Map;

public class ImportController {

    private DashboardPanel dashboardPanel;
    private StatusBarPanel statusBarPanel;
    private LogService logService;
    private DetectionEngine detectionEngine;
    private TimelinePanel timelinePanel;

    public ImportController(DashboardPanel dashboardPanel,
                        StatusBarPanel statusBarPanel,
                        TimelinePanel timelinePanel){

        this.dashboardPanel = dashboardPanel;
        this.statusBarPanel = statusBarPanel;
        this.timelinePanel = timelinePanel;

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
                timelinePanel.clearTimeline();

for (LogEntry log : logs) {

    timelinePanel.addEvent(

            log.getDate()
                    + " | "
                    + log.getStatus()
                    + " | "
                    + log.getUsername()
                    + " | "
                    + log.getIpAddress()

    );

}

                dashboardPanel.updateTotalLogs(logs.size());

                List<Alert> alerts = detectionEngine.analyze(logs);
                Map<String,Integer> ipCount = new HashMap<>();

Map<String,Integer> userCount = new HashMap<>();

Map<String,Integer> ruleCount = new HashMap<>();

int highestRisk = 0;
                int critical = 0;
int high = 0;
int medium = 0;
int low = 0;

for (Alert alert : alerts) {
    ruleCount.put(
        alert.getRuleName(),
        ruleCount.getOrDefault(alert.getRuleName(),0)+1
);

ipCount.put(
        alert.getSourceIP(),
        ipCount.getOrDefault(alert.getSourceIP(),0)+1
);

highestRisk = Math.max(
        highestRisk,
        RiskScore.calculate(alert)
);

    switch (alert.getSeverity()) {

        case CRITICAL:
            critical++;
            break;

        case HIGH:
            high++;
            break;

        case MEDIUM:
            medium++;
            break;

        case LOW:
            low++;
            break;
    }

}
String topRule = "-";

int maxRule = 0;

for(Map.Entry<String,Integer> entry : ruleCount.entrySet()){

    if(entry.getValue()>maxRule){

        maxRule = entry.getValue();

        topRule = entry.getKey();

    }

}

String topIp = "-";

int maxIp = 0;

for(Map.Entry<String,Integer> entry : ipCount.entrySet()){

    if(entry.getValue()>maxIp){

        maxIp = entry.getValue();

        topIp = entry.getKey();

    }

}
for(LogEntry log : logs){

    userCount.put(
            log.getUsername(),
            userCount.getOrDefault(log.getUsername(),0)+1
    );

}

String topUser = "-";

int maxUser = 0;

for(Map.Entry<String,Integer> entry : userCount.entrySet()){

    if(entry.getValue()>maxUser){

        maxUser = entry.getValue();

        topUser = entry.getKey();

    }

}

dashboardPanel.updateCriticalCount(critical);
dashboardPanel.updateHighCount(high);
dashboardPanel.updateMediumCount(medium);
dashboardPanel.updateLowCount(low);

                dashboardPanel.clearAlerts();

             for (Alert alert : alerts) {

    dashboardPanel.addAlert(alert);

}
dashboardPanel.updateTopIp(topIp);
dashboardPanel.updateTopRule(topRule);
dashboardPanel.updateTopUser(topUser);
dashboardPanel.updateHighestRisk(highestRisk);

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