
CREATE TABLE "User"
(
  id serial NOT NULL,
  name character varying(50),
  CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "User"
  OWNER TO postgres;

CREATE TABLE "Product"
(
  id serial NOT NULL,
  name character varying(50),
  price integer,
  CONSTRAINT "Product_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Product"
  OWNER TO postgres;

CREATE TABLE "Order"
(
  id serial NOT NULL,
  product_id serial NOT NULL,
  user_id serial NOT NULL,
  CONSTRAINT "Order_pkey" PRIMARY KEY (id),
  CONSTRAINT "Order_product_id_fkey" FOREIGN KEY (product_id)
      REFERENCES "Product" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "Order_user_id_fkey" FOREIGN KEY (user_id)
      REFERENCES "User" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "Order"
  OWNER TO postgres;







CREATE SEQUENCE "User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "User_id_seq"
  OWNER TO postgres;

  
CREATE SEQUENCE "Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "Product_id_seq"
  OWNER TO postgres;



CREATE SEQUENCE "Order_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "Order_id_seq"
  OWNER TO postgres;



CREATE SEQUENCE "Order_user_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "Order_user_id_seq"
  OWNER TO postgres;



CREATE SEQUENCE "Order_product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "Order_product_id_seq"
  OWNER TO postgres;
