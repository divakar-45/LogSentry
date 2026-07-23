package detection;

import java.util.ArrayList;
import java.util.List;

import model.Alert;
import model.LogEntry;
import model.Severity;

public class MidnightLoginRule implements DetectionRule {

    @Override
    public List<Alert> detect(List<LogEntry> logs) {

        List<Alert> alerts = new ArrayList<>();

        for (LogEntry log : logs) {

            if (log.getStatus().equalsIgnoreCase("SUCCESS")) {

                String date = log.getDate();

                if (date.contains("00:") ||
                        date.contains("01:") ||
                        date.contains("02:") ||
                        date.contains("03:") ||
                        date.contains("04:")) {

                    alerts.add(new Alert(
                            Severity.MEDIUM,
                            "Midnight Login",
                            "Successful login during restricted hours.",
                            log.getIpAddress()
                    ));

                }

            }

        }

        return alerts;

    }

}