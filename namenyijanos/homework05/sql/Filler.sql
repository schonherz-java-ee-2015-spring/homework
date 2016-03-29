-- insert default data into table User
INSERT INTO "User"(name, pwd) VALUES ('John');
INSERT INTO "User"(name, pwd) VALUES ('Mary');

-- insert default data into table Product
INSERT INTO "Product"(name, price) VALUES ('Pizza', 4);
INSERT INTO "Product"(name, price) VALUES ('Burger', 3);
INSERT INTO "Product"(name, price) VALUES ('Coke', 1);

-- insert default data into table Order
INSERT INTO "Order"(user_id, product_id) VALUES (1, 2);
INSERT INTO "Order"(user_id, product_id) VALUES (2, 2);
INSERT INTO "Order"(user_id, product_id) VALUES (2, 1);
INSERT INTO "Order"(user_id, product_id) VALUES (1, 1);
INSERT INTO "Order"(user_id, product_id) VALUES (1, 3);