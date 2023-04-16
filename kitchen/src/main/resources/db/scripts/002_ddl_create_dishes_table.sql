create table IF NOT EXISTS dishes
(
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price int NOT NULL,
    category TEXT NOT NULL
);
