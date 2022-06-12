--liquibase formatted sql

--changeset Edvinas:4
ALTER TABLE product ADD COLUMN price DOUBLE PRECISION NOT NULL DEFAULT 1;
