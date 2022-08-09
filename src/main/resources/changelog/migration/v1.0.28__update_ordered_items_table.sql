--liquibase formatted sql

--changeset Edvinas:23
ALTER TABLE ordered_items ADD FOREIGN KEY (order_id) REFERENCES orders;


