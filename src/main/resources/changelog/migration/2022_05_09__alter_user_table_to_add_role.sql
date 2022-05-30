--liquibase formatted sql

--changeset Edvinas:4
ALTER TABLE users ADD COLUMN roles VARCHAR(255) DEFAULT 'USER';
