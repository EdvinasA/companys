--liquibase formatted sql

--changeset Edvinas:18
ALTER TABLE cart ADD COLUMN status VARCHAR(50) NOT NULL;

