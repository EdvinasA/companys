--liquibase formatted sql

--changeset Edvinas:24
ALTER TABLE ordered_items DROP COLUMN user_id;


