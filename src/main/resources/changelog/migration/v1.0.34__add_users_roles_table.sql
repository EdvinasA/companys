--liquibase formatted sql

--changeset Edvinas:29
DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles(
    user_id UUID,
    role_id UUID
);
