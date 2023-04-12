create table IF NOT EXISTS ingredients
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    dish_id int REFERENCES dishes(id) NOT NULL
);
