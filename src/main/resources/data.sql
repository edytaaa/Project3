INSERT INTO wspolnota (id, nazwa, adres) VALUES (1, 'Centrum1', 'ul. Centralna 10')
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (1, 7, 41)
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (1, 9, 57)
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (1, 11, 68)

INSERT INTO wspolnota (id, nazwa, adres) VALUES (2, 'Centrum2', 'ul. Centralna 11')
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (2, 12, 39)
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (2, 14, 72)
INSERT INTO mieszkanie(wspolnota_id, numer, powierzchnia) VALUES (2, 16, 54)

INSERT INTO mieszkaniec(mieszkanie_id, imie, nazwisko, plec) VALUES (1, 'Jan', 'Kowalski', 'Mężczyzna')
INSERT INTO mieszkaniec(mieszkanie_id, imie, nazwisko, plec) VALUES (1, 'Klara', 'Kowalska', 'Kobieta')
INSERT INTO mieszkaniec(mieszkanie_id, imie, nazwisko, plec) VALUES (4, 'Matylda', 'Nowak', 'Kobieta')
INSERT INTO mieszkaniec(mieszkanie_id, imie, nazwisko, plec) VALUES (4, 'Franciszek', 'Nowak', 'Mężczyzna')