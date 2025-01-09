# Spring Boot TDD Application

This project demonstrates building a Spring Boot application with **Test-Driven Development (TDD)** principles. The application provides a simple greeting API, database persistence using JPA, global exception handling, and input validation. The project also includes a CI/CD pipeline implemented with GitHub Actions and is containerized using Docker.

---

## Features

- **Greeting API**: Provides personalized greetings for users.
- **Database Persistence**: Saves and retrieves greeting messages using an in-memory H2 database.
- **String Calculator**: A modular utility for calculating sums from string inputs with support for custom delimiters, handling large numbers, and more.
- **Global Exception Handling**: Centralized error handling for clean and consistent error responses.
- **Input Validation**: Ensures proper validation of user inputs with reusable helper classes.
- **TDD**: Demonstrates step-by-step evolution of the application with comprehensive unit and integration tests.
- **CI/CD Pipeline**: Automatically builds, tests, and deploys the application using GitHub Actions.
- **Docker Containerization**: Package and run the application as a Docker container for easy deployment and scalability.

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
|   |   |   ├── StringHelpersTest.java      # Tests for the String Calculator
│   │   │   └── SpringBootTlddApplicationTests.java # Main test class
```


---

## Technologies Used

- **Spring Boot**: Framework for building Java-based web applications.
- **Spring Data JPA**: Simplified database access and ORM (Object-Relational Mapping).
- **H2 Database**: Lightweight, in-memory database for testing and development.
- **JUnit 5**: Testing framework for writing unit and integration tests.
- **Lombok**: Reduces boilerplate code with annotations such as `@Getter`, `@Setter`, and more.
- **Docker**: Containerization platform for packaging and running the application.
- **GitHub Actions**: CI/CD pipeline for automating builds, tests, and deployments.
---

## CI/CD Pipeline

The CI/CD pipeline is implemented using GitHub Actions and performs the following tasks:

### 1. Build and Test:

Uses Maven to build the application and run unit tests.

Caches Maven dependencies for faster builds.


### 2. Docker Image Build and Push:

Builds a Docker image of the application.

Tags and pushes the Docker image to DockerHub.


### 3. Container Testing:

Runs the Docker container and validates its behavior using curl.

## Workflow Trigger

The pipeline is triggered automatically on every push to the testing-ci-cd branch.


### Key Workflow Steps

- Clone the repository and set up the environment.

- Build the Spring Boot application using Maven.

- Build and tag the Docker image:

```
spring-boot-tdd-app:latest
spring-boot-tdd-app:<unique-build-id>
```

- Push the Docker image to DockerHub.

- Run and validate the Docker container.
  
---

## Docker Containerization

### 1. Build the Docker Image

docker build -t spring-boot-tdd-app:latest .

### 2. Run the Docker Container

docker run -p 8080:8080 spring-boot-tdd-app:latest

### 3. Access the Application

Open http://localhost:8080/greet/hello/John in your browser or API client to test the application.


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

### String Calculator
The String Calculator performs arithmetic operations on strings with the following features:

#### Supported Features
- **Basic Addition**: Computes sums for numbers in a string (e.g., "1,2" returns 3).
- **Multiple Numbers**: Supports an unknown number of inputs (e.g., "1,2,3").
- **Custom Delimiters**: Allows custom delimiters like "//[delimiter]\\n[numbers]" (e.g., "//;\\n1;2").
- **Newlines as delimiters**: "1\\n2,3".
- **Multi-character delimiters**: "//[***]\\n1***2***3".
- **Multiple delimiters**: "//[*][%]\\n1*2%3".
- **Negative Number Handling**: Throws an exception listing all negative numbers with the message "Negatives not allowed: -1, -2".
- **Ignore Large Numbers**: Ignores numbers greater than 1000 (e.g., "2,1001" returns 2).


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
- `StringCalculatorTest`: Contains step-by-step TDD tests for the String Calculator.

## Future Enhancements
- Add Swagger UI for API documentation.
- Implement a CI/CD pipeline using GitHub Actions or Jenkins.
- Containerize the application using Docker.
- Add more advanced String Calculator operations like subtraction or multiplication.

## License
This project is open-sourced under the [MIT license](https://opensource.org/licenses/MIT).
#### 1. Run Unit and Integration Tests
```bash
mvn test
```
#### 2. Key Test Classes
- `GreetTest`: Contains tests for the greeting API.
- `GreetingRepositoryTest`: Contains tests for the database persistence logic.
- `SpringBootTlddApplicationTests`: Main test class that loads the Spring context.
- `GlobalExceptionHandlerTest`: Tests for global exception handling.
- `StringCalculatorTest`: Contains step-by-step TDD tests for the String Calculator.

## Future Enhancements
- Add Swagger UI for API documentation.
- Enhance the CI/CD pipeline for multi-environment deployment.
- Implement Kubernetes deployment for container orchestration.
- Add more advanced String Calculator operations like subtraction or multiplication.

## License
This project is open-sourced under the [MIT license](https://opensource.org/licenses/MIT).
