CREATE TABLE IF NOT EXISTS korisnik (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ime VARCHAR(45) NOT NULL,
  prezime VARCHAR(45) NOT NULL,
  datum_rodjenja DATE NULL,
  email VARCHAR(45) NOT NULL,
  korisnicko_ime VARCHAR(45) UNIQUE NULL,
  lozinka VARCHAR(255) NULL,
  enabled TINYINT NOT NULL DEFAULT 1
  );

CREATE TABLE IF NOT EXISTS korisnik_uloga (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    korisnicko_ime varchar(45) NOT NULL,
    uloga VARCHAR(45) NOT NULL,
    FOREIGN KEY (korisnicko_ime) REFERENCES korisnik (korisnicko_ime)
);

CREATE TABLE IF NOT EXISTS vrsta_zivotinje (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  vrsta VARCHAR(45) NULL
  );

CREATE TABLE IF NOT EXISTS ljubimac (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_vrsta_zivotinje INT NOT NULL,
  id_korisnik INT NOT NULL,
  ime VARCHAR(45) NULL,
  dob INT NULL,
  zadnji_posjet_kod_veterinara DATETIME NULL,
  cijepljen VARCHAR(2) NULL,
  obuka VARCHAR(45) NULL,
  najdraza_hrana VARCHAR(45) NULL,
  najdraza_igracka VARCHAR(45) NULL,
  FOREIGN KEY (id_korisnik) REFERENCES korisnik (id),
  FOREIGN KEY (id_vrsta_zivotinje) REFERENCES vrsta_zivotinje (id)
    );
