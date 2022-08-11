--liquibase formatted sql

--changeset Edvinas:30
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS roles;

CREATE TABLE role(
    role VARCHAR(255) NOT NULL
)
