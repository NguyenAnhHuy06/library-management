CREATE TABLE publishers (
                            publisher_id SERIAL PRIMARY KEY,

                            publisher_name VARCHAR(150) NOT NULL UNIQUE,
                            email VARCHAR(100),
                            phone VARCHAR(20),
                            address VARCHAR(255),

                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);