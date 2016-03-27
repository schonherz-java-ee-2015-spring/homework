CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  
  
  CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY (id),
  CONSTRAINT "User_name_key" UNIQUE (name),
  CONSTRAINT "User_id_check" CHECK (id > 0),
  CONSTRAINT "User_name_check" CHECK (length(btrim(name::text)) >= 2)
);


CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  price integer,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id),
  CONSTRAINT "Product_name_price_key" UNIQUE (name, price),
  CONSTRAINT "Product_id_check" CHECK (id > 0),
  CONSTRAINT "Product_name_check" CHECK (length(btrim(name::text)) >= 3),
  CONSTRAINT "Product_price_check" CHECK (price >= 0)
);


CREATE TABLE public."Order"
(
  user_id integer NOT NULL,
  product_id integer NOT NULL,
  CONSTRAINT "Order_product_id_fkey" FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Order_user_id_fkey" FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


CREATE OR REPLACE FUNCTION public."getAllUser"()
  RETURNS SETOF "User" AS
'SELECT * FROM public."User";'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getAllUser"()
  OWNER TO postgres;


CREATE OR REPLACE FUNCTION public."getAllProduct"()
  RETURNS SETOF "Product" AS
'SELECT * FROM public."Product";'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getAllProduct"()
  OWNER TO postgres;
  
  
  