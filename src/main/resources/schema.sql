CREATE TABLE author (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255),
                        image VARCHAR(255)
);

CREATE TABLE kind (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255)
);

CREATE TABLE book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      description TEXT,
                      image VARCHAR(255),
                      isbn VARCHAR(13) UNIQUE,
                      author_id BIGINT,
                      FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE kind_book (
                           kind_id BIGINT,
                           book_id BIGINT,
                           PRIMARY KEY (kind_id, book_id),
                           FOREIGN KEY (kind_id) REFERENCES kind(id),
                           FOREIGN KEY (book_id) REFERENCES book(id)
);
