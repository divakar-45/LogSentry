package detection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Alert;
import model.LogEntry;
import model.Severity;

public class BruteForceRule implements DetectionRule {

    @Override
    public List<Alert> detect(List<LogEntry> logs) {

        Map<String, Integer> failedAttempts = new HashMap<>();

        List<Alert> alerts = new ArrayList<>();

        for (LogEntry log : logs) {

            if (log.getStatus().equalsIgnoreCase("FAILED")) {

                String ip = log.getIpAddress();

                failedAttempts.put(ip,
                        failedAttempts.getOrDefault(ip, 0) + 1);

            }

        }

        for (String ip : failedAttempts.keySet()) {

            int count = failedAttempts.get(ip);

            if (count >= 5) {

                alerts.add(new Alert(
                        Severity.HIGH,
                        "Brute Force Attack",
                        "Detected " + count + " failed login attempts.",
                        ip
                ));

            }

        }

        return alerts;

    }

}