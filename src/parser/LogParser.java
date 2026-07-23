package parser;

import model.LogEntry;

public class LogParser {

    public LogEntry parse(String line) {

    System.out.println("LINE: " + line);

    String[] parts = line.split("\\s+");

    System.out.println("Parts Length = " + parts.length);

    for (int i = 0; i < parts.length; i++) {
        System.out.println(i + " -> " + parts[i]);
    }

    String date = parts[0] + " " + parts[1];
    String event = parts[2];
    String status = parts[3];
    String username = parts[4].split("=")[1];
    String ip = parts[5].split("=")[1];

    return new LogEntry(date, event, status, username, ip);
}
}