[![Build Status](https://github.com/JoaoGabrielCarvalhoL/codesync/actions/workflows/ci-main.yml/badge.svg)](https://github.com/JoaoGabrielCarvalhoL/codesync/actions/workflows/ci-main.yml)  
[![Coverage](https://img.shields.io/badge/coverage-0%25-red)](#)
![Status](https://img.shields.io/badge/status-under%20development-orange)

![Java](https://img.shields.io/badge/Java-25-blue.svg)


<h1 align="center">🔄 CodeSync</h1>
<p align="center"><i>Sync Your Code. Elevate Your Engineering.</i></p>

# About CodeSync

CodeSync is a platform designed to centralize and automate software project management, task control, and continuous analysis throughout the development lifecycle. Built to ensure high productivity, synchronization, and compliance, the platform provides engineering teams with visibility into code integrity and development workflow.

By integrating project organization with asynchronous analysis pipelines, CodeSync ensures that changes are processed, verified, and monitored instantly.


### Tech Stack

The core engine is structured with a robust enterprise architecture:

- **Java 25** (LTS) 
- **Spring Boot 4.1.0**
- **RabbitMQ** for asynchronous event-driven core communication
- **Keycloak** for OAuth2/OIDC identity management and token caching via Caffeine
- **Amazon S3** for secure asset and report storage


---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Setup

1. Clone the repository
2. Build the project with Maven
3. Start images of container: `docker compose up`
4. Run application: `mvn spring-boot:run`

---

## Generate JaCoCo Report

1. Run tests and generate coverage report: `mvn clean verify`
2. Open the report in:: `target/jacoco-report/index.html`

---