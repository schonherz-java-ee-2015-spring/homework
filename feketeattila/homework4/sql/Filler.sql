--Inserting 3 users into User table
INSERT INTO public."User" (name) VALUES ('User1');
INSERT INTO public."User" (name) VALUES ('User2');
--Inserting 2 products into Product table
INSERT INTO public."Product" (name, price) VALUES ('Product1', 500);
INSERT INTO public."Product" (name, price) VALUES ('Product2', 1000);
INSERT INTO public."Product" (name, price) VALUES ('Product3', 3200);
--Inserting 5 orders into Order table
INSERT INTO public."Order" (user_id, product_id) VALUES (1, 1);
INSERT INTO public."Order" (user_id, product_id) VALUES (1, 2);
INSERT INTO public."Order" (user_id, product_id) VALUES (1, 3);
INSERT INTO public."Order" (user_id, product_id) VALUES (2, 1);
INSERT INTO public."Order" (user_id, product_id) VALUES (2, 3);