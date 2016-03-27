-- Sequence: public."User_id_seq"

-- DROP SEQUENCE public."User_id_seq";

CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 15
  CACHE 1;
ALTER TABLE public."User_id_seq"
  OWNER TO postgres;

-- Table: public."User"

-- DROP TABLE public."User";

CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying,
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."User"
  OWNER TO postgres;

  
  -- Sequence: public."Product_id_seq"

-- DROP SEQUENCE public."Product_id_seq";

CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Product_id_seq"
  OWNER TO postgres;


-- Table: public."Product"

-- DROP TABLE public."Product";

CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying,
  price character varying,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;
  
  -- Table: public."Order"

-- DROP TABLE public."Order";

CREATE TABLE public."Order"
(
  user_id integer,
  product_id integer,
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