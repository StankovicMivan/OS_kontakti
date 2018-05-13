DROP SCHEMA IF EXISTS graddrzava;
CREATE SCHEMA graddrzava DEFAULT CHARACTER SET utf8;
USE graddrzava;

CREATE TABLE drzava (
	id INT AUTO_INCREMENT,
	naziv VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE grad (
	id INT AUTO_INCREMENT,
	naziv VARCHAR(255) NOT NULL,
	populacija INT NOT NULL,
	drzava_id INT,
	PRIMARY KEY (id),

	FOREIGN KEY (drzava_id) REFERENCES drzava(id)
		ON DELETE RESTRICT
);

INSERT INTO drzava (id, naziv) VALUES (1, 'Srbija');
INSERT INTO drzava (id, naziv) VALUES (2, 'Rumunija');
INSERT INTO drzava (id, naziv) VALUES (3, 'Mađarska');

INSERT INTO grad (naziv, populacija, drzava_id) VALUES ('Novi Sad', 252459, 1);
INSERT INTO grad (naziv, populacija, drzava_id) VALUES ('Beograd', 1351000, 1);
INSERT INTO grad (naziv, populacija, drzava_id) VALUES ('Temisvar', 306462, 2);
INSERT INTO grad (naziv, populacija, drzava_id) VALUES ('Bukurest', 1913000, 2);
INSERT INTO grad (naziv, populacija) VALUES ('Budimpesta', 1300000);
