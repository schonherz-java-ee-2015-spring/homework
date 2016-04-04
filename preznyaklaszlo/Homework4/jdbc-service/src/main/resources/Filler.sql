-- Insert to User table

INSERT INTO public."User"(
            id, name)
    VALUES (1, 'Kiss Lajos');

INSERT INTO public."User"(
            id, name)
    VALUES (2, 'Nagy Imre');

	
-- Insert to Product table

INSERT INTO public."Product"(
            id, name, price)
    VALUES (1, 'Mosógép', 25000);

INSERT INTO public."Product"(
            id, name, price)
    VALUES (2, 'Fagyasztó', 30000);

INSERT INTO public."Product"(
            id, name, price)
    VALUES (3, 'Hűtő', 35000);
	
-- Insert to Order table

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 1);

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 2);

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 3);

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 1);

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 3);

