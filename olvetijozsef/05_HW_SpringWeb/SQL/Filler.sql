-----------------------------------------	
INSERT INTO public."User"(name) VALUES ('John Smith');
INSERT INTO public."User"(name) VALUES ('Dell J. Summers');
INSERT INTO public."User"(name) VALUES ('Courtney J. Tew');
INSERT INTO public."User"(name) VALUES ('Edward N. Tripp');
-----------------------------------------	
INSERT INTO public."Product"(name, price) VALUES ('Red Duck', 10);	
INSERT INTO public."Product"(name, price) VALUES ('Yellow Duck', 50);
INSERT INTO public."Product"(name, price) VALUES ('Big Duck', 30);
INSERT INTO public."Product"(name, price) VALUES ('Small Duck', 12);
-----------------------------------------
INSERT INTO public."Order"(user_id, product_id) VALUES (4, 3);
INSERT INTO public."Order"(user_id, product_id) VALUES (1, 2);
INSERT INTO public."Order"(user_id, product_id) VALUES (3, 4);
INSERT INTO public."Order"(user_id, product_id) VALUES (2, 2);
INSERT INTO public."Order"(user_id, product_id) VALUES (2, 1);