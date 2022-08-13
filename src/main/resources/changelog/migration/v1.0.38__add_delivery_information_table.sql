--liquibase formatted sql

--changeset Edvinas:33
CREATE TABLE delivery_information
(
    id               SERIAL PRIMARY KEY NOT NULL,
    user_id          UUID,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    phone_number     VARCHAR(255),
    address          VARCHAR(255),
    city             VARCHAR(255),
    postal_code      VARCHAR(255),
    company_code     VARCHAR(255),
    company_name     VARCHAR(255),
    company_pvm_code VARCHAR(255),
    company_address  VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users
)
