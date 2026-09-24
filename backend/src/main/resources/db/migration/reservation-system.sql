-- Database: reservation-system

DROP DATABASE IF EXISTS "reservation-system";

CREATE DATABASE "reservation-system"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- conecte-se ao banco recem-criado antes de rodar o restante do script
\c "reservation-system"

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE restaurant_tables (
    table_id       SERIAL PRIMARY KEY,
    table_uuid     UUID NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    table_capacity INTEGER NOT NULL DEFAULT 1,
    table_location VARCHAR(20) NOT NULL DEFAULT 'INTERIOR'
		CHECK(table_location IN ('INTERIOR', 'EXTERIOR')),
    table_status   VARCHAR(20) NOT NULL DEFAULT 'AVAILABLE'
		CHECK (table_status IN ('AVAILABLE', 'NOT-AVAILABLE'))
);

CREATE TABLE customers (
    customer_id        BIGSERIAL PRIMARY KEY,
    first_name          VARCHAR(100) NOT NULL,
    last_name           VARCHAR(100) NOT NULL,
    email               VARCHAR(255) NOT NULL UNIQUE,
    phone               VARCHAR(20)  NOT NULL,
    cpf                 VARCHAR(11)  UNIQUE,
    uuid                UUID         NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    is_phone_verified   BOOLEAN      NOT NULL DEFAULT FALSE,
    is_email_verified   BOOLEAN      NOT NULL DEFAULT FALSE,
    created_at          TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE users (
    user_id      BIGSERIAL PRIMARY KEY,
    first_name   VARCHAR(100) NOT NULL,
    last_name    VARCHAR(100) NOT NULL,
    email        VARCHAR(255) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    uuid         UUID         NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    created_at   TIMESTAMPTZ  NOT NULL DEFAULT now(),
    updated_at   TIMESTAMPTZ  NOT NULL DEFAULT now(),
    active       BOOLEAN      NOT NULL DEFAULT TRUE
);

CREATE TABLE bookings (
    booking_id       BIGSERIAL PRIMARY KEY,
    customer_id      BIGINT NOT NULL REFERENCES customers(customer_id),
    booking_uuid     UUID NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    people_count     INTEGER NOT NULL,
    booking_datetime TIMESTAMPTZ NOT NULL,
    created_at       TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at       TIMESTAMPTZ NOT NULL DEFAULT now(),
    confirmed        BOOLEAN NOT NULL DEFAULT FALSE,
    status           VARCHAR(20) NOT NULL DEFAULT 'ACTIVE'
        CHECK (status IN ('ACTIVE', 'CANCELLED', 'RESCHEDULED'))
);

CREATE TABLE booking_tables_customers (
    fk_booking_id  BIGINT NOT NULL REFERENCES bookings(booking_id),
    fk_table_id    INTEGER NOT NULL REFERENCES restaurant_tables(table_id),
    fk_customer_id BIGINT NOT NULL REFERENCES customers(customer_id),
    PRIMARY KEY (fk_booking_id, fk_table_id)
);
