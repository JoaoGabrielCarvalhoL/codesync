[![Build Status](https://github.com/JoaoGabrielCarvalhoL/codesync/actions/workflows/ci.yml/badge.svg)](https://github.com/JoaoGabrielCarvalhoL/codesync/actions/workflows/ci.yml)  
[![Coverage](https://img.shields.io/badge/coverage-83%25-green)](#)
![Status](https://img.shields.io/badge/status-under%20development-orange)

![Java](https://img.shields.io/badge/Java-25-blue.svg)


<h1 align="center">🔄 CodeSync</h1>
<p align="center"><i>Sync Your Code. Elevate Your Engineering.</i></p>

## About CodeSync

CodeSync is a backend platform under development for software project management, task tracking, and engineering workflow automation.

The project aims to centralize project organization, improve development workflow visibility, and support future asynchronous processing and automated analysis capabilities.

CodeSync also serves as a practical environment for studying software architecture, security, persistence, concurrency, messaging, automated testing, and modern Java development.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 25 | Backend development |
| Spring Boot 4.2.0 | Application framework |
| Spring Security | Authentication integration and API security |
| Keycloak | OAuth2/OpenID Connect identity provider |
| PostgreSQL | Relational database |
| Spring Data JPA / Hibernate | Persistence |
| RabbitMQ | Messaging infrastructure |
| Amazon S3 / LocalStack | Object storage and local development |
| Caffeine | Application caching |
| Quartz | Job scheduling infrastructure |
| Thymeleaf | HTML email template rendering |
| MapStruct | Object mapping |
| Springdoc OpenAPI | API documentation |
| JUnit / Testcontainers | Automated testing |
| JaCoCo | Code coverage reporting |
| Docker Compose | Local infrastructure |

## Architecture

CodeSync follows a separation of responsibilities between identity management, API authentication, and business authorization.

### Identity and Authentication

**Keycloak** is responsible for authenticating users and issuing OAuth2 access tokens.

**Spring Security OAuth2 Resource Server** validates incoming JWTs, including their signatures, issuers, expiration, and expected audience.

The application does not depend on Keycloak's Admin REST API for its regular authentication flow.

### Business Authorization

CodeSync owns its business authorization rules.

Permissions involving organizations, projects, tasks, and other application resources are managed by the application rather than by Keycloak realm roles.

Application users are associated with their external identity through the JWT subject (`sub`) claim.

### Architectural Decisions

Architectural decisions are documented in:

`docs/adr/`

## Getting Started

### Prerequisites

Make sure the following tools are installed:

- JDK 25
- Maven
- Docker and Docker Compose
- PostgreSQL for the application database

### 1. Clone the repository

```bash
git clone https://github.com/JoaoGabrielCarvalhoL/codesync.git
cd codesync
```

### 2. Configure the environment

Configure the environment variables required by Docker Compose.

The backend currently uses local configuration values defined in `application.properties`.

Ensure that the PostgreSQL database configured for CodeSync exists and is accessible.

### 3. Start the infrastructure

```bash
docker compose up -d
```

The local infrastructure includes Keycloak, RabbitMQ, LocalStack, and MailDev.

Keycloak imports the development realm from the configured realm JSON file when the realm does not already exist in its database.

### 4. Run the application

```bash
mvn spring-boot:run
```

By default, the backend is available at:

`http://localhost:8080`

## API Documentation

With the application running, access Swagger UI:

`http://localhost:8080/swagger-ui/index.html`

The OpenAPI specification is available at:

`http://localhost:8080/v3/api-docs`

## Security

Protected API endpoints require a valid Bearer access token issued by the configured Keycloak realm.

The resource server validates the expected JWT audience:

`codesync-api`

Example request:

```http
GET /api/v1/ping/protected
Authorization: Bearer <access_token>
```

The Keycloak client `codesync-app` is configured as a public OpenID Connect client using Authorization Code Flow with PKCE.

Business authorization is handled separately from JWT authentication.

## Testing

Run the complete Maven verification lifecycle:

```bash
mvn clean verify
```

The project uses automated tests and supports integration testing with Testcontainers.

## Code Coverage

JaCoCo is configured to generate code coverage reports during the Maven build.

Run:

```bash
mvn clean verify
```

Open the HTML report:

`target/site/jacoco/index.html`

Coverage percentages should be obtained from the generated report rather than from a manually maintained badge.

## Development Roadmap

CodeSync is under active development. Planned and evolving areas include:

- Organization and project management
- User profiles and project membership
- Task and sprint management
- Application-specific authorization
- Asynchronous processing with RabbitMQ
- File and artifact management using object storage
- Automated analysis and reporting
- Job scheduling
- Observability and operational improvements
- Frontend integration

Features listed in this roadmap are not necessarily complete or available for production use.

## Project Status

**Under active development**

The architecture, APIs, and infrastructure may evolve as new requirements are introduced and existing implementations are refined.

## License

This project is licensed under the [MIT License](LICENSE).