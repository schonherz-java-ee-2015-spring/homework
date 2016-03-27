
CREATE TABLE public."User"
(
   id serial NOT NULL, 
   name character varying NOT NULL, 
   CONSTRAINT user_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;


CREATE TABLE public."Product"
(
   id serial NOT NULL, 
   name character varying NOT NULL, 
   price integer DEFAULT 0, 
   CONSTRAINT product_pk PRIMARY KEY (id)
) 
WITH (
  OIDS = FALSE
)
;

CREATE TABLE public."Order"
(
   user_id serial NOT NULL, 
   product_id serial NOT NULL, 
   CONSTRAINT userid_fk FOREIGN KEY (user_id) REFERENCES public."User" (id) ON UPDATE NO ACTION ON DELETE NO ACTION, 
   CONSTRAINT product_id_fk FOREIGN KEY (product_id) REFERENCES public."Product" (id) ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
)
;

CREATE SEQUENCE public."Order_product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Order_product_id_seq"
  OWNER TO postgres;

CREATE SEQUENCE public."Order_user_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Order_user_id_seq"
  OWNER TO postgres;

  CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Product_id_seq"
  OWNER TO postgres;

CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."User_id_seq"
  OWNER TO postgres;

CREATE OR REPLACE FUNCTION public."getAllProduct"()
  RETURNS SETOF "Product" AS
'SELECT * FROM public."Product"'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getAllProduct"()
  OWNER TO postgres;

CREATE OR REPLACE FUNCTION public."getAllUser"()
  RETURNS SETOF "User" AS
'Select * FROM "User"'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION public."getAllUser"()
  OWNER TO postgres;
