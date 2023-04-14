INSERT INTO customers (name, login, password, card_id)
VALUES ('George', 'test', 'test', 1), ('Chris', 'login', 'password', 2) ON CONFLICT DO NOTHING;
