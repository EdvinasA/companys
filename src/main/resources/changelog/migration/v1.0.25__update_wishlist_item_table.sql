--liquibase formatted sql

--changeset Edvinas:20
ALTER TABLE wishlist_item ADD COLUMN item_code VARCHAR(255);

