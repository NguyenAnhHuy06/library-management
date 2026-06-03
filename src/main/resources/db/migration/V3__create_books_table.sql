CREATE TABLE books (
                       book_id BIGSERIAL PRIMARY KEY,

                       category_id BIGINT NOT NULL,

                       title VARCHAR(200) NOT NULL,
                       author_name VARCHAR(100),
                       publisher_name VARCHAR(150),
                       isbn VARCHAR(50) UNIQUE,
                       publication_year INT,
                       description TEXT,

                       total_quantity INT NOT NULL DEFAULT 0,
                       available_quantity INT NOT NULL DEFAULT 0,

                       shelf_location VARCHAR(100),

                       status VARCHAR(30) NOT NULL DEFAULT 'AVAILABLE',

                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_books_category
                           FOREIGN KEY (category_id)
                               REFERENCES categories(category_id)
);