DROP TABLE IF EXISTS pets;

CREATE TABLE pets (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  idVrstaZivotinje INT NOT NULL,
  idKorisnik INT NOT NULL,
  imeLjubimca VARCHAR(45) NOT NULL,
  dobLjubimca INT NOT NULL,
  zadnjiPosjetKodVeterinara DATETIME,
  cijepljen VARCHAR(2) NOT NULL,
  obuka VARCHAR(45),
  najdrazaHrana VARCHAR(200),
  najdrazaIgracka VARCHAR(200)
);

INSERT INTO pets (idVrstaZivotinje, idKorisnik, imeLjubimca, dobLjubimca, cijepljen) VALUES
  ('1', '1', 'jedan', '5', 'da'),
  ('1', '1', 'dva', '4', 'da'),
  ('1', '1', 'tri', '3', 'da');