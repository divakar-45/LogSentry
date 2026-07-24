# ⚙️ INSTALLATION_GUIDE.md

# LogSentry Installation Guide

Version 0.8 (Student Edition)

---

# 1. Introduction

This guide explains how to install and run LogSentry on a Windows system.

The application is intended for educational purposes and demonstrates Security Operations Center (SOC) concepts using Java Swing and SQLite.

---

# 2. System Requirements

## Operating System

- Windows 10
- Windows 11

---

## Java

Java Development Kit (JDK)

Recommended Version

Java 21 or later

*(The project was developed using Java 26.)*

---

## Required Software

- Visual Studio Code
- Extension Pack for Java
- Git
- DB Browser for SQLite

---

# 3. Clone the Repository

Open PowerShell.

Run:

```bash
git clone https://github.com/<YOUR_USERNAME>/LogSentry.git
```

Open the project folder.

---

# 4. Install SQLite JDBC Driver

Download

```
sqlite-jdbc-3.53.2.0.jar
```

Place the file inside

```
LogSentry/lib/
```

---

# 5. Verify Project Structure

The project should look like:

```
LogSentry

│

├── src

├── lib

│      sqlite-jdbc-3.53.2.0.jar

├── database

├── sample_logs

├── screenshots

├── README.md

└── run.bat
```

---

# 6. Open the Project

Open Visual Studio Code.

Select

```
File

↓

Open Folder

↓

LogSentry
```

Wait until Java finishes indexing the project.

---

# 7. Running the Application

Double-click

```
run.bat
```

The script automatically

- Compiles the project
- Connects SQLite
- Creates the database if necessary
- Launches LogSentry

---

# 8. Import Sample Logs

Inside LogSentry

Click

```
Import Logs
```

Select

```
sample_logs/sample1.txt
```

Expected Result

- Dashboard updates
- Alerts generated
- Timeline populated

---

# 9. SQLite Database

Database Location

```
src/database/logsentry.db
```

The application automatically creates

```
incidents
```

table during startup.

---

# 10. Verify Database

Open

```
DB Browser for SQLite
```

Open

```
src/database/logsentry.db
```

Browse

```
incidents
```

Saved incidents should appear here.

---

# 11. Generate Report

Click

```
Generate Report
```

Choose a location.

Output

```
SOC_Report.csv
```

---

# 12. Troubleshooting

## SQLite Driver Not Found

Verify

```
lib/sqlite-jdbc-3.53.2.0.jar
```

exists.

---

## Compilation Errors

Ensure Java JDK is installed.

Verify

```
java -version
```

returns a valid version.

---

## Database Connection Error

Verify

- SQLite JDBC Driver
- Database folder
- Referenced Libraries

---

## VS Code Cannot Find Packages

Install

```
Extension Pack for Java
```

Restart VS Code.

---

# 13. Updating the Project

Pull the latest changes.

```bash
git pull
```

Run

```
run.bat
```

again.

---

# 14. Project Dependencies

- Java
- Java Swing
- SQLite JDBC
- Git

No external frameworks are required.

---

# 15. Conclusion

After completing these steps, LogSentry should be fully operational.

Users can import logs, detect suspicious activities, investigate alerts, save incidents, and generate reports using a standalone Java desktop application.
