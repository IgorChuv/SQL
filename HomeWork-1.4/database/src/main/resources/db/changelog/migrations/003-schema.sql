CREATE TABLE PERSONS
(
    name varchar(30) DEFAULT 'UNKNOWN',
    surname varchar(30) DEFAULT 'UNKNOWN',
    age int CHECK (age > 0),
    phone_number varchar(30) DEFAULT 'UNKNOWN',
    city_of_living varchar(30) DEFAULT 'UNKNOWN',
    PRIMARY KEY (name,surname,age)
);