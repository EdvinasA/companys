--liquibase formatted sql

--changeset Edvinas:7
ALTER TABLE viewed_item ADD COLUMN item_code VARCHAR(255) NOT NULL DEFAULT '123456';
