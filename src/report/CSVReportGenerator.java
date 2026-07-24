package report;

import model.Alert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVReportGenerator {

    public void generate(File file, List<Alert> alerts) throws IOException {

        FileWriter writer = new FileWriter(file);

        writer.write("Severity,Rule,Source IP,Description\n");

        for (Alert alert : alerts) {

            writer.write(
                    alert.getSeverity() + "," +
                    alert.getRuleName() + "," +
                    alert.getSourceIP() + "," +
                    alert.getDescription() + "\n"
            );

        }

        writer.close();

    }

}