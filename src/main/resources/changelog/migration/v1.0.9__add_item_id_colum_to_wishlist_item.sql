--liquibase formatted sql

--changeset Edvinas:4
ALTER TABLE wishlist_item ADD COLUMN item_id UUID NOT NULL;
