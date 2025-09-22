# Copilot Instructions for AI Agents

## Project Overview
- This is a Spring Boot application for managing students, courses, instructors, and offices.
- Main package: `com.nishant0073.student_course_management_system`.
- Key sub-packages:
  - `Controller/`: REST controllers for API endpoints.
  - `Model/`: JPA entities (`Student.java`, `Course.java`, `Instructor.java`, `Office.java`).
  - `Repository/`: Spring Data JPA repositories (interfaces for DB access).
  - `Service/`: Business logic and service layer.
- Entry point: `StudentCourseManagementSystemApplication.java`.

## Build & Run
- Use Maven for all build and test tasks.
- Common commands:
  - Build: `./mvnw clean package`
  - Run: `./mvnw spring-boot:run`
  - Test: `./mvnw test`
- Java version: 17 (see `pom.xml`).

## Database & Persistence
- Uses Spring Data JPA and Hibernate for ORM.
- Default DB driver: Microsoft SQL Server (`mssql-jdbc`).
- DB config: `src/main/resources/application.properties`.
- HikariCP is used for connection pooling.

## Patterns & Conventions
- Entities are in `Model/` and annotated with JPA annotations.
- Repositories extend Spring Data JPA interfaces (e.g., `JpaRepository`).
- Controllers use `@RestController` and map to `/api/...` endpoints.
- Services encapsulate business logic and are injected into controllers.
- Follows standard Spring Boot layering: Controller → Service → Repository → Model.

## Testing
- Tests are in `src/test/java/com/nishant0073/student_course_management_system/`.
- Uses Spring Boot Test starter for integration and unit tests.

## External Dependencies
- See `pom.xml` for all dependencies (Spring Boot, Hibernate, SQL Server JDBC, etc).

## Examples
- To add a new entity: create a class in `Model/`, a repository in `Repository/`, and update services/controllers as needed.
- To add a new API: create a controller in `Controller/` and wire it to the service layer.

## Additional Notes
- No project-specific rules or agent instructions were found in the workspace.
- Follow standard Spring Boot and Maven conventions unless otherwise specified.
