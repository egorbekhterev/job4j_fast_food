INSERT INTO dishes (name, price, category)
VALUES ('Pepperoni Pizza', 12, 'PIZZA'), ('Cheeseburger', 10, 'BURGERS'), ('Taco Plate', 8, 'TACOS') ON CONFLICT DO NOTHING;
