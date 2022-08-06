--liquibase formatted sql

--changeset Edvinas:16
ALTER TABLE ordered_items ADD COLUMN user_id UUID NOT NULL;
