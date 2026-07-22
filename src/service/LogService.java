package service;

import model.LogEntry;
import parser.LogFileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LogService {

    private LogFileReader reader;

    public LogService() {

        reader = new LogFileReader();

    }

    public List<LogEntry> importLogs(File file) throws IOException {

        return reader.readLogFile(file);

    }

}