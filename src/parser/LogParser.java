package parser;

import model.LogEntry;

public class LogParser {

    public LogEntry parse(String line) {

        String[] parts = line.split(" ");

        String date = parts[0];

        String event = parts[1];

        String status = parts[2];

        String username = parts[3].split("=")[1];

        String ip = parts[4].split("=")[1];

        return new LogEntry(
                date,
                event,
                status,
                username,
                ip
        );

    }

}