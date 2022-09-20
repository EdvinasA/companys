--liquibase formatted sql

--changeset Edvinas:41
ALTER TABLE ordered_items ADD COLUMN product_id UUID;
ALTER TABLE ordered_items ADD CONSTRAINT fk_ordered_items_product_id FOREIGN KEY(product_id) REFERENCES product(id);
