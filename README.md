# Spring Boot Application

This is a Spring Boot application that demonstrates the use of Spring Data JdbcTemplate with an H2 database, RESTful API
endpoints, and Swagger documentation for API documentation.

## Project Structure

```
spring-boot-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── springbootapp
│   │   │               ├── SpringBootAppApplication.java
│   │   │               ├── controller
│   │   │               │   └── UserController.java
│   │   │               ├── model
│   │   │               │   └── User.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               └── config
│   │   │                   └── config.ca.mikhailov.dataview.SwaggerConfig.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── springbootapp
│                       └── SpringBootAppApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```
   git clone <repository-url>
   cd spring-boot-app
   ```

2. **Build the Project**
   Ensure you have Maven installed, then run:
   ```
   mvn clean install
   ```

3. **Run the Application**
   You can run the application using:
   ```
   mvn spring-boot:run
   ```

4. **Access the API**
   The RESTful API is available at `http://localhost:8080/api/users`.

5. **Swagger Documentation**
   Access the Swagger UI at `http://localhost:8080/swagger-ui/` to view and interact with the API documentation.

## Dependencies

This project uses the following dependencies:

- Spring Boot
- Spring Data JdbcTemplate
- H2 Database
- Swagger for API documentation

## License

This project is licensed under the MIT License.
