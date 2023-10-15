DROP TABLE IF EXISTS Transaction;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Person;

CREATE TABLE Person (
    id SERIAL PRIMARY KEY ,
    document_number VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    gender VARCHAR(255),
    age VARCHAR(255),
    address VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE Client (
    id SERIAL PRIMARY KEY ,
    password VARCHAR(255),
    status BOOLEAN,
    person_id INT,
    FOREIGN KEY (person_id) REFERENCES Person(id)
);

CREATE TABLE Account (
    id SERIAL PRIMARY KEY ,
    number VARCHAR(255),
    type VARCHAR(255),
    actual_amount FLOAT,
    first_amount FLOAT,
    status BOOLEAN,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES Client(id)
);

CREATE TABLE Transaction (
    id SERIAL PRIMARY KEY ,
    movement FLOAT,
    type VARCHAR(255),
    final_amount FLOAT,
    created_on TIMESTAMP,
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES Account(id)
);
