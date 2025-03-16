# Statement Generation Demo

A Spring Boot service that generates account statements asynchronously.

## Technology Stack
- Spring Boot 3.4.3
- Java 21
- Gradle
- Mockito

## Setup Instructions

### Prerequisites
- Java 21
- Gradle 8.x (8.12.1)

### Building the Project
```bash
./gradlew clean build
```

### Running the Application
```bash
./gradlew bootRun
```
The service will start on http://localhost:8080

## API Usage Guide

### Endpoint: GET /statements

### Query Parameters:
- accountNumber (required): The account number
- fromDate (required): Start date in yyyy-MM-dd format
- toDate (required): End date in yyyy-MM-dd format

### Example Request:
```
curl -X GET 'http://localhost:8080/statements?accountNumber=1000000001&fromDate=2024-01-01&toDate=2024-06-30'
```
Or use API tool like Postman, etc.

### Example Response:
```json
{
    "code": 0,
    "msg": "Operation successful",
    "content": {
        "count": 0,
        "limit": 0,
        "data": []
    }
}
```
## Design Decisions
### Asynchronous Processing
- Uses a thread pool (ThreadPoolTaskExecutor) for asynchronous statement generation
- Core pool size: 20
- Max pool size: 50
- Queue capacity: 1000
- Rejection policy: AbortPolicy (default) - so users know whether the request was processed or not
### Validation
- Uses Jakarta Bean Validation for request validation
### Service Architecture
- Statement Service for asynchronous statement generation
- Mocked Core Banking Service for transaction data
- Mocked Template Engine Service for PDF generation

## Test Execution
```bash
./gradlew test
```