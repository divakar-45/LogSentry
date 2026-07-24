# 🏗 Project Architecture

# LogSentry v0.8 (Student Edition)

---

# 1. Introduction

LogSentry follows a modular architecture inspired by the Model-View-Controller (MVC) design pattern.

The objective of this architecture is to separate the application's user interface, business logic, data processing, and persistence into independent components.

This approach improves maintainability, readability, debugging, and future scalability.

---

# 2. High-Level Architecture

```

                    +----------------------+
                    |      Log Files       |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    |      Log Parser      |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    |   Detection Engine   |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    |   Alert Generation   |
                    +----------+-----------+
                               |
              +----------------+----------------+
              |                                 |
              v                                 v
     Dashboard Panel                  Threat Timeline
              |                                 |
              +----------------+----------------+
                               |
                               v
                    +----------------------+
                    | Alert Details Dialog |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    | SQLite Repository    |
                    +----------+-----------+
                               |
                               v
                    +----------------------+
                    | SQLite Database      |
                    +----------------------+

```

---

# 3. Architecture Layers

## Presentation Layer

Responsible for user interaction.

Packages:

```

ui

```

Responsibilities

- Dashboard
- Timeline
- Alert Details
- Toolbar
- Status Bar
- User Interaction

---

## Controller Layer

Responsible for application flow.

Packages

```

controller

```

Responsibilities

- Import Logs
- Coordinate UI
- Connect UI with Services

---

## Service Layer

Responsible for business operations.

Packages

```

service

```

Responsibilities

- Log Import
- Log Processing
- File Handling

---

## Detection Layer

Responsible for cybersecurity detection logic.

Packages

```

detection

```

Responsibilities

- Rule Evaluation
- Alert Creation
- Severity Assignment

---

## Parser Layer

Responsible for converting raw text into structured log objects.

Packages

```

parser

```

Responsibilities

- Read Log Lines
- Parse Fields
- Create LogEntry Objects

---

## Repository Layer

Responsible for database communication.

Packages

```

repository

```

Responsibilities

- Save Incidents
- Execute SQL Queries
- SQLite Communication

---

## Database Layer

Responsible for database connectivity.

Packages

```

database

```

Responsibilities

- JDBC Connection
- Database Initialization
- Table Creation

---

## Model Layer

Represents application data.

Packages

```

model

```

Contains

- LogEntry
- Alert
- Severity
- RiskScore

---

## Report Layer

Responsible for report generation.

Packages

```

report

```

Responsibilities

- CSV Export

---

## MITRE Layer

Responsible for ATT&CK mapping.

Packages

```

mitre

```

Responsibilities

- Technique Mapping
- Threat Information

---

# 4. Package Structure

```

src

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

# 5. Data Flow

```

Authentication Log

↓

Parser

↓

LogEntry Object

↓

Detection Engine

↓

Alert Object

↓

Dashboard

↓

Alert Details

↓

SQLite Repository

↓

SQLite Database

```

---

# 6. Detection Workflow

```

Import Logs

↓

Parse Logs

↓

Evaluate Rules

↓

Generate Alerts

↓

Display Dashboard

↓

Investigate Alert

↓

Save Incident

↓

Generate Report

```

---

# 7. Design Patterns Used

## MVC (Model-View-Controller)

Separates

- User Interface
- Business Logic
- Data

Benefits

- Easier maintenance
- Better readability
- Scalable design

---

## Repository Pattern

Separates SQL logic from UI logic.

Benefits

- Cleaner architecture
- Easier database migration
- Better maintainability

---

# 8. Database Architecture

SQLite stores

- Incident ID
- Rule Name
- Source IP
- Severity
- Status
- Notes
- Created Time
- Updated Time

Database initialization occurs automatically when the application starts.

---

# 9. Security Workflow

```

Authentication Logs

↓

Threat Detection

↓

SOC Alert

↓

MITRE ATT&CK Mapping

↓

Analyst Investigation

↓

Incident Storage

↓

Reporting

```

---

# 10. Scalability

Future versions may include

- Case Management
- IOC Search
- Threat Intelligence
- Dashboard Analytics
- PDF Reports
- Multi-user Support

---

# 11. Why This Architecture?

This architecture was selected because it:

- Separates responsibilities.
- Simplifies debugging.
- Supports future enhancements.
- Keeps cybersecurity logic independent from UI code.
- Allows database expansion without changing detection logic.

---

# 12. Conclusion

LogSentry follows a modular architecture that combines Java desktop application development with practical cybersecurity workflows.

The architecture emphasizes maintainability, separation of concerns, and extensibility while demonstrating concepts commonly found in Security Operations Center (SOC) tools.
