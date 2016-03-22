-- sequence for autoincrementing the id column in the table User
CREATE SEQUENCE "User_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999999999
  START 1
  CACHE 1;

-- sequence for autoincrementing the id column in the table Product
CREATE SEQUENCE "Product_id_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999999999999
  START 1
  CACHE 1;

-- create table User
CREATE TABLE "User"
(
  id integer NOT NULL DEFAULT nextval('"User_id_seq"'::regclass),
  name character varying(50) NOT NULL,
  CONSTRAINT user_primary_key PRIMARY KEY (id)
);

-- create table Product
CREATE TABLE "Product"
(
  id integer NOT NULL DEFAULT nextval('"Product_id_seq"'::regclass),
  name character varying(70) NOT NULL,
  price integer NOT NULL DEFAULT 0,
  CONSTRAINT product_primary_key PRIMARY KEY (id)
);

-- create table Order
CREATE TABLE "Order"
(
  user_id integer NOT NULL,
  product_id integer NOT NULL,
  CONSTRAINT order_fk_product FOREIGN KEY (product_id)
      REFERENCES "Product" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT order_fk_user FOREIGN KEY (user_id)
      REFERENCES "User" (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);