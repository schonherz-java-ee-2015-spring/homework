INSERT INTO public."User"(
            name)
    VALUES ('Krisztián Erdei');
	
INSERT INTO public."User"(
            name)
    VALUES ('Anna Molnár');	

    INSERT INTO public."Product"(
            name, price)
    VALUES ('GIGABYTE GeForce GTX 960', 60000);

INSERT INTO public."Product"(
            name, price)
    VALUES ('GIGABYTE GeForce GTX 950', 50000);
   
INSERT INTO public."Product"(
            name, price)
    VALUES ('ASUS GeForce GTX Titan ', 470000);	

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

