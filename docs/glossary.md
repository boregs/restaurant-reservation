# Glossary

Domain vocabulary used across the code, the API and the documentation.

## Naming conventions

- **Code, API, database:** English. The central concept is always **booking** (`BookingModel`, `/bookings`, table `bookings`). Avoid mixing in "reservation".
- **User-facing text (UI, emails):** Brazilian Portuguese. "Booking" is shown as **reserva**.
- **Database:** `snake_case`, plural table names (`bookings`, `restaurant_tables`).
- **Java:** `PascalCase` classes, `camelCase` fields; enums in `UPPER_SNAKE_CASE` matching the database values exactly.
- **API JSON:** `camelCase` properties.
- **Public identifiers:** the API exposes only UUIDs. Numeric primary keys stay internal.

## Terms

| Term | Portuguese (UI) | Definition |
|---|---|---|
| Restaurant | Restaurante | A tenant of the platform. Every table, booking, setting and staff membership belongs to one restaurant. Identified publicly by a `slug` (e.g. `cantina-da-praca`). |
| Restaurant settings | Configurações | Per-restaurant, Owner-adjustable booking rules: booking duration, slot interval, lead time, etc. See [business-rules.md → Restaurant settings](business-rules.md#restaurant-settings). |
| Opening hours | Horário de funcionamento | Weekly time ranges in which bookings may take place. A day may have several ranges (e.g. lunch and dinner). |
| Closure | Fechamento | A period (full day or part of a day) in which the restaurant takes no bookings, e.g. a holiday. |
| Dining area | Ambiente | A named part of the restaurant (e.g. "Salão", "Varanda"), indoor or outdoor. Groups tables on the floor plan. |
| Table | Mesa | A physical table with a label (e.g. `T12`), a number of seats and a position on the floor plan. |
| Table combination | Combinação de mesas | A set of tables the Owner allows to be joined for a larger party, with its own seat count. Booked as one unit. |
| Floor plan / seat map | Mapa de mesas | The visual layout of areas and tables from which the customer picks a table. |
| Booking | Reserva | A customer's claim on one table or one table combination, for a party size, from a start time for the booking duration. |
| Party size | Número de pessoas | How many people the booking is for. |
| Slot | Horário | A start time offered to customers. Slots are spaced by the restaurant's slot interval (default 30 min). |
| Booking duration | Duração da reserva | How long a booking occupies its tables (default 120 min). |
| Turnover buffer | Intervalo de limpeza | Time after a booking during which its tables stay blocked for cleaning/resetting (default 15 min). |
| Lead time | Antecedência mínima | Minimum time between booking creation and the booking start (default 24 h). |
| Hold | Bloqueio temporário | The temporary block on a table while a new booking waits for email verification (default 15 min). |
| Verification code | Código de verificação | A 6-digit one-time code sent by email to prove the customer controls the address. |
| Management link | Link de gerenciamento | The private link in booking emails that lets the customer view, confirm, cancel or reschedule without logging in. Backed by a booking access token. |
| Reminder | Lembrete | The email asking the customer to confirm attendance, sent before the booking. |
| Confirmation deadline | Prazo de confirmação | The latest moment a booking can be confirmed. Unconfirmed bookings are auto-cancelled at that moment. |
| Check-in | Check-in | Staff action recording that the party arrived. |
| No-show | Não comparecimento | Staff action recording that the party did not arrive. |
| Source | Origem | How a booking was created: `ONLINE` (customer), `PHONE` or `WALK_IN` (staff). |
| Customer | Cliente | A person who books. Identified by email; has no password. |
| Staff user | Usuário da equipe | A person who logs into the admin panel. Can belong to several restaurants. |
| Owner | Proprietário | Staff role: full control of a restaurant (settings, floor plan, staff, bookings). |
| Host | Recepcionista | Staff role: manages bookings day to day (view, create, cancel, reschedule, check-in, no-show). |
| Platform admin | Administrador da plataforma | Operator of the platform who onboards restaurants and their first Owner. |
| Domain event | Evento de domínio | A fact about a booking (e.g. `BookingCancelled`) published to Kafka. |
| Outbox | Outbox | A database table where events are written in the same transaction as the change, then published to Kafka. |
