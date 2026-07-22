package model;

public class LogEntry {

    private String date;
    private String event;
    private String status;
    private String username;
    private String ipAddress;

    public LogEntry(String date,
                    String event,
                    String status,
                    String username,
                    String ipAddress) {

        this.date = date;
        this.event = event;
        this.status = status;
        this.username = username;
        this.ipAddress = ipAddress;

    }

    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

}