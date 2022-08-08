--liquibase formatted sql

--changeset Edvinas:21
ALTER TABLE cart_items DROP COLUMN cart_id;
ALTER TABLE cart_items ADD COLUMN cart_id UUID;


