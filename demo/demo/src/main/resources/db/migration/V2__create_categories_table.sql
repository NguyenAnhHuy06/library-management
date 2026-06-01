CREATE TABLE categories (
                            category_id BIGSERIAL PRIMARY KEY,

                            category_name VARCHAR(100) NOT NULL UNIQUE,
                            description VARCHAR(255),

                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);