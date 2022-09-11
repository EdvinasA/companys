--liquibase formatted sql

--changeset Edvinas:39
ALTER TABLE viewed_item ADD COLUMN category VARCHAR(255) DEFAULT 'COMPUTER_EQUIPMENT_OFFICE_SUPPLIES';
