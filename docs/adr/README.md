# Architecture Decision Records

Short records of significant decisions: the context, what was decided, and the consequences. A decision is never edited after it is accepted; if it changes, a new ADR supersedes it and the old one is marked `Superseded by ADR-xxxx`.

| ADR | Decision | Status |
|---|---|---|
| [0001](0001-multi-restaurant-tenancy.md) | Several restaurants on one platform, isolated by `restaurant_id` | Accepted |
| [0002](0002-database-enforced-overlap-prevention.md) | Prevent double booking with a PostgreSQL exclusion constraint | Accepted |
| [0003](0003-kafka-for-domain-events.md) | Kafka for domain events with a transactional outbox; drop RabbitMQ | Accepted |
| [0004](0004-jwt-authentication.md) | Spring Security with JWT for staff; no OAuth2 authorization server | Accepted |
| [0005](0005-email-identity-and-data-minimization.md) | Customers identified by email only; no CPF | Accepted |

## Template

```markdown
# ADR-NNNN: Title

- **Status:** Proposed | Accepted | Superseded by ADR-xxxx
- **Date:** YYYY-MM-DD

## Context
What problem or force makes a decision necessary.

## Decision
What we will do.

## Consequences
What becomes easier, what becomes harder, and what follow-up work is needed.

## Alternatives considered
Other options and why they were not chosen.
```
