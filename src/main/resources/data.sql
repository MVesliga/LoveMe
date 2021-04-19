INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', '$2y$12$tvFvkRFN0C//3MLED9YmQeGyiWoGJA55ytZax.85Kg1BEmO4R7MI2');
INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Administrator', 'Admin', '1997-07-29', 'admin@mail.com', 'admin', '$2y$12$YQs3yNmEIbBQCyrRG2CgBeZ3B2PYekj680etsbYenhNtSrmXZJg0S');

-- TEST VALUES
INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Luka', 'Peric', '1997-07-29', 'luka@mail.com', 'luka', '$2y$12$rTnlHJvPZWS/jWYDwvl0iOPveDGiBx8HGSGP4J0Mv21rupMnYGEfq');

INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('pero', 'ROLE_USER');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('admin', 'ROLE_USER');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('luka', 'ROLE_USER');

INSERT INTO ljubimac (ime, korisnik_id, korisnicko_ime, vrsta, dob, veterinar, cijepljen, obuka, hrana, igracka)
VALUES ('Perin pas', 1, 'pero', 'Africki tvor', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'da', 'ne', 'hrana', 'igracka'),
('Perina macka', 1, 'pero', 'Macka', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau'),
('Perina macka', 1, 'pero', 'Patuljasta svinja', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau'),
('Perina macka', 1, 'pero', 'Kunic', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau'),
('Perina macka', 1, 'pero', 'Cincila', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau');
