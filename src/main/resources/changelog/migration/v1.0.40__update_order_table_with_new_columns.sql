--liquibase formatted sql

--changeset Edvinas:35
ALTER TABLE orders ADD COLUMN applied_discount_amount NUMERIC;
ALTER TABLE orders ADD COLUMN delivery_price NUMERIC;
ALTER TABLE orders ADD COLUMN wanted_delivery_time VARCHAR(255);
ALTER TABLE orders ADD COLUMN withdrawal_location VARCHAR(255);
ALTER TABLE orders ADD COLUMN delivery_address VARCHAR(255);
