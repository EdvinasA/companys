--liquibase formatted sql

--changeset Edvinas:10
ALTER TABLE roles DROP COLUMN user_id;
