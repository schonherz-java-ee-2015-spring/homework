-----------------------------------------	
INSERT INTO public."User"(name)
    VALUES ('Nagy Elek');
-----------------------------------------
INSERT INTO public."User"(name)
    VALUES ('Kovács Teréz');
-----------------------------------------	
INSERT INTO public."Product"(
            name, price)
    VALUES ('LED Monitor', 59900);
-----------------------------------------	
INSERT INTO public."Product"(
            name, price)
    VALUES ('Leather Wallet', 3500);
-----------------------------------------
INSERT INTO public."Product"(
            name, price)
    VALUES ('Pocket Knife', 6500);
-----------------------------------------
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 1);
-----------------------------------------
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 2);
-----------------------------------------
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 3);
-----------------------------------------
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 2);
-----------------------------------------
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 3);