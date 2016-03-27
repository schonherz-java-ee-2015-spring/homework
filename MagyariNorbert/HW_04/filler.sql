INSERT INTO public."User"(
             name)
    VALUES ('Mac Era');

INSERT INTO public."User"(
             name)
    VALUES ('Bekre Pal');

INSERT INTO public."Product"(
            name, price)
    VALUES ( 'Kávé', 100);

INSERT INTO public."Product"(
            name, price)
    VALUES ( 'Bab', 80);

INSERT INTO public."Product"(
            name, price)
    VALUES ( 'Csésze', 90);
	
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES ((select min(id) from public."User"), (select min(id) from public."Product"));

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES ((select min(id) from public."User"), (select (min(id)+1) from public."Product"));

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES ((select min(id) from public."User"), (select (min(id)+2) from public."Product"));

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES ((select (min(id)+1) from public."User"), (select min(id) from public."Product"));

INSERT INTO public."Order"(
            user_id, product_id)
    VALUES ((select (min(id)+1) from public."User"), (select (min(id)+1) from public."Product"));

