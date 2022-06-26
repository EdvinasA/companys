--liquibase formatted sql

--changeset Edvinas:9
ALTER TABLE users ADD COLUMN last_name VARCHAR(255) NOT NULL;
