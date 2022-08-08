--liquibase formatted sql

--changeset Edvinas:22
ALTER TABLE cart_items ADD FOREIGN KEY (cart_id) REFERENCES cart;


