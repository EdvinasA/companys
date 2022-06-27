--liquibase formatted sql

--changeset Edvinas:12
ALTER TABLE cart ADD COLUMN user_id UUID NOT NULL;
