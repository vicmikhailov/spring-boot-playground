Spring Boot 4.0 Playground
==========================

This is a comprehensive Spring Boot 4.0 playground demonstrating three distinct architectural patterns:

1. **Dynamic Data Views (JDBC)**: Manual mapping using `JdbcTemplate` and metadata-driven dynamic JSON responses.
2. **Standard JPA CRUD**: Robust entity mapping, repository patterns, and One-to-Many relationships.
3. **Spring Bean Scopes**: A focused demonstration of `Prototype` vs `Singleton` bean lifetimes using the `@Lookup`
   annotation.

## Project Structure

```
spring-boot-playground
├── src/main/java/ca/mikhailov
│   ├── SpringBootAppApplication.java   # App Entrypoint
│   ├── dataview/                       # JDBC / dynamic view demo
│   │   ├── config/                     # H2, Swagger, CORS, ViewProperties
│   │   ├── controller/                 # UserController (standard and records)
│   │   ├── model/                      # Java records (User), dynamic RecordView
│   │   ├── repository/                 # Raw JdbcTemplate + ResultSetMetaData
│   │   └── service/                    # View and User services
│   ├── jpa/                            # JPA demo
│   │   ├── config/                     # DataInitializer (seeds Author/Book)
│   │   ├── controller/                 # Author/Book CRUD controllers
│   │   ├── model/                      # Author/Book JPA entities
│   │   ├── repository/                 # Spring Data JPA repositories
│   │   └── service/                    # JPA service implementations
│   └── prototype/                      # Bean scope demo
│       ├── Counter.java                # Prototype-scoped bean
│       ├── CounterUser.java            # Singleton using @Lookup
│       └── PrototypeDemoRunner.java    # Startup demo using CommandLineRunner
├── src/main/resources
│   ├── application.yml                 # Core config (port 8888, H2, imports)
│   ├── schema.sql                      # DDL for 'users' table
│   ├── seed_users.sql                  # Seed data for 'users'
│   └── *.sql / *.yml                   # JDBC view configuration fragments
└── pom.xml                             # Spring Boot 4.0 / Java 24 setup
```

## Key Demonstration Areas

### 1. Dynamic Data Views (JDBC)

Located in `ca.mikhailov.dataview`, this module bypasses standard ORM logic to provide raw control over SQL execution
and response shaping.

- **`UserRepositoryImpl`**: Uses standard `JdbcTemplate` with a custom `RowMapper`.
- **`GenericViewRepositoryImpl`**: Uses `ResultSetMetaData` to transform any SQL query result into a generic
  `RecordView` containing named fields and their SQL data types.
- **Pagination**: Demonstrates how to implement manual pagination using Spring Data's `Pageable` and return `Page<T>` in
  a raw JDBC context.

### 2. Standard JPA CRUD

Located in `ca.mikhailov.jpa`, this module showcases idiomatic Spring Data JPA usage.

- **`Author` & `Book`**: Entities with a bidirectional One-to-Many relationship.
- **Cascade & Fetching**: Demonstrates `CascadeType.ALL` and `FetchType.EAGER` for relationship management.
- **RESTful API**: Standard GET, POST, PUT, PATCH, DELETE endpoints.

### 3. Bean Scopes (Prototype)

Located in `ca.mikhailov.prototype`, this module demonstrates how to manage different bean lifecycles.

- **`@Scope("prototype")`**: A fresh instance of `Counter` is created for every request.
- **`@Lookup`**: Shows how a `Singleton` bean can correctly obtain a fresh `Prototype` instance on every method call,
  avoiding the "stale instance" problem common with standard field injection.

## Setup & Execution

1. **Build the Project**
   ```bash
   ./mvnw clean install
   ```

2. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Explore Endpoints**
   - **Interactive UI**: [http://localhost:8888/swagger-ui/index.html](http://localhost:8888/swagger-ui/index.html)
   - **JDBC Users**: [http://localhost:8888/api/users](http://localhost:8888/api/users)
   - **JDBC Dynamic Records**: [http://localhost:8888/api/users/records](http://localhost:8888/api/users/records)
   - **JPA Authors**: [http://localhost:8888/api/jpa/authors](http://localhost:8888/api/jpa/authors)
   - **JPA Books**: [http://localhost:8888/api/jpa/books](http://localhost:8888/api/jpa/books)
   - **H2 Console**: [http://localhost:8888/h2-console](http://localhost:8888/h2-console) (JDBC URL:
     `jdbc:h2:mem:testdb`)

## Configuration

- **Server Port**: `8888` (default).
- **Database**: H2 In-Memory.
- **Java Version**: 24.
- **Spring Boot**: 4.0.0.

## License

MIT License.
