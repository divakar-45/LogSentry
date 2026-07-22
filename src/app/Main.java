package app;

import javax.swing.SwingUtilities;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MainWindow();

        });

    }

}