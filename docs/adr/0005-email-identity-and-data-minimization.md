# ADR-0005: Email-based customer identity and data minimization

- **Status:** Accepted
- **Date:** 2026-11-12

## Context
Customers should book without creating an account, yet bookings must be protected from strangers and customers must be able to see their history. The first schema stored CPF and separate phone/email verification flags. Under LGPD, every piece of personal data needs a purpose, and less data means less risk.

## Decision
- A customer is identified only by their **email** (case-insensitive). There are no customer passwords.
- Ownership of the email is proven with a **one-time code** for each online booking and for history access.
- Bookings are managed through a **management link** with a random token, sent only to the verified email.
- All customer notifications (verification, confirmation, reminders, cancellations) are sent **by email**. SMS and WhatsApp are out of scope.
- **CPF is not collected.** Phone is kept as contact data for the restaurant but is not verified.
- Customer personal data is anonymized 24 months after the last booking or on request.

## Consequences
- Booking takes one extra step (entering the code) but needs no account.
- Anyone with access to the customer's inbox can manage their bookings; this matches the trust level of the booking itself.
- Customers who change email appear as a new customer.
- Fewer personal fields to protect, explain in the privacy notice and delete.

## Alternatives considered
- **Customer accounts with passwords:** more friction and more sensitive data for little gain.
- **Phone/SMS verification:** higher cost per message and more provider integration; can be added later as another channel.
- **Keeping CPF:** no business rule needs it.
