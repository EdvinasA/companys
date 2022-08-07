--liquibase formatted sql

--changeset Edvinas:19
ALTER TABLE cart_items ADD FOREIGN KEY (cart_id) REFERENCES cart;

