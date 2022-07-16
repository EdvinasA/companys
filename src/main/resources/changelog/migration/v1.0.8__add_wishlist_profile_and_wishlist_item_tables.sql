--liquibase formatted sql

--changeset Edvinas:3
CREATE TABLE wishlist_profile
(
    id            UUID PRIMARY KEY NOT NULL,
    name          VARCHAR(255) NOT NULL,
    user_id       UUID NOT NULL
);

CREATE TABLE wishlist_item
(
    id                               UUID PRIMARY KEY NOT NULL,
    item_picture                     VARCHAR(255) NOT NULL,
    item_price                       NUMERIC NOT NULL,
    wishlist_profile_id              UUID NOT NULL,
    FOREIGN KEY(wishlist_profile_id) REFERENCES wishlist_profile
);
