package ui;

import controller.ImportController;

import java.awt.BorderLayout;

import javax.swing.*;
import report.CSVReportGenerator;
import model.Alert;

import java.util.List;
import java.io.File;

public class MainWindow extends JFrame {

    private DashboardPanel dashboardPanel;
    private TimelinePanel timelinePanel;
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
        timelinePanel = new TimelinePanel();
        toolBarPanel = new ToolBarPanel();
        statusBarPanel = new StatusBarPanel();

        importController = new ImportController(
        dashboardPanel,
        statusBarPanel,
        timelinePanel
);

        add(toolBarPanel, BorderLayout.NORTH);
        JTabbedPane tabs = new JTabbedPane();

tabs.addTab("Dashboard", dashboardPanel);

tabs.addTab("Threat Timeline", timelinePanel);

add(tabs, BorderLayout.CENTER);
        add(statusBarPanel, BorderLayout.SOUTH);

        toolBarPanel.getImportButton().addActionListener(e ->
        importController.importLogs(this));

toolBarPanel.getReportButton().addActionListener(e ->
        generateReport());
        setVisible(true);

    }
    private void generateReport() {

    JFileChooser chooser = new JFileChooser();

    chooser.setSelectedFile(new File("SOC_Report.csv"));

    int result = chooser.showSaveDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {

        try {

            CSVReportGenerator generator = new CSVReportGenerator();

            generator.generate(
                    chooser.getSelectedFile(),
                    dashboardPanel.getDisplayedAlerts()
            );

            JOptionPane.showMessageDialog(
                    this,
                    "Report generated successfully."
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage()
            );

        }

    }

}

}