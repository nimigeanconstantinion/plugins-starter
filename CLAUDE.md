# CLAUDE.md

## What this repo is

`online-school-cloud-api`: a Spring Boot 3.5 / Java 21 REST API for an online school (students, teachers, administrators, courses, books, enrolments), secured with JWT and permission-based authorities. Schema is managed by Liquibase (`src/main/resources/db/changelog/`), `ddl-auto` is `validate`.

**This is a starter for the plugins lesson.** There is no `.claude/` toolkit here on purpose: the review rules, the guards and the CI review job are built as plugins in a separate repo and plugged in here.

## Commands

| What | Command |
|---|---|
| Build + tests | `./mvnw -B verify` (Windows: `mvnw.cmd -B verify`) |
| Single test | `./mvnw test -Dtest=<TestClass>` |
| Local run | `./mvnw spring-boot:run` (needs MySQL on `localhost:3306`, or `DB_URL`/`DB_USERNAME`/`DB_PASSWORD`) |

Tests run on H2 (`src/test/resources/application-test.yaml`), no MySQL needed. Swagger: `/swagger-ui.html`, port `8081`.

## Layout

One package per feature under `com.example.springbd3big`: `auth`, `book`, `course`, `enrolment`, `user` (`student`, `teacher`, `administrator`, `permission`), each with `controller` → `service` → `repository`, `dtos`, `mappers`, `model` (JPA entities). Cross-cutting config in `config/` (security, swagger, `GlobalExceptionHandler`).

## Conventions

- Configuration only from env vars with a default in `application.yaml`.
- Constructor injection, DTOs at the controller boundary, entities never leave the service layer.
- `@Transactional` on services, never on controllers.
- Access rules per path in `app.security.resource-rules`; public paths in `app.security.public-paths`.

## CI

`.github/workflows/ci.yml` runs `build-test` on every pull request to `main`.
