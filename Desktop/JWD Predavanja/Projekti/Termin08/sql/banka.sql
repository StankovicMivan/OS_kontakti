DROP SCHEMA IF EXISTS banka;
CREATE SCHEMA banka DEFAULT CHARACTER SET utf8;
USE banka;

CREATE TABLE racuni (
	id INT AUTO_INCREMENT,
	vlasnik VARCHAR(20) NOT NULL,
	stanje DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(id)
);
	
INSERT INTO racuni (vlasnik, stanje) VALUES ('Vlasnik 1', 100);
INSERT INTO racuni (vlasnik, stanje) VALUES ('Vlasnik 2', 100);