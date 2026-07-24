# 🧪 LogSentry Lab Guide

# LogSentry v0.8 (Student Edition)

---

# 1. Objective

The objective of this lab is to demonstrate how LogSentry imports authentication logs, detects suspicious activities using predefined security rules, allows analysts to investigate alerts, and stores incidents inside an SQLite database.

---

# 2. Learning Outcomes

After completing this lab, the user will understand:

- Authentication Log Analysis
- Security Event Detection
- Rule-Based Threat Detection
- MITRE ATT&CK Mapping
- SOC Investigation Workflow
- Incident Persistence using SQLite
- CSV Report Generation

---

# 3. Software Requirements

| Software | Version |
|-----------|----------|
| Java JDK | 21+ |
| Visual Studio Code | Latest |
| SQLite JDBC Driver | 3.53.x |
| DB Browser for SQLite | Latest |
| Git | Latest |

---

# 4. Project Structure

```

LogSentry

│

├── src

├── sample_logs

├── database

├── lib

├── screenshots

├── README.md

└── run.bat

```

---

# 5. Project Architecture

```

Import Logs

↓

Log Parser

↓

Detection Engine

↓

Alert Generation

↓

Alert Details

↓

SQLite Database

↓

CSV Report

```

---

# 6. Running the Project

## Step 1

Open the project in Visual Studio Code.

---

## Step 2

Run:

```

run.bat

```

The application will automatically

- Compile the project
- Connect SQLite
- Verify the database
- Launch LogSentry

---

# 7. Import Sample Logs

Click

```

Import Logs

```

Select

```

sample_logs/sample1.txt

```

Expected Result

- Total Logs Updated
- Alerts Generated
- Timeline Updated

---

# 8. Threat Detection

The Detection Engine analyzes every imported log entry.

Current Detection Rules:

## Midnight Login

Detects successful logins occurring during unusual hours.

Severity:

MEDIUM

---

## Brute Force Attack

Detects repeated failed login attempts from the same source IP.

Severity:

HIGH

---

## Password Spraying

Detects attempts against multiple user accounts using a single IP.

Severity:

HIGH

---

# 9. Alert Investigation

Double-click an alert.

The investigation window displays

- Rule Name
- Severity
- Source IP
- Username
- MITRE ATT&CK Technique
- Analyst Status
- Analyst Notes

---

# 10. Saving an Incident

Click

```

Save Case

```

The application stores the incident inside

```

SQLite Database

```

Information stored

- Rule Name
- Source IP
- Severity
- Status
- Created Timestamp
- Updated Timestamp

---

# 11. SQLite Verification

Open

```

DB Browser for SQLite

```

Open

```

database/logsentry.db

```

Browse

```

incidents

```

Expected Result

Saved incidents should appear inside the table.

---

# 12. CSV Report

Click

```

Generate Report

```

Choose a location.

Expected Result

```

SOC_Report.csv

```

is generated successfully.

---

# 13. Expected Workflow

```

Launch Application

↓

Import Logs

↓

Analyze Logs

↓

Threat Detection

↓

Review Alerts

↓

Open Investigation

↓

Save Incident

↓

Generate CSV Report

```

---

# 14. Troubleshooting

## SQLite Connection Error

Verify

- SQLite JDBC Driver
- Database path
- Referenced Libraries

---

## Import Errors

Verify

- Log format
- Sample log location

---

## Report Generation Errors

Verify

- Destination folder permissions

---

# 15. Known Limitations

Current Version (0.8)

- Analyst Notes are not persisted.
- Incident Status always defaults to OPEN.
- No Case Management Panel.
- No IOC Search.
- No PDF Reporting.

These features are planned for Version 1.0.

---

# 16. Future Enhancements

- Case Management
- Persistent Notes
- Persistent Status
- IOC Search
- Dashboard Analytics
- Threat Intelligence
- PDF Reports
- Enhanced SOC Workflow

---

# 17. Conclusion

LogSentry demonstrates a practical implementation of core SOC concepts including authentication log analysis, attack detection, incident investigation, MITRE ATT&CK mapping, SQLite persistence, and reporting within a Java Swing desktop application.

The project serves as an educational platform for understanding Security Operations Center workflows rather than functioning as a production SIEM solution.
