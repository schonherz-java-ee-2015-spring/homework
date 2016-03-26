-- INSERT TWO USERS
INSERT INTO public."User" (name) VALUES ('Bertalan Adam'), ('Kovacs Janos');

-- INSERT THREE PRODUCTS
INSERT INTO public."Product" (name) VALUES ('Tej'),('Kenyer'),('Szalami');

-- INSERT FIVE ORDERS
INSERT INTO public."Order" (user_id, product_id) VALUES (1,1),(1,2),(1,3),(2,1),(2,3);
