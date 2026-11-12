# Restaurant Table Booking

A multi-restaurant table booking platform. Customers choose a table on a restaurant's floor plan, verify their email and manage their booking from the links they receive by email. Restaurant staff manage tables, opening hours and bookings from an admin panel.

> **Project status:** early development. The backend is a Spring Boot skeleton with JPA entities and stub endpoints; the database is being rewritten to match the [target schema](docs/database.md). The documentation describes the **full target design** and marks each item with its status.

| Marker | Meaning |
|---|---|
| ✅ | Implemented |
| 🚧 | In progress / partially implemented |
| 📋 | Planned (designed, not implemented) |

## Features

### For customers
- 📋 Browse a restaurant's floor plan and pick the table (or table combination) they want.
- 📋 Book for a date, time and party size within the restaurant's opening hours.
- 📋 Verify their email with a one-time code to secure the booking.
- 📋 Confirm attendance, cancel or reschedule from the link in their emails.
- 📋 See their past and upcoming bookings across all restaurants, by verifying their email.

### For restaurants
- 📋 Configure opening hours, closures, booking duration and other booking rules.
- 📋 Draw the floor plan: dining areas, tables, seats and combinable tables.
- 📋 View, create (phone and walk-in), cancel and reschedule bookings.
- 📋 Check guests in and mark no-shows.
- 📋 Manage staff accounts with the **Owner** and **Host** roles.
- 📋 Audit log of every change made by staff.

### Platform
- 📋 Email confirmation, reminder and cancellation messages.
- 📋 Automatic cancellation when a booking is not confirmed in time.
- 📋 Rate limiting on public endpoints and JWT authentication for staff.

## Tech stack

| Layer | Technology | Status |
|---|---|---|
| Backend | Java 21, Spring Boot 4 (Web MVC, Data JPA, Validation, Security) | 🚧 |
| Database | PostgreSQL, migrations with Flyway | 🚧 |
| Messaging | Apache Kafka (domain events and email notifications) | 📋 |
| Authentication | Spring Security with JWT | 📋 |
| API docs | OpenAPI via springdoc (`/swagger-ui.html`) | 📋 |
| Frontend | React + TypeScript (customer site and admin panel) | 📋 |
| Email | SMTP provider; Mailpit for local development | 📋 |

The reasons behind the main choices are recorded in [Architecture Decision Records](docs/adr/).

## Repository layout

```
.
├── README.md                 ← you are here
├── docs/
│   ├── business-rules.md     ← requirements, booking rules and lifecycle
│   ├── architecture.md       ← components, flows, security, configuration
│   ├── api.md                ← REST API design
│   ├── database.md           ← target PostgreSQL schema
│   ├── glossary.md           ← domain terms (EN ↔ PT)
│   └── adr/                  ← architecture decision records
└── backend/                  ← Spring Boot application
    ├── build.gradle
    ├── compose.yaml
    └── src/
```

## Getting started (backend)

### Requirements
- JDK 21
- Docker (for PostgreSQL; Kafka and Mailpit once they are added to `compose.yaml`)

### Configuration
The application reads its database connection from environment variables or from a `backend/.env` file (ignored by Git):

```properties
DB_URL=jdbc:postgresql://localhost:5432/restaurant_booking
DB_USER=restaurant_booking
DB_PASSWORD=change-me
```

The full list of planned variables is in [architecture.md → Configuration](docs/architecture.md#configuration).

### Run

```bash
cd backend
./gradlew bootRun
```

```bash
cd backend
./gradlew test
```

> 🚧 The backend does not start cleanly yet: the SQL script and the JPA entities disagree, and the script is not a valid Flyway migration. See [database.md → Current state vs. target](docs/database.md#current-state-vs-target).

## Documentation

| Document | Content |
|---|---|
| [Business rules](docs/business-rules.md) | Actors, functional requirements (FR), business rules (BR), booking lifecycle, non-functional requirements (NFR) |
| [Architecture](docs/architecture.md) | System context, backend modules, main flows, events, security, configuration |
| [API](docs/api.md) | Endpoints, authentication, request/response formats, errors |
| [Database](docs/database.md) | Target schema, constraints, indexes and migration notes |
| [Glossary](docs/glossary.md) | Domain vocabulary and naming conventions |
| [ADRs](docs/adr/) | Architecture decisions and their trade-offs |

Requirement and rule IDs (`FR-xx`, `BR-xx`, `NFR-xx`) are stable: reference them in commits, issues and pull requests.
