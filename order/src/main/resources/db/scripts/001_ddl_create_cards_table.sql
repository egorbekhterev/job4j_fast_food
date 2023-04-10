create table IF NOT EXISTS cards
(
    id serial primary key,
    card_number int NOT NULL UNIQUE,
    bonuses int DEFAULT 0
);
