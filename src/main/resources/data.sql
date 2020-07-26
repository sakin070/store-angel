insert into stock_item (sku, name, quantity_per_unit, reorder_level, category) values
(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),(1,'milk',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD'),
(2,'indomine',1, 5, 'FOOD');

INSERT INTO store_user(user_name, first_name, last_name, hashed_password) VALUES
  ( 'admin', 'lala', 'lala', '$2y$12$1BPxHIrg8dao9UliGS7zEenQNZF/v7tYC4rj5tVemKhFWOJhApA.C');
--   ( 'lala', 'lala');

INSERT INTO role (name, store_user_id) VALUES
  ( 'ADMIN',1);

INSERT INTO stock_category (name) VALUES
    ('FOOD'),
    ('DRINKS'),
    ('DRUGS');

INSERT INTO supplier (name,phone,address) VALUES
    ('ABLE JOE', '0801234567', 'LAGOS'),
    ('FAN MILK', '0801234567', 'LAGOS'),
    ('UNILEVER', '0801234567', 'LAGOS');

INSERT INTO invoice (supplier_id, alpha_id, date, total) VALUES
    ('1', 'AAAAA', '2020-07-08', 100);

INSERT INTO invoice_item (stock_item_id, invoice_id,
quantity, cost_price, old_cost_price, selling_price, old_selling_price ,expiry) VALUES
    ('1', '1','5','20', '0','30', '0', '2021-05-20'),
    ('2', '1','5','20', '0','30', '0', '2021-05-20');

INSERT INTO customer (first_name, last_name, age, phone, email, address, loyalty_card_number, points) VALUES
    ('sam', 'eggs', 22, '223 345 4456', 'sam@eggs.yt', 'homeless','mu12345679', 23378),
    ('sam', 'no eggs', 22, '223 345 5556', 'sam@no-eggs.yt', 'homeless','mu12388679', 0);