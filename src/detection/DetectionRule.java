package detection;

import java.util.List;

import model.Alert;
import model.LogEntry;

public interface DetectionRule {

    List<Alert> detect(List<LogEntry> logs);

}