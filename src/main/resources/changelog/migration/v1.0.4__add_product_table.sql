--liquibase formatted sql

--changeset Edvinas:3
CREATE TABLE product(
  id UUID PRIMARY KEY NOT NULL,
  picture VARCHAR(255),
  name VARCHAR(255),
  quantity NUMERIC NOT NULL,
  description TEXT,
  small_description TEXT,
  customer_evaluation NUMERIC,
  has_discount BOOLEAN
);
