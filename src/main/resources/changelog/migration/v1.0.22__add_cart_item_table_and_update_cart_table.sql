--liquibase formatted sql

--changeset Edvinas:17
ALTER TABLE cart DROP COLUMN picture;
ALTER TABLE cart DROP COLUMN product_name;
ALTER TABLE cart DROP COLUMN product_code;
ALTER TABLE cart DROP COLUMN quantity;
ALTER TABLE cart DROP COLUMN price;
ALTER TABLE cart DROP COLUMN insurance;
ALTER TABLE cart DROP COLUMN warranty;

CREATE TABLE cart_items(
  id SERIAL PRIMARY KEY NOT NULL,
  item_id UUID NOT NULL,
  cart_id UUID NOT NULL,
  picture VARCHAR(255) NOT NULL,
  item_name VARCHAR(255) NOT NULL,
  item_code VARCHAR(255) NOT NULL,
  item_price NUMERIC NOT NULL,
  item_quantity NUMERIC NOT NULL,
  item_insurance BOOLEAN NOT NULL,
  item_warranty BOOLEAN NOT NULL
);

ALTER TABLE ordered_items ADD COLUMN item_insurance BOOLEAN DEFAULT false;
ALTER TABLE ordered_items ADD COLUMN item_warranty BOOLEAN DEFAULT false;
