--liquibase formatted sql

--changeset Edvinas:2
CREATE TABLE roles(
    id UUID PRIMARY KEY NOT NULL,
    role varchar(255)
);

CREATE TABLE users_roles(
  user_id UUID NOT NULL,
  role_id UUID NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users,
  FOREIGN KEY (role_id) REFERENCES roles
);
