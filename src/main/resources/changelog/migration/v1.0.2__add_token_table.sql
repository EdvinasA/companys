--liquibase formatted sql

--changeset Edvinas:1
CREATE TABLE token(
  id UUID PRIMARY KEY NOT NULL,
  token VARCHAR(255),
  email VARCHAR(255),
  date DATE
);
