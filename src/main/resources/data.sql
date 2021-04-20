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
VALUES ('Perin afrički tvor', 1, 'pero', 'Afrički tvor', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'da', 'ne', '', ''),
('Perina mačka', 1, 'pero', 'Mačka', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', '', ''),
('Perina patuljasta svinja', 1, 'pero', 'Patuljasta svinja', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', '', ''),
('Perin kunić', 1, 'pero', 'Kunić', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', '', ''),
('Perina činčila', 1, 'pero', 'Činčila', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', '', '');

INSERT INTO podsjetnik (korisnik_id, korisnicko_ime, naslov, ljubimac_ime, vrsta, datum, vrijeme, naputak)
VALUES (1, 'pero', 'Perin afrički tvor ide veterinaru', 'Perin afrički tvor', 'zdravlje', '2021-07-29', '13:30', 'ne kasniti'),
(1, 'pero', 'Voditi Perinu mačku u šetnju', 'Perina mačka', 'život', '2021-04-29', '07:00', '');

INSERT INTO objava (korisnik_id, sadrzaj, datum_objave) VALUES (1, 'Prva testna objava na forumu!',  TO_DATE('17/12/2016', 'DD/MM/YYYY'));
INSERT INTO komentar (korisnik_id, objava_id, sadrzaj, datum_komentara) VALUES (1, 1, 'Kakav igrac, kakav igrac!', TO_DATE('17/12/2016', 'DD/MM/YYYY'));
INSERT INTO komentar (korisnik_id, objava_id, sadrzaj, datum_komentara) VALUES (1, 1, 'Zapravo nemas pojma!', TO_DATE('17/12/2016', 'DD/MM/YYYY'));
