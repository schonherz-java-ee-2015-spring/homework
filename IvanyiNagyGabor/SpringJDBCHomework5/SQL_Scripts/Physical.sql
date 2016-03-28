-- Sequence: public."Product_id_seq"

CREATE SEQUENCE public."Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."Product_id_seq"
  OWNER TO postgres;

  
  
-- Sequence: public."User_id_seq"

CREATE SEQUENCE public."User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public."User_id_seq"
  OWNER TO postgres;
  

-- Table: public."User"

CREATE TABLE public."User"
(
  id bigint NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY (id),
  CONSTRAINT "User_name_check" CHECK (length(btrim(name::text)) >= 2)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."User"
  OWNER TO postgres;


  
-- Table: public."Product"

CREATE TABLE public."Product"
(
  id bigint NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  price bigint,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id),
  CONSTRAINT "Product_name_check" CHECK (length(btrim(name::text)) >= 3),
  CONSTRAINT "Product_price_check" CHECK (price >= 0)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;

  
-- Table: public."Order"

CREATE TABLE public."Order"
(
  user_id bigint NOT NULL,
  product_id bigint NOT NULL,
  CONSTRAINT "Order_product_id_fkey" FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT "Order_user_id_fkey" FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Order"
  OWNER TO postgres;
