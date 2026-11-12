# ADR-0004: Staff authentication with Spring Security and JWT

- **Status:** Accepted
- **Date:** 2026-11-12

## Context
Only staff (Owner, Host, platform admin) log in with a password. The backend may run several instances, and the admin panel is a separate React application. The build declared an OAuth2 authorization server, an OAuth2 client and JDBC sessions, which together are far more than this need requires.

## Decision
- Use Spring Security with **stateless JWT access tokens** (RS256, 15 minutes), validated with the OAuth2 resource-server JWT support.
- Use **opaque refresh tokens** (7 days) stored hashed in the database, sent as an `HttpOnly` cookie and rotated on every use, with reuse detection.
- Hash passwords with Argon2id.
- Do not put roles in the token; check the membership for the requested restaurant on each request (cached briefly), so role changes apply quickly.
- Customer history sessions use the same mechanism with a short-lived token limited to the customer scope.
- Remove `spring-boot-starter-security-oauth2-authorization-server`, `spring-boot-starter-security-oauth2-client` and `spring-boot-starter-session-jdbc`; add `spring-boot-starter-oauth2-resource-server`.

## Consequences
- No server-side session store; any instance can validate requests.
- Access tokens cannot be revoked before they expire (at most 15 minutes); logout and lockout act on refresh tokens.
- Signing keys must be managed as secrets and rotated.

## Alternatives considered
- **Server-side sessions (Spring Session JDBC):** simple revocation, but adds a session table lookup per request and cookie/CSRF handling across origins.
- **Own OAuth2 authorization server:** suited to many client applications and third parties; unnecessary for one admin panel.
- **External identity provider / "Sign in with Google":** possible future addition for staff; not needed for the first release.
