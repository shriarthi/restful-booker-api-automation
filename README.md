# REST Assured API Automation Framework

## Project Overview

A Java-based REST API automation testing framework built using **REST Assured, TestNG, Maven, and Hamcrest**.

This project automates functional testing of the [Restful Booker API](https://restful-booker.herokuapp.com), covering booking management, authentication, and negative testing.

## Tech Stack

- **Programming Language:** Java 17
- **API Automation:** REST Assured 5.5.6
- **Testing Framework:** TestNG 7.11.0
- **Build Tool:** Maven
- **Assertions:** Hamcrest 2.2
- **Version Control:** Git and GitHub

## Project Structure

```text
src/test/java/com/api/automation/
├── base/
│   └── BaseTest.java
├── client/
│   └── BookingApiClient.java
├── data/
│   └── BookingTestData.java
└── tests/
    ├── BookingAuthTest.java
    ├── BookingCreateTest.java
    ├── BookingDeleteTest.java
    ├── BookingGetTest.java
    ├── BookingNegativeTest.java
    ├── BookingPatchTest.java
    └── BookingUpdateTest.java
```

## Test Coverage

| HTTP Method | Test Scenario |
|---|---|
| POST | Create a new booking |
| GET | Retrieve a booking |
| GET | Retrieve all bookings |
| POST | Generate authentication token |
| PUT | Update an existing booking |
| PATCH | Partially update a booking |
| DELETE | Delete a booking |
| Negative | Validate invalid booking ID |
| Negative | Validate invalid authentication |

## Framework Features

- Reusable API client methods
- Common request and response specifications
- Centralized booking test data
- Dynamic booking creation
- HTTP status code and response validation
- TestNG suite execution
- Maven Surefire integration

## How to Run

**Prerequisites:** Java 17 and Maven.

Clone the repository:

```bash
git clone https://github.com/shriarthi/restful-booker-api-automation.git
```

Navigate to the project directory:

```bash
cd restful-booker-api-automation
```

Run the automated tests:

```bash
mvn clean test
```

## Test Execution Results

Latest verified local test execution:

- **Total tests:** 9
- **Passed:** 9
- **Failed:** 0
- **Skipped:** 0
- **Build:** SUCCESS

Test reports are generated in `target/surefire-reports/`.

## Future Enhancements

- GitHub Actions CI/CD integration
- Additional negative and boundary test scenarios
- Enhanced reporting
- Environment-specific configuration
