--liquibase formatted sql

--changeset Edvinas:11
ALTER TABLE users DROP COLUMN receive_emails;
ALTER TABLE users DROP COLUMN receive_emails_about_giving_feedback;
ALTER TABLE users DROP COLUMN receive_emails_about_looked_items;
ALTER TABLE users DROP COLUMN receive_emails_about_service_quality;

CREATE TABLE subscription_details(
  id                                        SERIAL PRIMARY KEY NOT NULL,
  user_id                                   UUID               NOT NULL,
  receive_emails                            BOOLEAN            NOT NULL,
  receive_emails_date                       DATE               NOT NULL,
  receive_emails_about_looked_items         BOOLEAN            NOT NULL,
  receive_emails_about_looked_items_date    DATE               NOT NULL,
  receive_emails_about_giving_feedback      BOOLEAN            NOT NULL,
  receive_emails_about_giving_feedback_date DATE               NOT NULL,
  receive_emails_about_service_quality      BOOLEAN            NOT NULL,
  receive_emails_about_service_quality_date DATE               NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users
)
