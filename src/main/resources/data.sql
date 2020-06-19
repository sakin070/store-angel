insert into stock_item (sku, name, quantity_per_unit, reorder_level) values
(1,'milk',1, 5),
(2,'indomine',1, 5);

INSERT INTO user (user_name, first_name, last_name, hashed_password) VALUES
  ( 'admin', 'lala', 'lala', '$2y$12$1BPxHIrg8dao9UliGS7zEenQNZF/v7tYC4rj5tVemKhFWOJhApA.C');
--   ( 'lala', 'lala');

INSERT INTO role (name, user_id) VALUES
  ( 'ADMIN',1);