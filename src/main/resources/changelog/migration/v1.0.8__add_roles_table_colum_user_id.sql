--liquibase formatted sql

--changeset Edvinas:7
ALTER TABLE roles ADD COLUMN user_id UUID NOT NULL;
ALTER TABLE roles ADD FOREIGN KEY (user_id) REFERENCES users;
