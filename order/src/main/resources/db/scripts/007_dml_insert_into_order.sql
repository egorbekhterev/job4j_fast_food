INSERT INTO orders (name, status, customer_id)
VALUES ('№1', 'PREPARING', 1), ('№2', 'CONFIRMED', 2) ON CONFLICT DO NOTHING;
