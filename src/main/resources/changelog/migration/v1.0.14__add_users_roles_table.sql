--liquibase formatted sql

--changeset Edvinas:9
DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles(
    user_id UUID,
    role_id UUID,
    FOREIGN KEY (user_id) REFERENCES users,
    FOREIGN KEY (role_id) REFERENCES roles
);
