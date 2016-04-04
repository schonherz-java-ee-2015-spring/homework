CREATE FUNCTION "getUsers"() RETURNS SETOF public."User" AS $$
    SELECT * FROM public."User"
$$ LANGUAGE SQL;

 CREATE FUNCTION "getProducts"() RETURNS SETOF public."Product" AS $$
    SELECT * FROM public."Product"
$$ LANGUAGE SQL;


 CREATE FUNCTION "getOrders"() RETURNS SETOF public."Order" AS $$
    SELECT * FROM public."Order"
$$ LANGUAGE SQL;
