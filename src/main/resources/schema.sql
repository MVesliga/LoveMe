CREATE TABLE IF NOT EXISTS korisnik (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ime VARCHAR(45) NOT NULL,
  prezime VARCHAR(45) NOT NULL,
  datum_rodjenja DATE NULL,
  email VARCHAR(45) NOT NULL,
  korisnicko_ime VARCHAR(45) NULL,
  lozinka VARCHAR(45) NULL,
  isAdmin VARCHAR(1) NULL
  );

CREATE TABLE IF NOT EXISTS ljubimac (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  korisnik_id INT NOT NULL,
  ime VARCHAR(45) NOT NULL,
  vrsta VARCHAR(45) NOT NULL,
  dob INT NOT NULL,
  veterinar DATE NULL,
  cijepljen VARCHAR(2) NULL,
  obuka VARCHAR(100) NULL,
  hrana VARCHAR(100) NULL,
  igracka VARCHAR(100) NULL
  -- CONSTRAINT 'veza' FOREIGN KEY ('korisnik_id') REFERENCES 'korisnik' ('id')
  );

CREATE TABLE IF NOT EXISTS vrsta (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  kategorija VARCHAR(45) NOT NULL
  );