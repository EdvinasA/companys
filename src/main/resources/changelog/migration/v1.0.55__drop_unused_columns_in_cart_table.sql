--liquibase formatted sql

--changeset Edvinas:43
ALTER TABLE cart_items
    DROP COLUMN category,
    DROP COLUMN sub_category,
    DROP COLUMN item_price,
    DROP COLUMN item_code,
    DROP COLUMN picture,
    DROP COLUMN item_name,
    DROP COLUMN item_id;

ALTER TABLE cart_items
    ADD COLUMN product_id UUID;
ALTER TABLE cart_items
    ADD CONSTRAINT fk_ordered_items_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);

