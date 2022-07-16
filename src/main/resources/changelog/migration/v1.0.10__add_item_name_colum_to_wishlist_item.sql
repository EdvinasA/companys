--liquibase formatted sql

--changeset Edvinas:5
ALTER TABLE wishlist_item ADD COLUMN item_name VARCHAR(255) NOT NULL;
