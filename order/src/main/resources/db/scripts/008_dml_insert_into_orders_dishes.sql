INSERT INTO orders_dishes (order_id, dish_id)
VALUES (1, 1), (1, 2), (2, 3) ON CONFLICT DO NOTHING;
