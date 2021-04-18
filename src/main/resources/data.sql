INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', '$2y$12$tvFvkRFN0C//3MLED9YmQeGyiWoGJA55ytZax.85Kg1BEmO4R7MI2');

-- TEST VALUES
INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Luka', 'Peric', '1997-07-29', 'luka@mail.com', 'luka', '$2y$12$rTnlHJvPZWS/jWYDwvl0iOPveDGiBx8HGSGP4J0Mv21rupMnYGEfq');

INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('pero', 'ROLE_USER');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('luka', 'ROLE_USER');
