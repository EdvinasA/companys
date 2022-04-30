--liquibase formatted sql

--changeset Edvinas:1
CREATE TABLE company_data(
  id UUID PRIMARY KEY NOT NULL,
  code VARCHAR(255),
  name VARCHAR(255),
  address VARCHAR(255),
  registered_date DATE,
  company_form VARCHAR(255),
  status_name VARCHAR(255),
  status_since_date DATE,
  formatted_information_date DATE
);
