--liquibase formatted sql

--changeset Edvinas:38
ALTER TABLE product ADD COLUMN stripe_price_id VARCHAR(255);
