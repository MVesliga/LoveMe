INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
<<<<<<< HEAD
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', 'peropass');

INSERT INTO ljubimac (korisnik_id, ime, vrsta, dob, veterinar, cijepljen, obuka, hrana, igracka)
VALUES (1, 'Perin pas', 'pas', 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'da', 'ne', 'hrana', 'igracka'), (1, 'Perina macka', 'macka', 7, TO_DATE('17/12/2016', 'DD/MM/YYYY'), 'ne', 'ne', 'mjau', 'mjau');
=======
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', '$2y$12$tvFvkRFN0C//3MLED9YmQeGyiWoGJA55ytZax.85Kg1BEmO4R7MI2');

INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('pero', 'ROLE_USER');
>>>>>>> a94854e26047a2b195cdfa8baeed545d0e33fa5b
