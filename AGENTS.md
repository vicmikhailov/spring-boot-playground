# AGENTS.md

## Scope and purpose

- This is a Spring Boot 4.0 playground demonstrating multiple data access and lifecycle patterns.
- Main runtime entrypoint: `src/main/java/ca/mikhailov/SpringBootAppApplication.java`.
- Primary Modules:
    - `ca.mikhailov.dataview`: JDBC-based dynamic "record view" responses.
    - `ca.mikhailov.jpa`: Standard Spring Data JPA with Author/Book relationships.
    - `ca.mikhailov.prototype`: Demonstration of Prototype bean scope and `@Lookup`.

## Architecture at a glance

### Data View (JDBC)

- Flow: `UserController -> ViewService -> GenericViewRepositoryImpl -> H2`.
- `GenericViewRepositoryImpl` builds dynamic `RecordView` payloads using `ResultSetMetaData` (column label, value, SQL
  type).
- Uses raw `JdbcTemplate` for both typed (`User`) and untyped data.
- Implements manual pagination with `LIMIT` and `OFFSET` using Spring Data's `Pageable` and `PageImpl`.

### JPA CRUD

- Flow: `AuthorController/BookController -> Service -> Repository (Spring Data) -> H2`.
- Demonstrates bidirectional One-to-Many mapping with `EAGER` fetching on the "One" side.
- Managed by `jakarta.persistence` annotations.

### Prototype Demo

- Demonstrates the "Method Injection" pattern using Spring's `@Lookup`.
- `CounterUser` (Singleton) obtains fresh `Counter` (Prototype) instances via a protected method overridden by Spring.

## Data and config conventions

- DB is in-memory H2 (`jdbc:h2:mem:testdb`) configured in `src/main/resources/application.yml`.
- Schema and seed run automatically for JDBC users from `src/main/resources/schema.sql` and
  `src/main/resources/seed_users.sql`.
- JPA data is initialized via `ca.mikhailov.jpa.config.DataInitializer` on startup.
- App runs on port `8888`.

## Project-specific patterns to follow

- **Injection**: Prefer constructor injection for services/repositories. Controllers in `dataview` use `@Autowired`
  field injection, but newer `jpa` controllers use constructor injection.
- **Data Access**:
    - Use raw SQL in `dataview` repository methods.
    - Implement pagination using `Pageable` and `Page<T>` even for JDBC-based repositories.
    - Use Spring Data JPA interfaces in `jpa` repositories.
- **Models**:
    - `User` is a Java `record`.
    - JPA entities (`Author`, `Book`) are standard POJOs with getters/setters.
    - Generic view shape is `RecordView{id, field: List<Field>}`.

## Integration and extension points

- `application.yml` imports `user-mapping.yml`; `ViewProperties` is available for future configurable view logic.
- `PrototypeDemoRunner` logs to console at startup; keep this in mind when checking logs.

## Developer workflow (verified in this repo)

- Run tests: `./mvnw -q test`
- Run app: `./mvnw spring-boot:run`
- Key Endpoints:
    - [http://localhost:8888/api/users](http://localhost:8888/api/users) (Paginated, e.g., `?page=0&size=5`)
    - [http://localhost:8888/api/users/records](http://localhost:8888/api/users/records) (Paginated)
    - [http://localhost:8888/api/jpa/authors](http://localhost:8888/api/jpa/authors)
    - [http://localhost:8888/swagger-ui/index.html](http://localhost:8888/swagger-ui/index.html)

