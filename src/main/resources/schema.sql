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

CREATE TABLE IF NOT EXISTS ljubimac (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  korisnik_id INT NOT NULL,
  korisnicko_ime VARCHAR(45) NULL,
  ime VARCHAR(45) NOT NULL,
  vrsta VARCHAR(45) NOT NULL,
  dob INT NOT NULL,
  veterinar DATE NULL,
  cijepljen VARCHAR(2) NULL,
  obuka VARCHAR(100) NULL,
  hrana VARCHAR(100) NULL,
  igracka VARCHAR(100) NULL,
  FOREIGN KEY (korisnicko_ime) REFERENCES korisnik (korisnicko_ime),
  FOREIGN KEY (korisnik_id) REFERENCES korisnik (id)
  );

CREATE TABLE IF NOT EXISTS korisnik_uloga (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  korisnicko_ime varchar(45) NOT NULL,
  uloga VARCHAR(45) NOT NULL,
  FOREIGN KEY (korisnicko_ime) REFERENCES korisnik (korisnicko_ime)
);

CREATE TABLE IF NOT EXISTS podsjetnik (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  korisnik_id INT NOT NULL,
  korisnicko_ime VARCHAR(45) NULL,
  naslov VARCHAR(45) NULL,
  ljubimac_ime VARCHAR(45) NOT NULL,
  vrsta VARCHAR(45) NOT NULL,
  datum DATE NOT NULL,
  vrijeme VARCHAR(6) NOT NULL,
  naputak VARCHAR(100) NULL,
  FOREIGN KEY (korisnicko_ime) REFERENCES korisnik (korisnicko_ime),
  FOREIGN KEY (korisnik_id) REFERENCES korisnik (id)
  );

CREATE TABLE IF NOT EXISTS objava (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 korisnik_id INT NOT NULL,
 sadrzaj VARCHAR(255),
 datum_objave TIMESTAMP NOT NULL,
 FOREIGN KEY (korisnik_id) REFERENCES korisnik (id)
);

CREATE TABLE IF NOT EXISTS komentar (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 korisnik_id INT NOT NULL,
 objava_id INT NOT NULL,
 datum_komentara TIMESTAMP NOT NULL,
 sadrzaj VARCHAR(255)
);
