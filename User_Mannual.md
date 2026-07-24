# 📖 USER_MANUAL.md

# LogSentry User Manual

Version 0.8 (Student Edition)

---

# 1. Introduction

Welcome to LogSentry.

LogSentry is a desktop application designed to simulate the workflow of a Security Operations Center (SOC) analyst.

The application allows users to import authentication logs, detect suspicious login activities, investigate generated alerts, map them to the MITRE ATT&CK framework, save incidents into a local SQLite database, and generate CSV reports.

This manual explains how to use every feature currently available in LogSentry.

---

# 2. Main Dashboard

After launching LogSentry, the main dashboard is displayed.

The dashboard provides quick access to all primary features.

Main Components:

- Toolbar
- Dashboard
- Threat Timeline
- Status Bar

---

# 3. Toolbar

The toolbar contains the following options.

## Import Logs

Purpose

Imports an authentication log file into the application.

Steps

1. Click **Import Logs**
2. Select a supported log file
3. Click **Open**

Expected Result

- Logs are parsed
- Threats are analyzed
- Alerts are displayed
- Timeline is updated

---

## Generate Report

Purpose

Exports detected alerts into a CSV report.

Steps

1. Click **Generate Report**
2. Choose destination folder
3. Save the report

Expected Result

SOC_Report.csv is created.

---

# 4. Dashboard

The Dashboard displays a summary of the imported log analysis.

Information includes:

- Total Logs Imported
- Critical Alerts
- High Alerts
- Medium Alerts
- Low Alerts

Below the statistics, detected alerts are displayed in a table.

Each alert contains:

- Rule Name
- Severity
- Source IP
- Username
- Timestamp

---

# 5. Viewing Alert Details

To investigate an alert:

Double-click any alert inside the Dashboard.

The Alert Details window opens.

Displayed Information

- Detection Rule
- Severity
- Username
- Source IP
- MITRE ATT&CK Technique
- Analyst Status
- Analyst Notes

---

# 6. Analyst Notes

The investigation window contains an Analyst Notes section.

Purpose

Allows analysts to record investigation observations.

Current Version

Notes are available during the active investigation session.

Persistent storage of notes is planned for Version 1.0.

---

# 7. Incident Status

The investigation window allows analysts to assign a status.

Available values:

- OPEN
- INVESTIGATING
- CLOSED

Current Version

Status defaults to OPEN when reopening the dialog.

Persistent status tracking is planned for Version 1.0.

---

# 8. Save Case

Purpose

Stores the investigated alert inside the SQLite database.

Steps

1. Review alert details
2. Click **Save Case**

Expected Result

The incident is stored in the local SQLite database.

Saved Information

- Rule Name
- Source IP
- Severity
- Created Timestamp
- Updated Timestamp

---

# 9. Threat Timeline

Select the **Threat Timeline** tab.

Purpose

Displays imported authentication events in chronological order.

Information includes:

- Date
- Authentication Result
- Username
- Source IP

The timeline assists analysts in understanding the sequence of events during an investigation.

---

# 10. MITRE ATT&CK Mapping

Each detection rule is associated with a MITRE ATT&CK technique.

Purpose

Provides analysts with additional context regarding attacker behavior.

Current mappings include:

| Detection Rule | MITRE ATT&CK |
|----------------|--------------|
| Midnight Login | T1078 - Valid Accounts |
| Brute Force | T1110.001 - Password Guessing |
| Password Spraying | T1110.003 - Password Spraying |

---

# 11. SQLite Database

LogSentry stores saved incidents inside an SQLite database.

Database Location

```
src/database/logsentry.db
```

The application automatically creates the database and required tables during startup.

---

# 12. CSV Reports

Generated reports include:

- Rule Name
- Severity
- Source IP
- Username
- Timestamp

Reports can be shared for documentation or educational purposes.

---

# 13. Typical Investigation Workflow

```
Launch LogSentry

↓

Import Authentication Logs

↓

Detection Engine Analysis

↓

Alerts Generated

↓

Review Dashboard

↓

Open Alert Details

↓

Review MITRE Mapping

↓

Save Incident

↓

Generate CSV Report
```

---

# 14. Troubleshooting

## Database Connection Error

Verify:

- SQLite JDBC Driver
- Database location
- Java installation

---

## Log Import Error

Verify:

- Log format
- File location
- Supported structure

---

## Report Generation Error

Verify:

- Output folder permissions
- Destination path

---

# 15. Current Limitations

Version 0.8 includes the following limitations:

- Analyst Notes are not yet persisted.
- Incident Status resets after reopening.
- No Case Management Panel.
- No IOC Search.
- No Threat Intelligence integration.
- No PDF Reporting.

These features are planned for Version 1.0.

---

# 16. Best Practices

For accurate results:

- Use properly formatted authentication logs.
- Review all HIGH severity alerts.
- Verify MITRE ATT&CK mappings during investigations.
- Generate reports after completing analysis.
- Regularly back up the SQLite database.

---

# 17. Intended Audience

This application is intended for:

- Cybersecurity Students
- SOC Analyst Learners
- Blue Team Enthusiasts
- Academic Demonstrations
- Java Desktop Application Learning

It is not intended to replace commercial SIEM or SOAR platforms.

---

# 18. Conclusion

LogSentry provides a practical environment for understanding authentication log analysis, rule-based threat detection, MITRE ATT&CK mapping, incident investigation, and case management concepts.

The project serves as an educational SOC simulation platform while demonstrating software engineering principles through a Java desktop application.
