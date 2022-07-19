--liquibase formatted sql

--changeset Edvinas:6
CREATE TABLE viewed_item
(
    id           UUID PRIMARY KEY NOT NULL,
    item_id      UUID             NOT NULL,
    item_picture VARCHAR(255)     NOT NULL,
    item_name    VARCHAR(255)     NOT NULL,
    item_price   NUMERIC          NOT NULL,
    delivery     BOOLEAN          NOT NULL,
    withdrawal   BOOLEAN          NOT NULL,
    user_id      UUID             NOT NULL
);
