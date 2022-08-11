--liquibase formatted sql

--changeset Edvinas:32
ALTER TABLE users ADD COLUMN roles VARCHAR(500);
