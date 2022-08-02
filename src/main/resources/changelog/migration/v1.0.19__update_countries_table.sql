--liquibase formatted sql

--changeset Edvinas:14
DROP TABLE IF EXISTS countries;

CREATE TABLE countries(
                          id SERIAL PRIMARY KEY NOT NULL,
                          name VARCHAR(255) NOT NULL
);
