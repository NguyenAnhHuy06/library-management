CREATE TABLE borrow_tickets (
                                ticket_id BIGSERIAL PRIMARY KEY,

                                reader_id BIGINT NOT NULL,
                                librarian_id BIGINT,

                                borrow_date DATE NOT NULL,
                                due_date DATE NOT NULL,

                                status VARCHAR(30) NOT NULL DEFAULT 'BORROWING',
                                note VARCHAR(255),

                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                CONSTRAINT fk_borrow_tickets_reader
                                    FOREIGN KEY (reader_id)
                                        REFERENCES users(user_id),

                                CONSTRAINT fk_borrow_tickets_librarian
                                    FOREIGN KEY (librarian_id)
                                        REFERENCES users(user_id)
);