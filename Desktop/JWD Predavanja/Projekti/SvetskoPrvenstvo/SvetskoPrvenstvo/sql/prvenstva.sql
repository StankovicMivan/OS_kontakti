DROP SCHEMA IF EXISTS prvenstva;
CREATE SCHEMA prvenstva DEFAULT CHARACTER SET utf8;
USE prvenstva;

CREATE TABLE drzava (
	id INT AUTO_INCREMENT,
    naziv VARCHAR(20) NOT NULL, 
    PRIMARY KEY (id)
);

CREATE TABLE prvenstvo (
	godina INT NOT NULL,
    naziv VARCHAR(20) NOT NULL, 
    domacin INT NOT NULL, 
    osvajac INT NOT NULL, 
    PRIMARY KEY (godina)
);

INSERT INTO drzava (id, naziv) VALUES (1, 'Srbija');
INSERT INTO drzava (id, naziv) VALUES (2, 'Nemacka');
INSERT INTO drzava (id, naziv) VALUES (3, 'Italija');
INSERT INTO drzava (id, naziv) VALUES (4, 'Makedonija');
INSERT INTO drzava (id, naziv) VALUES (5, 'Francuska');
INSERT INTO drzava (id, naziv) VALUES (6, 'Brazil');
INSERT INTO drzava (id, naziv) VALUES (7, 'Juzna Afrika');
INSERT INTO drzava (id, naziv) VALUES (8, 'Spanija');

INSERT INTO prvenstvo (godina, naziv, domacin, osvajac) VALUES (2000,'2000-te', 1, 2);
INSERT INTO prvenstvo (godina, naziv, domacin, osvajac) VALUES (2006, 'Nemacka06' , 2, 3);
INSERT INTO prvenstvo (godina, naziv, domacin, osvajac) VALUES (2010, 'Africa10', 7, 8);
INSERT INTO prvenstvo (godina, naziv, domacin, osvajac) VALUES (2014, 'Brasil14', 6, 2);
INSERT INTO prvenstvo (godina, naziv, domacin, osvajac) VALUES (1998, 'France98', 5, 5);
