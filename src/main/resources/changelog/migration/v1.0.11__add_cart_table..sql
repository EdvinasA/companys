--liquibase formatted sql

--changeset Edvinas:10
CREATE TABLE cart
(
    id            UUID PRIMARY KEY NOT NULL,
    picture       VARCHAR(255)     NOT NULL,
    product_name  VARCHAR(255)     NOT NULL,
    quantity      NUMERIC          NOT NULL,
    price         NUMERIC          NOT NULL,
    insurance     BOOLEAN          NOT NULL,
    warranty      BOOLEAN          NOT NULL,
    purchase_date DATE
);
