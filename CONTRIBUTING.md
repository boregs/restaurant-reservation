# Contributing Guide – Restaurant Table Booking

> **Document version:** 1.0 <br>
> **Created:** 2026-11-13 <br>
> **Last updated:** 2026-11-13

This guide defines how the team works in the repository: how to write commit messages, how to name branches and how to open Pull Requests (PRs). The goal is to keep the history readable and code review fast.

**Language:** all commit messages, branch names, PR titles and PR descriptions are written in **English**.

---

## 1. Commit messages

We use the **Conventional Commits** standard.

### 1.1 Format

```
type(scope): short description
```

- **type:** required. Says what kind of change it is.
- **scope:** optional, in parentheses. Indicates the part of the system affected.
- **short description:** required. Summarizes the change in one line.

### 1.2 Types (prefixes) and when to use them

| Type | Meaning | When to use | Example |
|---|---|---|---|
| `feat` | New feature | When you add something new that the user or another module can now use. | `feat(booking): adds booking cancellation by the customer` |
| `fix` | Bug fix | When something worked incorrectly and you fix it. | `fix(availability): fixes slots offered outside opening hours` |
| `docs` | Documentation | Changes only to documents (README, `docs/`, documentation comments). No code changes. | `docs: adds business rules` |
| `style` | Formatting | Changes that do not alter behavior: whitespace, indentation, semicolons, import order. | `style(floorplan): fixes indentation of the table service` |
| `refactor` | Refactoring | Reorganizes code without changing what it does, without fixing a bug or adding a feature. | `refactor(booking): extracts state transitions into a state machine` |
| `perf` | Performance | A change made specifically to make something faster or use fewer resources. | `perf(availability): loads blocked periods in a single query` |
| `test` | Tests | Adds or adjusts tests, without changing production code. | `test(booking): adds tests for concurrent bookings of the same table` |
| `build` | Build and dependencies | Changes to the build process or dependencies (Gradle, packaging configuration). | `build: removes RabbitMQ dependencies` |
| `ci` | Continuous integration | Changes to pipelines and automations (GitHub Actions, for example). | `ci: runs tests on pull requests` |
| `chore` | General tasks | Maintenance that fits no other type and does not affect production code (configuration tweaks, `.gitignore`). | `chore: adds .gitignore for IDE files` |
| `revert` | Revert | Undoes a previous commit. Cite the reverted commit in the body. | `revert: reverts "feat(booking): adds booking cancellation by the customer"` |

**How to choose the type:** ask yourself "what does the commit do?".
- Adds something new for the user? → `feat`
- Fixes something broken? → `fix`
- Only touches text/documents? → `docs`
- Only reorganizes code, without changing behavior? → `refactor`
- Not sure? It is probably `chore`, but check whether another type fits.

### 1.3 Scope

The scope is optional, but it helps locate the change. Suggested scopes for this project, matching the [backend modules](docs/architecture.md#backend-modules):

| Scope | Area |
|---|---|
| `restaurant` | Restaurants, settings, opening hours and closures |
| `floorplan` | Dining areas, tables and table combinations |
| `availability` | Slot and table availability calculation |
| `booking` | Booking lifecycle and operations |
| `customer` | Customer records and booking history |
| `verification` | Email codes and management links |
| `notification` | Emails and Kafka consumers |
| `auth` | Staff login, JWT, roles and invitations |
| `audit` | Booking history and audit log |
| `db` | Migrations and database schema |
| `api` | Cross-cutting API concerns (errors, conventions, OpenAPI) |
| `ui` | Frontend and visual components |
| `docs` | Documentation (use together with `docs` only if you need more detail) |

The team may add new scopes as the project grows. If the change affects several areas, omit the scope.

### 1.4 Rules for the description

- Write in **English**, in lowercase (except proper nouns and acronyms).
- Use the **verb in the third person present tense**, as if completing the sentence "this commit...": `adds`, `fixes`, `removes`, `updates`.
- **No final period.**
- Be specific: say **what** changed, not what you did ("adjustments" says nothing).

| Bad | Good |
|---|---|
| `fix: adjustments` | `fix(availability): fixes slots offered outside opening hours` |
| `feat: Added the booking screen.` | `feat(ui): adds booking form screen` |
| `update` | `chore: updates project dependencies` |
| `feat(booking): several changes to bookings and tables and emails` | Split into separate commits |

### 1.5 Body and footer

Use the **body** when the reason for the change is not obvious. Separate it from the title with a blank line and explain the *why*, not the *how* (the code already shows the how).

Use the **footer** to reference the project documentation (requirement and rule IDs from [business-rules.md](docs/business-rules.md)):

```
fix(booking): prevents booking the same table twice at the same time

Two simultaneous requests could both see the table as free and both
create a booking. The overlap is now rejected by a database constraint.

Refs: FR-04, BR-02
```

For changes that break compatibility (for example, changing the API), add `!` after the type and explain in the footer:

```
feat(api)!: renames "people" field to "partySize" in booking responses

BREAKING CHANGE: clients that use the "people" field need to update.
```

### 1.6 Good practices

- **One commit, one change.** If the description needs an "and", it is probably two commits.
- Make **small, frequent** commits that leave the project working.
- Do not push broken code to `main`.
- Never include passwords, API keys or personal data in the repository.

---

## 2. Branches

A simple flow, suited to a small team: one main branch and short-lived branches for each task.

| Branch | Use |
|---|---|
| `main` | Stable code. Only receives changes through an approved PR. **No direct commits.** |
| `type/short-name` | Working branch, created from `main`, one per task. |

### 2.1 Branch names

Format: `type/short-description-in-kebab-case`, using the same types as commits.

```
feat/customer-booking-cancellation
fix/slots-outside-opening-hours
refactor/booking-state-machine
```

- Use lowercase letters, no accents, separated by hyphens.
- The name should say what the branch does, briefly.
- If there is an issue, you can include its number: `feat/12-customer-booking-cancellation`.

### 2.2 Workflow

1. Update `main`:

   ```bash
   git checkout main && git pull
   ```

2. Create your branch:

   ```bash
   git checkout -b feat/customer-booking-cancellation
   ```

3. Make commits following the standard in section 1.
4. Push the branch:

   ```bash
   git push -u origin feat/customer-booking-cancellation
   ```

5. Open a Pull Request to `main`.

---

## 3. Pull Requests

### 3.1 Rules

- The **title** follows the same standard as commits: `type(scope): description`.
- Each PR covers **one subject**. Very large PRs are hard to review.
- At least **1 approval** from another team member is required before merging.
- Whoever opened the PR **does not approve their own PR**.
- Resolve all review comments before merging.
- Prefer **Squash and merge** to keep `main` clean, with one commit per PR. The PR title becomes the commit message, so it must follow the standard.
- Reference the requirements and rules from the documentation (FR, BR, NFR) that the PR implements.

## Version history

| Version | Date | Description |
|---|---|---|
| 1.0 | 2026-11-13 | Initial version, adapted to this project and written in English |
