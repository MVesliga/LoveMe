INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Pero', 'Peric', '1997-07-29', 'pero@mail.com', 'pero', '$2y$12$tvFvkRFN0C//3MLED9YmQeGyiWoGJA55ytZax.85Kg1BEmO4R7MI2');
INSERT INTO korisnik (ime, prezime, datum_rodjenja, email, korisnicko_ime, lozinka)
VALUES ('Administrator', 'Admin', '1997-07-29', 'admin@mail.com', 'admin', '$2y$12$YQs3yNmEIbBQCyrRG2CgBeZ3B2PYekj680etsbYenhNtSrmXZJg0S');

INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('pero', 'ROLE_USER');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('admin', 'ROLE_USER');
INSERT INTO korisnik_uloga (korisnicko_ime, uloga) VALUES ('admin', 'ROLE_ADMIN');
