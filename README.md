# Library Management System (LMS) - REST API

A RESTful Library Management System built with Spring Boot, demonstrating clean layered architecture, JPA relationships, global exception handling, and request validation.

## Features

- Full CRUD operations for Books and Members
- Borrow and return book functionality with availability tracking
- Entity relationships using JPA (`@ManyToOne`)
- Global exception handling with proper HTTP status codes
- Request validation using Bean Validation (`@NotBlank`, `@Email`)
- Clean three-layer architecture (Controller → Service → Repository)

## Tech Stack

- **Java 26**
- **Spring Boot 4.0.6**
- **Spring Data JPA / Hibernate**
- **MySQL**
- **Maven**
- **Bean Validation (Jakarta Validation)**

## Architecture

```
Controller  →  Service  →  Repository  →  Database
```

| Layer | Responsibility |
|---|---|
| Controller | Handles HTTP requests and responses |
| Service | Contains business logic |
| Repository | Handles database operations via Spring Data JPA |

## Project Structure

```
src/main/java/com/lms/library/
├── controller/        # REST controllers
├── service/            # Business logic
├── repository/         # JPA repositories
├── model/              # Entity classes
├── exception/          # Custom exceptions and global handler
└── LibraryApplication.java
```

## Entity Relationships

- A `BorrowRecord` belongs to one `Member` and one `Book` (`@ManyToOne`)
- A `Member` can have many `BorrowRecord`s
- A `Book` can appear in many `BorrowRecord`s over time

## API Endpoints

### Books

| Method | Endpoint | Description |
|---|---|---|
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get a book by ID |
| POST | `/books` | Add a new book |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |

### Members

| Method | Endpoint | Description |
|---|---|---|
| GET | `/members` | Get all members |
| GET | `/members/{id}` | Get a member by ID |
| POST | `/members` | Add a new member |
| PUT | `/members/{id}` | Update a member |
| DELETE | `/members/{id}` | Delete a member |

### Borrow Records

| Method | Endpoint | Description |
|---|---|---|
| POST | `/borrow/{memberId}/{bookId}` | Borrow a book |
| PUT | `/return/{borrowRecordId}` | Return a borrowed book |
| GET | `/borrow/all` | Get all borrow records |

## Validation Rules

| Field | Rule |
|---|---|
| Book title | Cannot be blank |
| Book author | Cannot be blank |
| Member name | Cannot be blank |
| Member email | Cannot be blank, must be a valid email format |

## Exception Handling

A global exception handler (`@RestControllerAdvice`) returns consistent JSON error responses:

```json
{
    "timestamp": "2026-06-14T09:32:50.05",
    "status": 404,
    "error": "Book Not Found"
}
```

| Scenario | Status Code |
|---|---|
| Resource not found | 404 |
| Validation failure | 400 |
| Unexpected server error | 500 |

## Setup Instructions

1. Clone the repository
   ```
   git clone https://github.com/Sivethan01/library-management-system.git
   ```
2. Create a MySQL database:
   ```sql
   CREATE DATABASE librarydb;
   ```
3. Update `src/main/resources/application.properties` with your MySQL username and password
4. Run the application:
   ```
   mvn spring-boot:run
   ```
5. The API will be available at `http://localhost:8080`

## Future Improvements

- JWT-based authentication and authorization with Spring Security
- Caching frequently accessed endpoints (e.g. `getAllBooks`)
- Pagination and sorting for large datasets
- Dockerized deployment

## Author

Sivethan
