package app;

import javax.swing.SwingUtilities;
import ui.MainWindow;
import database.DatabaseManager;

public class Main {

    public static void main(String[] args) {

    DatabaseManager.getConnection();

    SwingUtilities.invokeLater(() -> {

        new MainWindow();

    });

}
    }

