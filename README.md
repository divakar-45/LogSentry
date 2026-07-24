#  LogSentry

> A Java-based SOC Incident Detection & Case Management System for analyzing authentication logs, detecting suspicious activities, and assisting security analysts in incident investigation.

---

##  Overview

LogSentry is a desktop application developed using Java Swing that simulates the workflow of a Security Operations Center (SOC) analyst.

The application imports authentication log files, analyzes them using predefined security detection rules, identifies suspicious activities, maps alerts to the MITRE ATT&CK framework, and allows analysts to investigate and save incidents for future reference.

The primary objective of this project is to demonstrate core SOC concepts such as log analysis, attack detection, incident management, reporting, and investigation workflows within a standalone desktop application.

---

##  Features

### Log Management

- Import authentication log files
- Parse structured log entries
- Display imported events

### Threat Detection

- Brute Force Attack Detection
- Password Spraying Detection
- Midnight Login Detection

### Incident Investigation

- Interactive Dashboard
- Alert Details Window
- Threat Timeline
- MITRE ATT&CK Mapping
- Analyst Investigation Workflow

### Case Management

- Save detected incidents
- SQLite Database Integration
- Automatic database creation
- Automatic incident table creation

### Reporting

- CSV Report Generation
- Incident Export

---

##  Application Screens

- Dashboard
- Threat Timeline
- Alert Details
- MITRE ATT&CK Information
- SQLite Incident Storage

*(Screenshots will be added in future updates.)*

---

##  Project Architecture

The project follows an MVC-inspired architecture to separate the user interface, business logic, and data management.

```
LogSentry

│

├── app

├── controller

├── database

├── detection

├── mitre

├── model

├── parser

├── report

├── repository

├── service

├── ui

└── util
```

---

##  Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core Programming Language |
| Java Swing | Desktop User Interface |
| SQLite | Local Incident Database |
| JDBC | Database Connectivity |
| Git | Version Control |
| GitHub | Project Hosting |

---

##  Detection Rules

Current detection capabilities include:

### Midnight Login

Detects successful logins occurring during unusual hours.

### Brute Force Attack

Detects repeated failed login attempts originating from a single IP address.

### Password Spraying

Detects attempts to authenticate multiple user accounts using a single source IP.

Additional detection rules are planned for future versions.

---

##  Database

LogSentry stores saved incidents using SQLite.

Current database includes:

- Incident ID
- Rule Name
- Source IP
- Severity
- Status
- Analyst Notes *(planned enhancement)*
- Created Timestamp
- Updated Timestamp

---

##  Sample Workflow

```
Import Logs

↓

Parse Logs

↓

Analyze Events

↓

Generate Alerts

↓

View Alert Details

↓

MITRE Mapping

↓

Save Incident

↓

Generate CSV Report
```

---

## 📖 Learning Objectives

This project demonstrates practical implementation of:

- Log Parsing
- Rule-Based Threat Detection
- SOC Investigation Workflow
- MITRE ATT&CK Mapping
- Incident Management
- SQLite Database Integration
- Java Swing Application Development
- MVC Architecture
- Repository Pattern

---

## 📌 Current Version

**Version:** 0.8 (Student Edition)

### Completed

- Log Import
- Threat Detection
- Dashboard
- Timeline
- MITRE Mapping
- SQLite Integration
- Incident Persistence
- CSV Report Generation

### Planned (Version 1.0)

- Persistent Analyst Notes
- Persistent Incident Status
- Case Management Panel
- IOC Search
- Threat Intelligence Integration
- PDF Investigation Reports
- Dashboard Analytics

---

##  AI-Assisted Development

This project was developed using an AI-assisted software development workflow.

AI was used as an implementation assistant for:

- Java programming support
- Debugging
- Software architecture guidance
- Code refactoring
- Documentation assistance

The cybersecurity problem definition, detection logic, project workflow, functional requirements, and overall system design were conceived, validated, tested, and directed by the project author.

Every implemented feature was manually reviewed, integrated, tested, and understood before being included in the project.

---

##  Project Purpose

LogSentry was created as a practical cybersecurity learning project to strengthen understanding of:

- Security Operations Center (SOC) workflows
- Authentication log analysis
- Incident detection
- Threat investigation
- Case management concepts

rather than functioning as a production SIEM solution.

---

##  License

This project is released for educational purposes.

---

##  Author

**Divakar**

Cybersecurity Student | Future SOC Analyst

Focused on:

- Security Operations
- Blue Teaming
- Threat Detection
- Incident Response
- Network Security

---
⭐ If you found this project interesting, consider giving it a star.
