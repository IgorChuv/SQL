USE my_tables;

CREATE TABLE CUSTOMERS
(
    id           serial PRIMARY KEY NOT NULL ,
    name         varchar(30) NOT NULL,
    surname      varchar(30)NOT NULL,
    age          int CHECK (age > 0),
    phone_number varchar(30)NOT NULL
);

CREATE TABLE ORDERS
(
    id           serial PRIMARY KEY NOT NULL,
    date         date NOT NULL,
    customer_id  int NOT NULL,
    product_name varchar(30) NOT NULL,
    amount       int CHECK (amount > 0)
);