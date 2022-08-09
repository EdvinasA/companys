--liquibase formatted sql

--changeset Edvinas:26
ALTER TABLE ordered_items ADD COLUMN item_insurance BOOLEAN DEFAULT FALSE;
ALTER TABLE ordered_items ADD COLUMN item_warranty BOOLEAN DEFAULT FALSE;
