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
