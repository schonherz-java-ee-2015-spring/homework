-- Create getProduct() function

CREATE OR REPLACE FUNCTION "getProducts"()
  RETURNS SETOF "Product" AS
'SELECT * FROM public."Product"'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION "getProducts"()
  OWNER TO postgres;



-- Create getUsers() function

CREATE OR REPLACE FUNCTION "getUsers"()
  RETURNS SETOF "User" AS
'SELECT * FROM public."User"'
  LANGUAGE sql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION "getUsers"()
  OWNER TO postgres;
