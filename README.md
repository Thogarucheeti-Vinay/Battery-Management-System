# Battery-Management-System

Welcome to the Battery Management System repository. This is designed to handle battery data submissions from electric vehicles and provide API endpoints for users to query battery information.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Contributing](#contributing)
- [Contact](#contact)

## Introduction

The Battery Management System Backend receives battery data from electric vehicles and stores it in a database. It also offers REST API endpoints for querying battery data based on specific criteria.

## Prerequisites

- Java (JDK version 17.0)
- [Your preferred database system (e.g., MySQL)](database-setup.md)
- [Your chosen Java framework (e.g., Spring Boot)](framework-setup.md)

## Getting Started

1. Clone this repository: `git clone https://github.com/Thogarucheeti-Vinay/Battery-Management-System.git`
2. Set up your database and update the database configuration in `application.properties` (or your framework's configuration file).
3. Build and run the project using your chosen framework's commands.

## API Endpoints

### Battery Data Submission

- `POST /api/saveBatteryData`
    - Description: Submit new battery data.
    - Request Body:
      ```json
      { 
          "batteryId": "string", 
          "current": float, 
          "voltage": float, 
          "temperature": float, 
          "time": "timestamp" 
      }
      ```
    - Response: Status 200 Created

### User Queries

- `GET /api/getBatteryInfoByID/{batteryID}`
    - Description: Get all data for a specific battery.
    - Response:
      ```json
      [
          {
              "batteryId": "string",
              "current": float,
              "voltage": float,
              "temperature": float,
              "time": "timestamp"
          },
          // More battery data entries
      ]
      ```

- `GET /api/getSpecificBatteryAttributeByID/{batteryID}/{attribute}`
    - Description: Get specific information (e.g., voltage, current, etc.) for a specific battery.
    - Query Params: field (e.g., "current", "voltage", "temperature")
    - Response:
      ```json
      {
          "attributeValueList": [value1, value2,..]
      }
      ```

- `GET /api/getSpecificBatteryAttributeByID/{batteryID}/{attribute}/{startTime}/{endTime}`
    - Description: Get specific information for a battery within a given time range.
    - Query Params: start and end timestamps
    - Response:
      ```json
      {
          "attributeValueList": [value1, value2,..]
      }
      ```

## Usage

1. Electric vehicles should make `POST` requests to `/api/saveBatteryData` with the required battery information.
2. Users can use the provided `GET` endpoints to retrieve battery data based on their requirements.

## Contributing

Contributions are welcome! If you encounter any issues or want to enhance the system, please feel free to submit a pull request. Please follow the coding guidelines and provide appropriate documentation.

## Contact

For any questions or assistance, please contact us at thogarucheetivinay8500@gmail.com.

Happy coding!
