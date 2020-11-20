CREATE DATABASE IF NOT EXISTS addresses_db;

USE addresses_db;


CREATE TABLE IF NOT EXISTS address (
id INT,
city VARCHAR(255) NOT NULL,
street VARCHAR(255) NOT NULL,
house INT NOT NULL,
building INT ,
flat INT,
PRIMARY KEY (id)
);

SELECT * FROM address