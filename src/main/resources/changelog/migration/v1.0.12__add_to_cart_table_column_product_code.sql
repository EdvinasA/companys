--liquibase formatted sql

--changeset Edvinas:11
ALTER TABLE cart ADD COLUMN product_code VARCHAR(255) NOT NULL;
