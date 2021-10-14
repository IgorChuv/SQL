CREATE TABLE ORDERS
(
    id           serial PRIMARY KEY NOT NULL,
    date         date NOT NULL,
    customer_id  int NOT NULL,
    product_name varchar(30) NOT NULL,
    amount       int CHECK (amount > 0)
);