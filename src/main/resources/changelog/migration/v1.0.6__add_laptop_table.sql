--liquibase formatted sql

--changeset Edvinas:5
CREATE TABLE laptop(
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    picture VARCHAR(255),
    product_code VARCHAR(255),
    price DOUBLE PRECISION NOT NULL,
    product_type VARCHAR(255),
    product_creator VARCHAR(255),
    series VARCHAR(255),
    model VARCHAR(255),
    computer_type VARCHAR(255),
    weight VARCHAR(255),
    length VARCHAR(255),
    screen_size VARCHAR(255),
    screen_resolution VARCHAR(255),
    operational_system VARCHAR(255),
    processor_class VARCHAR(255),
    processor_type VARCHAR(255),
    ram_type VARCHAR(255),
    amount_of_ram VARCHAR(255),
    max_amount_of_ram VARCHAR(255),
    data_storage_type VARCHAR(255),
    data_storage_size VARCHAR(255),
    graphics_card_type VARCHAR(255),
    graphics_card_series VARCHAR(255),
    graphics_card_model VARCHAR(255),
    graphics_card_memory_size VARCHAR(255),
    video_camera BOOLEAN NOT NULL,
    integrated_microphone BOOLEAN NOT NULL,
    keyboard_language VARCHAR(255)
)
