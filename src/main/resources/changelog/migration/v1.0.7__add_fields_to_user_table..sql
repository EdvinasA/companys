--liquibase formatted sql

--changeset Edvinas:2
ALTER TABLE users ADD receive_emails BOOLEAN DEFAULT TRUE;
ALTER TABLE users ADD receive_emails_about_looked_items BOOLEAN DEFAULT TRUE;
ALTER TABLE users ADD receive_emails_about_giving_feedback BOOLEAN DEFAULT TRUE;
ALTER TABLE users ADD receive_emails_about_service_quality BOOLEAN DEFAULT TRUE;
