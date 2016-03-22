-- CREATE USER TABLE
DROP TABLE IF EXISTS public."User";
CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(30),
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."User"
  OWNER TO postgres;
  
  -- CREATE PRODUCT TABLE
DROP TABLE public."Product";
CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying(50),
  CONSTRAINT "Product_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;

-- CREATE ORDER TABLE
DROP TABLE public."Order";
CREATE TABLE public."Order"
(
  user_id integer NOT NULL,
  product_id integer NOT NULL,
  CONSTRAINT "Order_product_id_fkey" FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Order_user_id_fkey" FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Order"
  OWNER TO postgres;
  
-- CREATE USER ID SEQUENCE (if not created automatically)
CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."User_id_seq"
  OWNER TO postgres;
  
  -- CREATE PRODUCT ID SEQUENCE (if not created automatically)
  CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Product_id_seq"
  OWNER TO postgres;
  
  -- CREATE TWO FUNCTIONS BECAUSE OF THE CALLABLE STATEMENT
CREATE OR REPLACE FUNCTION public."getProducts"()
  RETURNS SETOF "Product" AS
'SELECT * FROM public."Product";'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getProducts"()
  OWNER TO postgres;

  
CREATE OR REPLACE FUNCTION public."getUsers"()
  RETURNS SETOF "User" AS
'SELECT U.id, U.name FROM public."User" AS U;'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getUsers"()
  OWNER TO postgres;
