# OpenMRS UI Automation Framework

## Overview
This project is a Selenium-based UI automation framework built using Java and TestNG for the OpenMRS application.

It focuses on real-world UI automation challenges such as dynamic elements, synchronization, reusable components, and scalable test design.

---

## Tech Stack
- Language: Java  
- Automation: Selenium WebDriver  
- Test Framework: TestNG  
- Build Tool: Maven  
- Design Pattern: Page Object Model (POM)  
- Reporting: Extent Reports  
- Logging: Log4j2  
- CI/CD: GitHub Actions  

---

## Features
- Page Object Model (POM) design
- Reusable test components
- Explicit waits for synchronization
- Logging with Log4j2
- Extent HTML reporting
- CI execution support
- Scalable and maintainable framework

---

## Application Under Test
OpenMRS (Open Medical Record System)

---

## Project Structure
src
 ├── main
 │   └── java
 │       └── pages
 │
 ├── test
 │   ├── java
 │   │   ├── testCases
 │   │   ├── base
 │   │   └── utilities
 │   └── resources
 │       └── config files

---

## Key Test Scenarios
- Login functionality
- Patient registration
- Navigation and validation of modules
- UI validations and assertions

---

## How to Run Tests

Run all tests:
mvn clean test

Run specific test:
mvn test -Dtest=TestClassName

---

## Reporting
Extent Reports are generated after execution:
target/ExtentReports.html

---

## Logging
- Implemented using Log4j2  
- Captures test execution flow, failures, and debug info  

---

## CI/CD
- Integrated with GitHub Actions  
- Tests run automatically on code push  

---

## Key Highlights
- Real-world UI automation framework  
- Proper use of Page Object Model  
- Handles synchronization issues  
- Clean and maintainable code structure  

---

## Author
Aniket  
QA Engineer | Automation Testing
