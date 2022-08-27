--liquibase formatted sql

--changeset Edvinas:36
DROP TABLE IF EXISTS laptop;

CREATE TABLE product
(
    id                  UUID PRIMARY KEY NOT NULL,
    name                VARCHAR(255),
    picture             VARCHAR(255),
    code                VARCHAR(255),
    price               DOUBLE PRECISION NOT NULL,
    quantity            NUMERIC          NOT NULL,
    customer_evaluation NUMERIC,
    type                VARCHAR(255),
    category            VARCHAR(255),
    stripe_product_id   VARCHAR(255)
)
