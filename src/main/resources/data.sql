INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', 'peropass');

INSERT INTO ljubimac (korisnik_id, ime, vrsta, dob, veterinar, cijepljen, obuka, hrana, igracka)
VALUES (1, 'Perin pas', 'pas', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'da', 'ne', 'hrana', 'igracka'), (1, 'Perina macka', 'macka', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau');

INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('pero', 'ROLE_USER');
