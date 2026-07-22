package ui;

import controller.ImportController;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainWindow extends JFrame {

    private DashboardPanel dashboardPanel;
    private ToolBarPanel toolBarPanel;
    private StatusBarPanel statusBarPanel;

    private ImportController importController;

    public MainWindow() {

        setTitle("LogSentry");
        setSize(1200,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        menuBar.add(new JMenu("File"));
        menuBar.add(new JMenu("View"));
        menuBar.add(new JMenu("Tools"));
        menuBar.add(new JMenu("Help"));

        setJMenuBar(menuBar);

        dashboardPanel = new DashboardPanel();
        toolBarPanel = new ToolBarPanel();
        statusBarPanel = new StatusBarPanel();

        importController = new ImportController(
                dashboardPanel,
                statusBarPanel
        );

        add(toolBarPanel, BorderLayout.NORTH);
        add(dashboardPanel, BorderLayout.CENTER);
        add(statusBarPanel, BorderLayout.SOUTH);

        toolBarPanel.getImportButton().addActionListener(e ->
                importController.importLogs(this)
        );

        setVisible(true);

    }

}