ALTER TABLE books
    ADD COLUMN publisher_id INTEGER;

ALTER TABLE books
    ADD CONSTRAINT fk_book_publisher
        FOREIGN KEY (publisher_id)
            REFERENCES publishers(publisher_id);