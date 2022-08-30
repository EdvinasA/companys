--liquibase formatted sql

--changeset Edvinas:37
ALTER TABLE product ADD COLUMN sub_category VARCHAR(255);
