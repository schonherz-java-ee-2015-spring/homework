-----------------------------------------
CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
-----------------------------------------
CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(35) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (id)
);
-----------------------------------------
CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
-----------------------------------------
CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  price numeric NOT NULL,
  CONSTRAINT prod_pk PRIMARY KEY (id)
);
-----------------------------------------
CREATE SEQUENCE public."Order_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
-----------------------------------------
CREATE TABLE public."Order"
(
  id integer NOT NULL DEFAULT nextval('"Order_id_seq"'::regclass),
  user_id integer,
  product_id integer NOT NULL,
  CONSTRAINT o_pk PRIMARY KEY (id),
  CONSTRAINT p_fk FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT u_fk FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);
-----------------------------------------
CREATE OR REPLACE FUNCTION public."getProducts"()
  RETURNS SETOF "Product" AS
'SELECT id, name, price FROM public."Product" ORDER BY id;'
  LANGUAGE sql VOLATILE
  COST 100;
-----------------------------------------
CREATE OR REPLACE FUNCTION public."getUsers"()
  RETURNS SETOF "User" AS
'SELECT id, name FROM public."User" ORDER BY id;'
  LANGUAGE sql VOLATILE
  COST 100;