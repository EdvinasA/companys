--liquibase formatted sql

--changeset Edvinas:42
ALTER TABLE ordered_items
    DROP COLUMN category,
    DROP COLUMN sub_category,
    DROP COLUMN item_price,
    DROP COLUMN item_code,
    DROP COLUMN picture,
    DROP COLUMN item_id;
