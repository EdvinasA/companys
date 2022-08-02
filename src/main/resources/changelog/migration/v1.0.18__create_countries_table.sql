--liquibase formatted sql

--changeset Edvinas:13
CREATE TABLE countries(
  id NUMERIC PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);
