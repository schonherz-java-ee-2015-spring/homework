-- Function: public."getUsers"()

-- DROP FUNCTION public."getUsers"();

CREATE OR REPLACE FUNCTION public."getUsers"()
  RETURNS SETOF "User" AS
'SELECT * FROM public."User"'
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION public."getUsers"()
  OWNER TO postgres;


  
-- Function: public."getProducts"()

-- DROP FUNCTION public."getProducts"();

CREATE OR REPLACE FUNCTION public."getProducts"()
  RETURNS SETOF "Product" AS
'SELECT * FROM "Product" '
  LANGUAGE sql VOLATILE
  COST 100;
ALTER FUNCTION public."getProducts"()
  OWNER TO postgres;
