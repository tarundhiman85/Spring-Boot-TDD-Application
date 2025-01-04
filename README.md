# Spring Boot TDD Application

This project demonstrates building a Spring Boot application with **Test-Driven Development (TDD)** principles. The application provides a simple greeting API, database persistence using JPA, global exception handling, and input validation.

---

## Features

- **Greeting API**: Provides personalized greetings for users.
- **Database Persistence**: Saves and retrieves greeting messages using an in-memory H2 database.
- **Global Exception Handling**: Centralized error handling for clean and consistent error responses.
- **Input Validation**: Ensures proper validation of user inputs with reusable helper classes.
- **TDD**: Demonstrates step-by-step evolution of the application with comprehensive unit and integration tests.

---

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── com.tarunspringboottldd.springboottldd/
│   │   │   ├── Constants/           # Constants for static messages
│   │   │   ├── Controller/          # REST API controllers
│   │   │   ├── Exception/           # Global exception handlers
│   │   │   ├── Helpers/             # Reusable helper classes
│   │   │   ├── Models/              # JPA entity classes
│   │   │   ├── Repository/          # Spring Data JPA repositories
│   │   │   └── SpringBootTlddApplication.java # Main application entry point
│   └── resources/
│       ├── application.properties   # Application configuration
│       └── static/                  # Static files (optional)
├── test/
│   ├── java/
│   │   ├── com.tarunspringboottldd.springboottldd/
│   │   │   ├── GreetingRepositoryTest.java # Tests for persistence logic
│   │   │   ├── GreetTest.java              # Tests for API functionality
│   │   │   └── SpringBootTlddApplicationTests.java # Main test class
```


---

## Technologies Used

- **Spring Boot**: Framework for building Java-based web applications.
- **Spring Data JPA**: Simplified database access and ORM (Object-Relational Mapping).
- **H2 Database**: Lightweight, in-memory database for testing and development.
- **JUnit 5**: Testing framework for writing unit and integration tests.
- **Lombok**: Reduces boilerplate code with annotations such as `@Getter`, `@Setter`, and more.

---

## API Endpoints

### 1. Greeting API
**Endpoint**: `GET /greet/hello/{name}`  
**Description**: Returns a greeting message for the given name.


#### Example Response:
```plaintext
Hello, John Welcome to Spring Boot
```

#### Error Response:
```plaintext
{
    "message": "Name must not be empty",
    "status": 400,
}
```
## Setup
### 1. Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- IDE with Lombok plugin (e.g., IntelliJ IDEA, Eclipse)
- Postman or any REST API client

### 2. Clone the Repository
```bash
git clone <repo-url>
cd spring-boot-tdd
```

### 3. Run the Application
```bash
mvn spring-boot:run
```
The application will start at `http://localhost:8080`.

### Testing
#### 1. Run Unit and Integration Tests
```bash
mvn test
```
#### 2. Key Test Classes
- `GreetTest`: Contains tests for the greeting API.
- `GreetingRepositoryTest`: Contains tests for the database persistence logic.
- `SpringBootTlddApplicationTests`: Main test class that loads the Spring context.
- `GlobalExceptionHandlerTest`: Tests for global exception handling.

## Future Enhancements
- Add Swagger UI for API documentation.
- Implement a CI/CD pipeline using GitHub Actions or Jenkins.
- Containerize the application using Docker.

## License
This project is open-sourced under the [MIT license](https://opensource.org/licenses/MIT).