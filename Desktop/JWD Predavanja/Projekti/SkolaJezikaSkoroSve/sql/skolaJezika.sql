DROP SCHEMA IF EXISTS skolaJezika;
CREATE SCHEMA skolaJezika DEFAULT CHARACTER SET utf8;
USE skolaJezika;

-- KREIRANJE TABELA
CREATE TABLE skola (
	id INT AUTO_INCREMENT, -- AUTO_INCREMENT - SUBP ce automatski odrediti vrednost ovog polja, ne treba navoditi vrednost pri ubacivanju novog sloga
	naziv VARCHAR(20) NOT NULL,
	adresa VARCHAR(20) NOT NULL,
	telefon VARCHAR(20) NOT NULL,
	email VARCHAR(20) NOT NULL,
	web VARCHAR(20) NOT NULL,
	pib INT(9) NOT NULL,
	maticniBr INT(9) NOT NULL,
	ziroRacun VARCHAR(20) NOT NULL,
	PRIMARY KEY(id) -- broj indeksa bi mogao biti primarni kljuc, ali je praksa da se uvede surogatni kljuc (to je ovo auto_increment polje student_id) o cijoj vrednosti baza vodi racuna i garantuje da je jedinstveno za svaki slog
);

CREATE TABLE nastavnik (
	id INT AUTO_INCREMENT, -- AUTO_INCREMENT - SUBP ce automatski odrediti vrednost ovog polja, ne treba navoditi vrednost pri ubacivanju novog sloga
	ime VARCHAR(20) NOT NULL,
	prezime VARCHAR(20) NOT NULL,
	PRIMARY KEY(id) -- broj indeksa bi mogao biti primarni kljuc, ali je praksa da se uvede surogatni kljuc (to je ovo auto_increment polje student_id) o cijoj vrednosti baza vodi racuna i garantuje da je jedinstveno za svaki slog
);
	
CREATE TABLE ucenik (
	id INT AUTO_INCREMENT,
	ime VARCHAR(20) NOT NULL,
	prezime VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);
	
CREATE TABLE kurs (
	id INT AUTO_INCREMENT,
	jezik VARCHAR(20) NOT NULL,
   	tip VARCHAR(20) NOT NULL,
	naziv VARCHAR(20) NOT NULL,
    cena DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE uplate (
	ucenik_id INT,
	kurs_id INT,
	PRIMARY KEY(ucenik_id, kurs_id),
	
	FOREIGN KEY (ucenik_id) REFERENCES ucenik(id)
	    ON DELETE RESTRICT, -- ovo restrict znaci da se zabrani brisanje nastavnika ako u tabeli 'predaje' postoji slog koji ukazuje na tog nastavnika
	FOREIGN KEY (kurs_id) REFERENCES kurs(id)
	    ON DELETE RESTRICT
);

CREATE TABLE pohadja (
	ucenik_id INT,
	kurs_id INT,
	PRIMARY KEY(ucenik_id, kurs_id),
	
	FOREIGN KEY (ucenik_id) REFERENCES ucenik(id)
	    ON DELETE RESTRICT, -- ovo restrict znaci da se zabrani brisanje nastavnika ako u tabeli 'predaje' postoji slog koji ukazuje na tog nastavnika
	FOREIGN KEY (kurs_id) REFERENCES kurs(id)
	    ON DELETE RESTRICT
);
CREATE TABLE predaje (
	nastavnik_id INT,
	kurs_id INT,
	PRIMARY KEY(nastavnik_id, kurs_id),
	
	FOREIGN KEY (nastavnik_id) REFERENCES nastavnik(id)
	    ON DELETE RESTRICT, -- ovo restrict znaci da se zabrani brisanje nastavnika ako u tabeli 'predaje' postoji slog koji ukazuje na tog nastavnika
	FOREIGN KEY (kurs_id) REFERENCES kurs(id)
	    ON DELETE RESTRICT
);

