CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;
ALTER TABLE public."User_id_seq"
  OWNER TO postgres;

  CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;
ALTER TABLE public."Product_id_seq"
  OWNER TO postgres;

CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
 )
WITH (OIDS=FALSE);

ALTER TABLE public."User"
  OWNER TO postgres;

CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  price integer,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;

CREATE TABLE public."Order"
(
  user_id integer NOT NULL,
  product_id integer NOT NULL,
  CONSTRAINT "Order_product_id_fkey" FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT "Order_user_id_fkey" FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Order"
  OWNER TO postgres;