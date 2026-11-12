# ADR-0001: Multi-restaurant tenancy

- **Status:** Accepted
- **Date:** 2026-11-12

## Context
The first version of the schema assumed a single restaurant. The platform must serve several restaurants, each with its own tables, opening hours, rules, staff and bookings. Customers may book at more than one restaurant.

## Decision
- One database and one application serve all restaurants (shared schema).
- Every restaurant-owned table has a `restaurant_id`. Child rows reference parents with composite foreign keys that include `restaurant_id`, so cross-restaurant references are rejected by the database.
- Staff users are global; their access is given per restaurant through `restaurant_memberships` with the role `OWNER` or `HOST`. A platform admin creates restaurants.
- Customers are global (identified by email) and see their bookings across restaurants.
- Admin API routes include the restaurant: `/admin/restaurants/{restaurantId}/…`. Public routes use the restaurant `slug`.

## Consequences
- Every query on restaurant-owned data must filter by restaurant; this is covered by tenant-isolation tests (NFR-08).
- Settings, opening hours and time zone are per restaurant, so availability is always calculated in the restaurant's context.
- Adding a restaurant is a data operation, not a deployment.
- A noisy restaurant shares resources with the others; acceptable at the expected scale.

## Alternatives considered
- **Database or schema per restaurant:** stronger isolation, but migrations, connections and cross-restaurant customer history become much harder. Not justified at this scale.
- **PostgreSQL row-level security:** could be added later as a second line of defence; not needed initially given composite foreign keys and tests.
