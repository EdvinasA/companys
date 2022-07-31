--liquibase formatted sql

--changeset Edvinas:12
ALTER TABLE laptop ADD COLUMN stripe_product_id VARCHAR(255) DEFAULT NULL;
