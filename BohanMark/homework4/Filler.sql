INSERT INTO "User"(
            name)
    VALUES ('admin');
INSERT INTO "User"(
            name)
    VALUES ('test');


INSERT INTO "Product"(
            name, price)
    VALUES ('laser diod 2pkcs', 300);

INSERT INTO "Product"(
            name, price)
    VALUES ('fork', 500);

    
INSERT INTO "Product"(
            name, price)
    VALUES ('pork', 1600);

   
INSERT INTO "Order"(
            user_id, product_id)
    VALUES ((select id from public."User" where name='admin'), (select id from public."Product" where name='fork') );
INSERT INTO "Order"(
            user_id, product_id)
    VALUES ((select id from public."User" where name='admin'), (select id from public."Product" where name='pork') );
    
INSERT INTO "Order"(
            user_id, product_id)
    VALUES ((select id from public."User" where name='admin'), (select id from public."Product" where name='fork') );
    
INSERT INTO "Order"(
            user_id, product_id)
    VALUES ((select id from public."User" where name='test'), (select id from public."Product" where name='fork') );
INSERT INTO "Order"(
            user_id, product_id)
    VALUES ((select id from public."User" where name='admin'), (select id from public."Product" where name='laser diod 2pkcs') );