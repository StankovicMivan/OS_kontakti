DROP SCHEMA IF EXISTS menjacnica;
CREATE SCHEMA menjacnica DEFAULT CHARACTER SET utf8;
USE menjacnica;

CREATE TABLE valute (
	id INT AUTO_INCREMENT, 
    oznaka VARCHAR(3) UNIQUE NOT NULL, 
	naziv VARCHAR(30) NOT NULL, 

	PRIMARY KEY(id), 
	INDEX(oznaka)
);

CREATE TABLE kursneListe (
	id INT AUTO_INCREMENT, 
	datum DATE UNIQUE NOT NULL, 

	PRIMARY KEY(id), 
	INDEX(datum)
);

CREATE TABLE vrednostiValuta (
	valuta INT, 
    kursnaLista INT, 
	kupovniKurs DECIMAL(10, 2) NOT NULL, 
    prodajniKurs DECIMAL(10, 2) NOT NULL, 

	PRIMARY KEY (valuta, kursnaLista), 
	FOREIGN KEY (valuta) REFERENCES valute(id) ON DELETE RESTRICT, 
	FOREIGN KEY (kursnaLista) REFERENCES kursneListe(id) ON DELETE RESTRICT
);

INSERT INTO valute (id, oznaka, naziv) VALUES (1, 'USD', 'Američki dolar');
INSERT INTO valute (id, oznaka, naziv) VALUES (2, 'EUR', 'Evro');
INSERT INTO valute (id, oznaka, naziv) VALUES (3, 'CHF', 'Švajcarski franak');

INSERT INTO kursneListe (id, datum) VALUES (1, '2013-12-21');
INSERT INTO kursneListe (id, datum) VALUES (2, '2013-12-22');
INSERT INTO kursneListe (id, datum) VALUES (3, '2013-12-23');

INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (1, 1, 108.00, 109.00);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (2, 1, 123.00, 123.50);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (1, 2, 107.00, 110.00);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (2, 2, 123.50, 124.00);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (3, 2, 100.00, 101.00);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (1, 3, 108.00, 109.00);
INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (3, 3, 101.00, 102.00);