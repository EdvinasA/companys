--liquibase formatted sql

--changeset Edvinas:27
DROP TABLE IF EXISTS ordered_items;

CREATE TABLE ordered_items
(
    id             SERIAL PRIMARY KEY NOT NULL,
    item_id        UUID               NOT NULL,
    order_id       UUID,
    picture        VARCHAR(255)       NOT NULL,
    item_name      VARCHAR(255)       NOT NULL,
    item_code      VARCHAR(255)       NOT NULL,
    item_price     NUMERIC            NOT NULL,
    item_quantity  NUMERIC            NOT NULL,
    item_insurance BOOLEAN            NOT NULL,
    item_warranty  BOOLEAN            NOT NULL
)
