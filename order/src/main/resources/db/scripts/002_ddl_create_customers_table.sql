create table customers
(
    id serial primary key,
    name text NOT NULL,
    login text NOT NULL,
    password text NOT NULL,
    card_id int REFERENCES cards(id) NOT NULL UNIQUE
);
