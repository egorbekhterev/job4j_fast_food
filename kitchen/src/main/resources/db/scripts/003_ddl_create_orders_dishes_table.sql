create table iF NOT EXISTS orders_dishes
(
    id serial primary key,
    order_id int REFERENCES orders(id) NOT NULL,
    dish_id int REFERENCES dishes(id) NOT NULL
);
