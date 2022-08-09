--liquibase formatted sql

--changeset Edvinas:25
DROP TABLE IF EXISTS ordered_items;
DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id             UUID PRIMARY KEY NOT NULL,
    user_id        UUID             NOT NULL,
    order_number   VARCHAR(255)     NOT NULL,
    order_date     DATE             NOT NULL,
    collect_option VARCHAR(255),
    payment_method VARCHAR(255),
    invoice        bytea,
    total_price    NUMERIC,
    order_update   DATE,
    status         VARCHAR(255)     NOT NULL
);

CREATE TABLE ordered_items
(
    id            SERIAL PRIMARY KEY NOT NULL,
    item_id       UUID               NOT NULL,
    order_id      UUID               NOT NULL,
    picture       VARCHAR(255)       NOT NULL,
    item_name     VARCHAR(255)       NOT NULL,
    item_code     VARCHAR(255)       NOT NULL,
    item_price    NUMERIC            NOT NULL,
    item_quantity NUMERIC            NOT NULL
)
