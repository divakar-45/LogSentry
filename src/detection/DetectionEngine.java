package detection;

import java.util.ArrayList;
import java.util.List;

import model.Alert;
import model.LogEntry;

public class DetectionEngine {

    private List<DetectionRule> rules;

    public DetectionEngine() {

    rules = new ArrayList<>();

    rules.add(new BruteForceRule());
    rules.add(new MidnightLoginRule());
    rules.add(new PasswordSprayRule());

}

    public List<Alert> analyze(List<LogEntry> logs) {

        List<Alert> alerts = new ArrayList<>();

        for (DetectionRule rule : rules) {

            alerts.addAll(rule.detect(logs));

        }

        return alerts;

    }

}