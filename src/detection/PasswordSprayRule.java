package detection;

import java.util.*;

import model.Alert;
import model.LogEntry;
import model.Severity;

public class PasswordSprayRule implements DetectionRule {

    @Override
    public List<Alert> detect(List<LogEntry> logs) {

        Map<String, Set<String>> usersPerIP = new HashMap<>();

        List<Alert> alerts = new ArrayList<>();

        for (LogEntry log : logs) {

            if (log.getStatus().equalsIgnoreCase("FAILED")) {

                usersPerIP
                        .computeIfAbsent(
                                log.getIpAddress(),
                                k -> new HashSet<>())
                        .add(log.getUsername());

            }

        }

        for (String ip : usersPerIP.keySet()) {

            if (usersPerIP.get(ip).size() >= 3) {

                alerts.add(new Alert(
                        Severity.HIGH,
                        "Password Spraying",
                        "Multiple usernames targeted from one IP.",
                        ip
                ));

            }

        }

        return alerts;

    }

}