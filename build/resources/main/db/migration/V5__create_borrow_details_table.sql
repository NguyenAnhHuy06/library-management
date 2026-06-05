CREATE TABLE borrow_details (
                                borrow_detail_id BIGSERIAL PRIMARY KEY,

                                ticket_id BIGINT NOT NULL,
                                book_id BIGINT NOT NULL,

                                quantity INT NOT NULL DEFAULT 1,

                                return_date DATE,

                                status VARCHAR(30) NOT NULL DEFAULT 'BORROWING',

                                fine_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
                                fine_reason VARCHAR(255),

                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                                CONSTRAINT fk_borrow_details_ticket
                                    FOREIGN KEY (ticket_id)
                                        REFERENCES borrow_tickets(ticket_id),

                                CONSTRAINT fk_borrow_details_book
                                    FOREIGN KEY (book_id)
                                        REFERENCES books(book_id)
);