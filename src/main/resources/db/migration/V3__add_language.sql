CREATE TABLE language(
  lang_code varchar(2) NOT NULL PRIMARY KEY,
	language_name varchar(50)
);

CREATE TABLE language_values(
  id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  language_code varchar(2),
  language_key varchar(50),
  language_value VARCHAR(500)
);

INSERT INTO language
	(lang_code, language_name)
VALUES
	('ua', 'Українська'), ('en', 'English'), ('pl', 'Polski')
;

