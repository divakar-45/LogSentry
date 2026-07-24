package repository;

import database.DatabaseManager;

import model.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncidentRepository {

    public void saveIncident(Alert alert) throws Exception {

        String sql =

        "INSERT INTO incidents(" +

        "rule_name," +

        "source_ip," +

        "severity," +

        "risk_score," +

        "status," +

        "notes," +

        "created_at," +

        "updated_at" +

        ") VALUES (?,?,?,?,?,?,datetime('now'),datetime('now'))";

        Connection connection =
                DatabaseManager.getConnection();

        PreparedStatement statement =
                connection.prepareStatement(sql);

        statement.setString(1, alert.getRuleName());

        statement.setString(2, alert.getSourceIP());

        statement.setString(3, alert.getSeverity().toString());

        statement.setInt(4, 0);

        statement.setString(5, "OPEN");

        statement.setString(6, "");

        int rows = statement.executeUpdate();

System.out.println("Rows inserted = " + rows);

        statement.close();

        connection.close();

    }

}