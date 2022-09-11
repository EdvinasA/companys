--liquibase formatted sql

--changeset Edvinas:39
ALTER TABLE ordered_items ADD COLUMN category VARCHAR(255) DEFAULT 'COMPUTER_EQUIPMENT_OFFICE_SUPPLIES';
