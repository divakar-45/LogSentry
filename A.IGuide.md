# 🤖 AI-Assisted Development Guide

# LogSentry v0.8 (Student Edition)

---

# Purpose of this Document

This document explains how Artificial Intelligence (AI) was used during the development of LogSentry.

The purpose is to provide transparency regarding the development process while clearly distinguishing between software implementation assistance and project ownership.

---

# Development Philosophy

LogSentry was developed using an AI-assisted software development workflow.

The project was not created by simply generating code.

Instead, AI was used as a technical assistant to accelerate software development while the cybersecurity concepts, workflows, and project direction were designed, validated, and controlled by the project author.

---

# Project Ownership

The following aspects of LogSentry were independently designed by the project author.

## Project Vision

- Develop a desktop application simulating a Security Operations Center (SOC) workflow.
- Focus on Blue Team operations rather than offensive security.
- Create an educational SOC investigation platform.

---

## Cybersecurity Objectives

The project author defined the objectives to:

- Import authentication logs.
- Detect suspicious authentication activities.
- Simulate analyst investigations.
- Map alerts to MITRE ATT&CK.
- Generate investigation reports.
- Store incidents for future analysis.

---

## Detection Logic

The security detection rules were selected and validated by the project author.

Examples include:

- Brute Force Attack Detection
- Password Spraying Detection
- Midnight Login Detection

The conditions, expected behavior, and intended analyst workflow were determined before implementation.

---

## Functional Requirements

The project author decided to include:

- Dashboard
- Threat Timeline
- Alert Investigation
- Incident Saving
- SQLite Database
- CSV Reporting
- MITRE ATT&CK Mapping

These functional requirements were not generated automatically by AI.

---

# How AI Was Used

Artificial Intelligence served as a software development assistant throughout the implementation process.

AI assistance included:

## Java Programming

- Writing Java classes
- Improving code structure
- Refactoring methods
- Explaining object-oriented programming concepts

---

## Software Architecture

AI provided guidance regarding:

- MVC Architecture
- Repository Pattern
- Database Layer
- Package Organization
- Code Separation

---

## Debugging

AI assisted with resolving issues including:

- Compilation errors
- Runtime exceptions
- SQLite integration
- Swing event handling
- JDBC configuration
- Git setup

---

## Documentation

AI assisted in producing:

- README
- Lab Guide
- User Manual
- Installation Guide
- Architecture Documentation

---

# Development Workflow

The project followed an iterative sprint-based workflow.

```

Idea

↓

Requirement Analysis

↓

Cybersecurity Logic Design

↓

AI Assisted Implementation

↓

Manual Testing

↓

Debugging

↓

Feature Validation

↓

Git Commit

↓

Next Sprint

```

Each sprint was individually compiled, tested, and validated before proceeding.

---

# Human Validation

Every feature generated with AI assistance was:

- Reviewed manually.
- Compiled successfully.
- Tested using sample authentication logs.
- Debugged when necessary.
- Integrated only after verification.

No generated code was accepted without testing.

---

# Technical Decisions Made by the Project Author

Examples include:

- Choosing Java Swing.
- Choosing SQLite.
- Selecting MITRE ATT&CK integration.
- Designing the SOC workflow.
- Selecting authentication logs.
- Defining project scope.
- Planning future enhancements.
- Deciding project milestones.

---

# Educational Purpose

The primary purpose of LogSentry is educational.

The project was created to strengthen understanding of:

- Security Operations Center workflows.
- Authentication log analysis.
- Incident response concepts.
- Threat detection.
- Java desktop application development.

It is not intended to replace commercial SIEM platforms.

---

# Ethical Use of AI

The project follows responsible AI-assisted software development practices.

AI was used to:

- Improve productivity.
- Explain concepts.
- Accelerate implementation.
- Reduce repetitive coding tasks.

The project author remained responsible for:

- Design decisions.
- Cybersecurity concepts.
- Feature selection.
- Testing.
- Validation.
- Final integration.

---

# Author Statement

I developed LogSentry to improve my understanding of Security Operations Center (SOC) workflows and cybersecurity concepts.

Artificial Intelligence was used as a programming and development assistant throughout the implementation process.

The cybersecurity objectives, detection logic, investigation workflow, project direction, and final validation were designed, reviewed, tested, and understood by me before inclusion in the project.

This project reflects my learning journey in cybersecurity while responsibly using modern AI development tools.

---

# Future Development

Version 1.0 will continue following the same development philosophy:

- Human-driven cybersecurity design.
- AI-assisted software implementation.
- Manual testing.
- Incremental validation.
- Transparent documentation.

---

# Closing Note

Modern software development increasingly incorporates AI-assisted tools.

LogSentry demonstrates a transparent approach where AI accelerates implementation while human understanding, engineering judgment, and cybersecurity knowledge remain central to the project.
