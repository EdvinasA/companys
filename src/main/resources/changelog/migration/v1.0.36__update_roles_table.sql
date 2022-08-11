--liquibase formatted sql

--changeset Edvinas:31
DROP TABLE IF EXISTS role;

CREATE TABLE role(
    id SERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL
)
