package parser;

import model.LogEntry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFileReader {

    public List<LogEntry> readLogFile(File file) throws IOException {

        List<LogEntry> logs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));

        LogParser parser = new LogParser();

        String line;

        while ((line = reader.readLine()) != null) {

            if (!line.trim().isEmpty()) {

                logs.add(parser.parse(line));

            }

        }

        reader.close();

        return logs;

    }

}