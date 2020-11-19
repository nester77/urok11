CREATE DATABASE IF NOT EXISTS addresses_db;

USE addresses_db;


CREATE TABLE IF NOT EXISTS address (
id INT AUTO_INCREMENT,
город VARCHAR(255) NOT NULL,
улица VARCHAR(255) NOT NULL,
номер_дома INT NOT NULL,
корпус INT ,
квартира INT,
PRIMARY KEY (id)
);