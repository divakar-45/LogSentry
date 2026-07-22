package ui;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarPanel extends JToolBar {

    private JButton importButton;
    private JButton analyzeButton;
    private JButton reportButton;

    public ToolBarPanel() {

        setFloatable(false);

        importButton = new JButton("Import Logs");
        analyzeButton = new JButton("Analyze");
        reportButton = new JButton("Generate Report");

        add(importButton);
        addSeparator();
        add(analyzeButton);
        addSeparator();
        add(reportButton);
    }

    public JButton getImportButton() {
        return importButton;
    }

    public JButton getAnalyzeButton() {
        return analyzeButton;
    }

    public JButton getReportButton() {
        return reportButton;
    }
}