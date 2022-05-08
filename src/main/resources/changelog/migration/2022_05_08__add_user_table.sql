--liquibase formatted sql

--changeset Edvinas:2
CREATE TABLE users(
  id UUID PRIMARY KEY NOT NULL,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  registered_date DATE
);
