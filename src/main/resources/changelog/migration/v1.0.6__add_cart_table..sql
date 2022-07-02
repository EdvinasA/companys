--liquibase formatted sql

--changeset Edvinas:1
CREATE TABLE cart
(
    id            UUID PRIMARY KEY NOT NULL,
    picture       VARCHAR(255)     NOT NULL,
    product_name  VARCHAR(255)     NOT NULL,
    product_code  VARCHAR(255)     NOT NULL,
    quantity      NUMERIC          NOT NULL,
    price         NUMERIC          NOT NULL,
    insurance     BOOLEAN          NOT NULL,
    warranty      BOOLEAN          NOT NULL,
    user_id       UUID             NOT NULL,
    purchase_date DATE
);
