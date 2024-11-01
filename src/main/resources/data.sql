INSERT INTO author (name, image)
VALUES ('Victor Hugo', 'image_hugo.jpg');
INSERT INTO author (name, image)
VALUES ('Jules Verne', 'image_verne.jpg');
INSERT INTO author (name, image)
VALUES ('Émile Zola', 'image_zola.jpg');

INSERT INTO kind (name)
VALUES ('Roman');
INSERT INTO kind (name)
VALUES ('Science-Fiction');
INSERT INTO kind (name)
VALUES ('Aventure');
INSERT INTO kind (name)
VALUES ('Historique');

INSERT INTO book (title, description, image, isbn, author_id)
VALUES ('Les Misérables', 'Un roman historique sur la justice et la rédemption.', 'image_les_miserables.jpg',
        '9782070409123', 1),
       ('Notre-Dame de Paris', 'Une histoire d’amour tragique au cœur de Paris.', 'image_notre_dame.jpg',
        '9782070403305', 1),
       ('Voyage au centre de la Terre', 'Un voyage extraordinaire dans les profondeurs de la Terre.',
        'image_voyage.jpg', '9782070513288', 2),
       ('Vingt mille lieues sous les mers', 'Une exploration fascinante des océans avec le capitaine Nemo.',
        'image_20k_lieues.jpg', '9782070627305', 2),
       ('Germinal', 'Une critique puissante de la société industrielle.', 'image_germinal.jpg', '9782070408485', 3);

INSERT INTO kind_book (kind_id, book_id)
VALUES (1, 1);
INSERT INTO kind_book (kind_id, book_id)
VALUES (4, 1);

INSERT INTO kind_book (kind_id, book_id)
VALUES (1, 2);
INSERT INTO kind_book (kind_id, book_id)
VALUES (4, 2);

INSERT INTO kind_book (kind_id, book_id)
VALUES (2, 3);
INSERT INTO kind_book (kind_id, book_id)
VALUES (3, 3);

INSERT INTO kind_book (kind_id, book_id)
VALUES (2, 4);
INSERT INTO kind_book (kind_id, book_id)
VALUES (3, 4);

INSERT INTO kind_book (kind_id, book_id)
VALUES (1, 5);
INSERT INTO kind_book (kind_id, book_id)
VALUES (4, 5);
