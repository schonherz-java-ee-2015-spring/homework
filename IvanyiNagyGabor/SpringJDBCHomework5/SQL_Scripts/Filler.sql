-- Insert 2 users into the User table
INSERT INTO public."User"(
            name)
    VALUES ('Chipotle');
	
INSERT INTO public."User"(
            name)
    VALUES ('Optimus');




-- Insert 3 products into the Product table
INSERT INTO public."Product"(
            name, price)
    VALUES ('Bone', 500);
	
INSERT INTO public."Product"(
            name, price)
    VALUES ('Milk', 200);
	
INSERT INTO public."Product"(
            name, price)
    VALUES ('Freedom', 1000000);

	
	

-- Insert 5 orders into th Order table
-- Chipolte -> Bone
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 1);
	
-- Chipotle -> Milk
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (1, 2);
	
-- Optmimus -> Bone
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 1);
	

-- Optmimus -> Milk
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 2);
	
-- Optmimus -> Freedom
INSERT INTO public."Order"(
            user_id, product_id)
    VALUES (2, 3);