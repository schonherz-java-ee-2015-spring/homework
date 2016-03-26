INSERT INTO public."Product"(
            name, price)
    VALUES ('tévé', 1500);
INSERT INTO public."Product"(
            name, price)
    VALUES ('hifitorony', 500);
INSERT INTO public."Product"(
            name, price)
    VALUES ('merdzsó', 50000);


INSERT INTO public."User"(
            name)
    VALUES ('Géza');
INSERT INTO public."User"(
            name)
    VALUES ('Eszmerálda');

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
    VALUES (2, 2);