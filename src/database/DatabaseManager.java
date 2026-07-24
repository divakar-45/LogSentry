package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseManager {

private static final String URL =
        "jdbc:sqlite:database/logsentry.db";
    private static final String CREATE_TABLE_SQL =

"CREATE TABLE IF NOT EXISTS incidents ("

+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"

+ "rule_name TEXT NOT NULL,"

+ "source_ip TEXT NOT NULL,"

+ "severity TEXT NOT NULL,"

+ "risk_score INTEGER,"

+ "status TEXT,"

+ "notes TEXT,"

+ "created_at TEXT,"

+ "updated_at TEXT"

+ ");";

    public static Connection getConnection() {
        System.out.println("=================================");
System.out.println("Working Directory:");
System.out.println(System.getProperty("user.dir"));
System.out.println("=================================");

        try {

            
            Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection(URL);
            System.out.println("Database URL: " + URL);
            Statement statement = connection.createStatement();

statement.execute(CREATE_TABLE_SQL);
System.out.println("Incidents table verified.");

statement.close();

            System.out.println("=================================");
            System.out.println("SQLite Connected Successfully.");

System.out.println("Checking database schema...");
            System.out.println("Database: logsentry.db");
            System.out.println("=================================");

            return connection;

        } catch (Exception e) {

            System.out.println("SQLite Connection Failed!");
            e.printStackTrace();

            return null;

        }

    }
}