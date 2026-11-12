# ADR-0002: Prevent double booking in the database

- **Status:** Accepted
- **Date:** 2026-11-12

## Context
The most important rule of the system is that a table cannot be booked twice for overlapping periods (BR-02). A check in Java ("is the table free?" followed by an insert) has a race condition: two concurrent requests can both see the table as free and both insert.

## Decision
- Store the blocked period of each booked table as a `TSTZRANGE` in `booking_tables` (`[starts_at, blocked_until)`).
- Add an exclusion constraint `EXCLUDE USING gist (table_id WITH =, period WITH &&) WHERE (blocks_table)` (requires `btree_gist`).
- Keep `period` and `blocks_table` in sync with `bookings` through a database trigger.
- The application still checks availability first, to give friendly errors, and maps a constraint violation (`23P01`) to `409 TABLE_NOT_AVAILABLE`.

## Consequences
- Double booking is impossible regardless of the number of backend instances or application bugs (NFR-04).
- The schema depends on PostgreSQL-specific features (range types, GiST, exclusion constraints).
- The trigger is logic outside Java; it is small and covered by persistence tests.

## Alternatives considered
- **Pessimistic locks (`SELECT … FOR UPDATE`) on table rows:** works, but every code path that books must remember to lock, and lock ordering for combinations is error-prone.
- **Fixed slot rows with a unique constraint:** simple, but breaks when duration, slot interval or buffer differ per restaurant or change over time.
- **Serializable isolation:** correct but causes frequent retries under load and still needs the overlap query everywhere.
