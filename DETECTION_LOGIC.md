# 🛡 DETECTION_LOGIC.md

# LogSentry v0.8 (Student Edition)

---

# Introduction

The Detection Engine is the core cybersecurity component of LogSentry.

It analyzes imported authentication logs and applies predefined security detection rules to identify potentially malicious activities.

Unlike signature-based antivirus software, LogSentry currently uses **rule-based detection** to identify suspicious authentication behavior commonly monitored by Security Operations Centers (SOCs).

The purpose of these rules is educational—to simulate how SOC analysts identify suspicious authentication events during security monitoring.

---

# Detection Workflow

```

Authentication Logs

↓

Log Parser

↓

LogEntry Objects

↓

Detection Engine

↓

Rule Evaluation

↓

Alert Generation

↓

MITRE ATT&CK Mapping

↓

SOC Investigation

```

---

# Detection Rule 1

# Midnight Login

## Description

This rule detects successful logins occurring during unusual hours.

Authentication outside normal business hours may indicate unauthorized access, compromised credentials, or malicious activity.

---

## Detection Logic

```

IF

Login Status = SUCCESS

AND

Login Time is between

00:00 and 05:00

THEN

Generate Midnight Login Alert

```

---

## Severity

MEDIUM

---

## MITRE ATT&CK

Technique

```

T1078

```

Valid Accounts

---

## Why It Matters

Attackers frequently use compromised accounts during periods of reduced monitoring, such as late night or early morning.

Although legitimate maintenance activities can also occur during these hours, midnight logins should always be reviewed.

---

## Possible False Positives

- Night shift employees
- Maintenance windows
- Backup administrators
- Scheduled automated tasks

---

# Detection Rule 2

# Brute Force Attack

## Description

Detects repeated failed login attempts originating from the same source IP address.

---

## Detection Logic

```

IF

Failed Login Attempts

from same IP

>

Threshold

THEN

Generate Brute Force Alert

```

---

## Severity

HIGH

---

## MITRE ATT&CK

Technique

```

T1110.001

```

Password Guessing

---

## Why It Matters

Repeated authentication failures from a single source often indicate an attacker attempting to guess user credentials.

Successful brute force attacks may result in unauthorized system access.

---

## Indicators

- Same IP
- Multiple failed logins
- Short time interval
- Repeated authentication attempts

---

## Possible False Positives

- User repeatedly entering incorrect password
- Misconfigured application
- Automated monitoring tools

---

# Detection Rule 3

# Password Spraying

## Description

Detects authentication attempts against multiple user accounts using a single source IP address.

---

## Detection Logic

```

IF

Same IP Address

attempts login

against

Multiple User Accounts

THEN

Generate Password Spraying Alert

```

---

## Severity

HIGH

---

## MITRE ATT&CK

Technique

```

T1110.003

```

Password Spraying

---

## Why It Matters

Unlike brute force attacks targeting one account, password spraying attempts a small number of common passwords across many accounts to avoid account lockouts.

This technique is frequently used against enterprise environments.

---

## Indicators

- Same IP
- Different usernames
- Multiple failed logins
- Similar time period

---

## Possible False Positives

- Shared workstation
- Authentication proxy
- Misconfigured login scripts

---

# Alert Severity Model

LogSentry classifies alerts into four severity levels.

| Severity | Meaning |
|----------|---------|
| LOW | Informational activity requiring minimal attention |
| MEDIUM | Suspicious activity requiring analyst review |
| HIGH | High-confidence malicious behavior |
| CRITICAL | Immediate analyst response required |

Current Version primarily generates MEDIUM and HIGH alerts.

---

# Risk Assessment

Each generated alert is assigned a risk score.

The score is calculated based on factors including:

- Detection Rule
- Severity
- Authentication Result
- Source IP Activity

Risk scores help analysts prioritize investigations.

---

# MITRE ATT&CK Integration

Every alert is mapped to the MITRE ATT&CK framework.

This allows analysts to understand:

- Adversary Technique
- Attack Category
- Tactical Context

Current mappings include:

| Detection | MITRE Technique |
|-----------|-----------------|
| Midnight Login | T1078 - Valid Accounts |
| Brute Force | T1110.001 - Password Guessing |
| Password Spraying | T1110.003 - Password Spraying |

---

# Investigation Workflow

```

Alert Generated

↓

Analyst Reviews Alert

↓

MITRE Mapping

↓

Threat Assessment

↓

Incident Saved

↓

Report Generated

```

---

# Current Limitations

Current version focuses on authentication-based attacks.

The Detection Engine does not currently analyze:

- Malware execution
- Process creation
- Network traffic
- DNS activity
- PowerShell execution
- Windows Event Logs
- Registry modifications

These capabilities are planned for future versions.

---

# Planned Detection Rules

Future versions may include:

- Impossible Travel Detection
- Privilege Escalation Detection
- Suspicious PowerShell Execution
- Account Lockout Monitoring
- Service Account Abuse
- RDP Brute Force
- Credential Stuffing
- Multiple Geographic Login Detection
- Suspicious VPN Login Detection
- Data Exfiltration Detection

---

# Educational Purpose

The detection rules implemented in LogSentry are intended for educational purposes.

They demonstrate how Security Operations Center analysts use rule-based logic to identify suspicious authentication behavior and initiate incident investigations.

The project is not intended to replace enterprise SIEM solutions but rather to reinforce practical cybersecurity concepts through hands-on implementation.

---

# Conclusion

The Detection Engine represents the cybersecurity core of LogSentry.

By combining authentication log analysis, rule-based detection, MITRE ATT&CK mapping, severity classification, and incident investigation workflows, LogSentry provides a practical simulation of fundamental SOC monitoring and response activities.
