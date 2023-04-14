create table IF NOT EXISTS orders
(
    id serial primary key NOT NULL,
    name text NOT NULL,
    status text NOT NULL
);
