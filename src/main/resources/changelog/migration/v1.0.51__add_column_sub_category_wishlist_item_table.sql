--liquibase formatted sql

--changeset Edvinas:40
ALTER TABLE wishlist_item ADD COLUMN sub_category VARCHAR(255) DEFAULT 'LAPTOPS_AND_THEIR_ACCESSORIES';
