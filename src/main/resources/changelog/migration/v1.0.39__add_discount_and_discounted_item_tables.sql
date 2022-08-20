--liquibase formatted sql

--changeset Edvinas:34
CREATE TABLE discount
(
    id            UUID PRIMARY KEY NOT NULL,
    code          VARCHAR(255),
    percent       NUMERIC,
    valid_until   DATE,
    for_all_items boolean
);

CREATE TABLE discounted_item
(
    id          SERIAL PRIMARY KEY NOT NULL,
    item_id     UUID,
    discount_id UUID
);
