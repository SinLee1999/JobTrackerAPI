# Job Tracker API

A backend REST API built with Spring Boot for managing job applications. This project uses MySQL for data storage and Spring Data JPA for database operations.

## Features

- View all job applications
- View a single job application by ID
- Update existing job applications
- Delete job applications
- MySQL database integration
- DTO-based request and response structure

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation
- DTO Pattern
- MySQL
- Maven
  
## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/jobs` | Get all job applications |
| GET | `/jobs/{id}` | Get one job application by ID |
| POST | `/jobs` | Create a new job application |
| PUT | `/jobs/{id}` | Update a job application |
| DELETE | `/jobs/{id}` | Delete a job application |

## Example JSON

```json
{
  "company": "Google",
  "role": "Backend Developer",
  "status": "APPLIED"
}
```

## Enums

 Status: APPLIED, INTERVIEW, REJECTED, OFFER

## Running the Project

1. Start MySQL service
2. Create a database named:

```sql
CREATE DATABASE jobtracker;
```

3. Update your MySQL password inside `application.properties`
4. Run the Spring Boot application
5. Test endpoints using Postman

## Project Structure

```text
src/main/java
 ├── controller
 ├── service
 ├── repository
 ├── entity
 └── JobTrackerApplication
```

## Architecture

This project follows a layered architecture:

Controller → Service → Repository → Database

DTOs are used to separate internal entity models from external API responses.

## Screenshot

<img width="603" height="769" alt="image" src="https://github.com/user-attachments/assets/841a097a-9625-45d7-83e6-6a4b7866c4d4" />


## Future Improvements

- Pagination and filtering for job listings
- Input validation and better error handling
- Authentication
- Improved request validation
- Multi-user system design

## Author

Sin Lee
