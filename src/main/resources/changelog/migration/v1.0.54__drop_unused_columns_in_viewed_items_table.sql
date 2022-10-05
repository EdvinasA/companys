--liquibase formatted sql

--changeset Edvinas:43
ALTER TABLE viewed_item
    DROP COLUMN category,
    DROP COLUMN sub_category,
    DROP COLUMN item_price,
    DROP COLUMN item_code,
    DROP COLUMN item_picture,
    DROP COLUMN withdrawal,
    DROP COLUMN delivery,
    DROP COLUMN item_name,
    DROP COLUMN item_id;

ALTER TABLE viewed_item
    ADD COLUMN product_id UUID;
ALTER TABLE viewed_item
    ADD CONSTRAINT fk_ordered_items_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);

