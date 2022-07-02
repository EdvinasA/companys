--liquibase formatted sql

--changeset Edvinas:1
CREATE TABLE roles(
    id UUID PRIMARY KEY NOT NULL,
    user_id UUID NOT NULL,
    role varchar(255)
);
