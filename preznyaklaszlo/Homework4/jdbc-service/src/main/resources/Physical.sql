-- Table: public."User"

DROP TABLE public."User";

CREATE TABLE public."User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(30) NOT NULL,
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."User"
  OWNER TO postgres;

  
  -- Table: public."Product"

DROP TABLE public."Product";

CREATE TABLE public."Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  price integer NOT NULL,
  name character varying(20) NOT NULL,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;

  
  -- Table: public."Order"

DROP TABLE public."Order";

CREATE TABLE public."Order"
(
  user_id integer NOT NULL,
  product_id integer NOT NULL,
  CONSTRAINT "Product_fkey" FOREIGN KEY (product_id)
      REFERENCES public."Product" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "User_fkey" FOREIGN KEY (user_id)
      REFERENCES public."User" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Order"
  OWNER TO postgres;
