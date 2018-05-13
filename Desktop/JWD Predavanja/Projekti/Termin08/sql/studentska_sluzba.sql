DROP SCHEMA IF EXISTS studentskasluzba;
CREATE SCHEMA studentskasluzba DEFAULT CHARACTER SET utf8;
USE studentskasluzba;

-- KREIRANJE TABELA
CREATE TABLE studenti (
	student_id INT AUTO_INCREMENT, -- AUTO_INCREMENT - SUBP ce automatski odrediti vrednost ovog polja, ne treba navoditi vrednost pri ubacivanju novog sloga
	indeks VARCHAR(20) NOT NULL,
	ime VARCHAR(20) NOT NULL,
	prezime VARCHAR(20) NOT NULL,
	grad VARCHAR(20) NOT NULL,
	PRIMARY KEY(student_id) -- broj indeksa bi mogao biti primarni kljuc, ali je praksa da se uvede surogatni kljuc (to je ovo auto_increment polje student_id) o cijoj vrednosti baza vodi racuna i garantuje da je jedinstveno za svaki slog
);
	
CREATE TABLE nastavnici (
	nastavnik_id INT AUTO_INCREMENT,
	ime VARCHAR(20) NOT NULL,
	prezime VARCHAR(20) NOT NULL,
	zvanje VARCHAR(20) NOT NULL,
	PRIMARY KEY(nastavnik_id)
);
	
CREATE TABLE predmeti (
	predmet_id INT AUTO_INCREMENT,
	naziv VARCHAR(20) NOT NULL,
	PRIMARY KEY(predmet_id)
);

CREATE TABLE ispitni_rokovi (
	rok_id INT AUTO_INCREMENT,
	naziv VARCHAR(20) NOT NULL,
	pocetak DATE NOT NULL,
	kraj DATE NOT NULL,
	PRIMARY KEY(rok_id)
);

CREATE TABLE predaje (
	nastavnik_id INT,
	predmet_id INT,
	PRIMARY KEY(nastavnik_id, predmet_id),
	
	FOREIGN KEY (nastavnik_id) REFERENCES nastavnici(nastavnik_id)
	    ON DELETE RESTRICT, -- ovo restrict znaci da se zabrani brisanje nastavnika ako u tabeli 'predaje' postoji slog koji ukazuje na tog nastavnika
	FOREIGN KEY (predmet_id) REFERENCES predmeti(predmet_id)
	    ON DELETE RESTRICT
);
	
CREATE TABLE pohadja (
	student_id INT,
	predmet_id INT,
	PRIMARY KEY(student_id, predmet_id),
	
	FOREIGN KEY (student_id) REFERENCES studenti(student_id)
		ON DELETE RESTRICT,
	FOREIGN KEY (predmet_id) REFERENCES predmeti(predmet_id)
		ON DELETE RESTRICT
); 
	
CREATE TABLE ispitne_prijave (
	student_id INT,
	predmet_id INT,
	rok_id INT,
	teorija INT,
	zadaci INT,
	PRIMARY KEY (student_id, predmet_id, rok_id),
	
	FOREIGN KEY (student_id) REFERENCES studenti(student_id)
		ON DELETE RESTRICT,
	FOREIGN KEY (predmet_id) REFERENCES predmeti(predmet_id)
		ON DELETE RESTRICT,                        
	FOREIGN KEY (rok_id) REFERENCES ispitni_rokovi(rok_id)
		ON DELETE RESTRICT
);
	
-- UBACIVANJE PODATAKA

-- Obratiti paznju da se pri ubacivanju ne navode vrednosti za auto_increment polja, obzirom da ce SUBP automatski ovim poljima dodeliti vrednost
INSERT INTO studenti (indeks, ime, prezime, grad) VALUES ('E 1/12', 'Petar', 'Mihajlovic', 'Novi Sad');
INSERT INTO studenti (indeks, ime, prezime, grad) VALUES ('E 2/12', 'Dejan', 'Ivanovic', 'Loznica');
INSERT INTO studenti (indeks, ime, prezime, grad) VALUES ('E 3/12', 'Zoran', 'Kovacevic', 'Indjija');
INSERT INTO studenti (indeks, ime, prezime, grad) VALUES ('E 4/12', 'Marko', 'Popovic', 'Novi Sad');

INSERT INTO nastavnici (ime, prezime, zvanje) VALUES ('Marko', 'Popovic', 'Docent');
INSERT INTO nastavnici (ime, prezime, zvanje) VALUES ('Milan', 'Janjic', 'Docent');
INSERT INTO nastavnici (ime, prezime, zvanje) VALUES ('Zeljko', 'Djuric', 'Asistent');
	
INSERT INTO predmeti (naziv) VALUES ('Algebra');
INSERT INTO predmeti (naziv) VALUES ('Analiza 1');

-- Format u kojem SUBP prima datum se moze konfigurisati. Ovo je default format (godina - mesec - dan) za MySQL server. Datumi se u SQLu prosledjuju kao stringovi u odgovarajucem formatu
INSERT INTO ispitni_rokovi (naziv, pocetak, kraj) VALUES ('Januarski', '2015-01-15', '2015-01-29');
INSERT INTO ispitni_rokovi (naziv, pocetak, kraj) VALUES ('Februarski', '2015-02-01', '2015-02-14');

INSERT INTO predaje VALUES (1, 1); -- Ovako je napisano zbog jednostavnosti, ali je ovo potencijalna greska. Pretpostavlja se da ce prvom predmetu biti dodeljen identifikator 1, a ne mora to uvek da bude slucaj obzirom da SUBP odredjuje tu vrednost (npr. ako vec ima 5 predmeta u bazi podataka, novi predmet ce dobiti id 6)
INSERT INTO predaje VALUES (1, 2);
INSERT INTO predaje VALUES (2, 2);
INSERT INTO predaje VALUES (3, 1);
	
INSERT INTO pohadja VALUES (1, 1);
INSERT INTO pohadja VALUES (1, 2);
INSERT INTO pohadja VALUES (2, 1);
INSERT INTO pohadja VALUES (3, 1);

INSERT INTO ispitne_prijave VALUES (1, 1, 1, 20, 70);
INSERT INTO ispitne_prijave VALUES (1, 2, 1, 10, 54);
INSERT INTO ispitne_prijave VALUES (2, 1, 1, 10, 10);
INSERT INTO ispitne_prijave VALUES (2, 1, 2, 40, 30);
INSERT INTO ispitne_prijave VALUES (3, 1, 1, 10, 30);