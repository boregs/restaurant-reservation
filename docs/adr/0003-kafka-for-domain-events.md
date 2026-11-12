# ADR-0003: Kafka for domain events, RabbitMQ dropped

- **Status:** Accepted
- **Date:** 2026-11-12

## Context
Booking changes trigger side effects: emails now, and possibly analytics, integrations or a separate notification service later. Sending emails inside the request transaction would make requests slow and couple booking logic to email delivery. The build declared both Kafka (including Kafka Streams) and RabbitMQ (including RabbitMQ Streams); running two brokers adds operational cost without a clear benefit.

## Decision
- Use **Apache Kafka** as the only message broker. Remove RabbitMQ (`spring-boot-starter-amqp`, `spring-rabbit-stream` and the `rabbitmq` compose service) and Kafka Streams until a concrete stream-processing need appears.
- Publish events through a **transactional outbox**: the change and the event row are committed together; a relay publishes unpublished rows to Kafka.
- Topics: `booking.events.v1` (booking facts, keyed by booking UUID) and `notification.requests.v1` (one-off emails that carry secrets, short retention).
- Consumers are idempotent (processed event IDs are recorded), because delivery is at-least-once.
- Time-based work (holds, reminders, auto-cancel) is done by scheduled jobs in the backend, which then emit events; Kafka is not used as a scheduler.

## Consequences
- Booking requests stay fast; email delivery can retry without affecting them.
- New consumers can be added without touching the booking module.
- Kafka must run in every environment (KRaft single broker locally, managed service in production) and adds monitoring needs (consumer lag).
- Integration tests need a Kafka Testcontainer.

## Alternatives considered
- **RabbitMQ only:** simpler for task queues, but no replayable event log for future consumers.
- **Both brokers:** two systems to operate for one need.
- **No broker (in-process events + outbox polling for email):** the simplest option and enough for the first release; Kafka was chosen to support future consumers without changing the booking code.
