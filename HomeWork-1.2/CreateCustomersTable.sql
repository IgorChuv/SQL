CREATE TABLE CUSTOMERS
(
    id           serial PRIMARY KEY NOT NULL ,
    name         varchar(30) NOT NULL,
    surname      varchar(30)NOT NULL,
    age          int CHECK (age > 0),
    phone_number varchar(30)NOT NULL
);