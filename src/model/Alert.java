package model;

public class Alert {

    private Severity severity;
    private String ruleName;
    private String description;
    private String sourceIP;

    public Alert(Severity severity,
                 String ruleName,
                 String description,
                 String sourceIP) {

        this.severity = severity;
        this.ruleName = ruleName;
        this.description = description;
        this.sourceIP = sourceIP;

    }

    public Severity getSeverity() {
        return severity;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getDescription() {
        return description;
    }

    public String getSourceIP() {
        return sourceIP;
    }

}