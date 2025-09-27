-- Seed data for users table
-- Insert 10 realistic users with diverse data

INSERT INTO users (name, email, password, address, city, state, country, postal_code, phone, date_of_birth, status,
                   last_login)
VALUES ('John Smith', 'john.smith@email.com', '$2a$10$N9qo8uLOickgx2ZMRZoMye', '123 Main Street', 'New York', 'NY',
        'USA', '10001', '+1-555-0101', '1985-03-15', 'ACTIVE', '2025-09-22 14:30:00'),

       ('Emily Johnson', 'emily.johnson@gmail.com', '$2a$10$K7sRtL8wVxJ9YqM4NpQwOe', '456 Oak Avenue', 'Los Angeles',
        'CA', 'USA', '90210', '+1-555-0102', '1990-07-22', 'ACTIVE', '2025-09-23 09:15:00'),

       ('Michael Brown', 'michael.brown@company.com', '$2a$10$P5nQvW2xZ8L6MrS3OpRtUi', '789 Pine Road', 'Chicago', 'IL',
        'USA', '60601', '+1-555-0103', '1988-11-08', 'ACTIVE', '2025-09-21 16:45:00'),

       ('Sarah Davis', 'sarah.davis@outlook.com', '$2a$10$T9mKvX4yC1N7QsP6LrWzVo', '321 Elm Street', 'Houston', 'TX',
        'USA', '77001', '+1-555-0104', '1992-02-14', 'ACTIVE', '2025-09-23 11:20:00'),

       ('David Wilson', 'david.wilson@yahoo.com', '$2a$10$R8lJuY3xB2M8TqO5KsVyWn', '654 Maple Lane', 'Phoenix', 'AZ',
        'USA', '85001', '+1-555-0105', '1983-09-30', 'INACTIVE', '2025-09-18 13:10:00'),

       ('Jessica Garcia', 'jessica.garcia@hotmail.com', '$2a$10$U6hGtV2wA9K5PnL4JrXzTo', '987 Cedar Drive',
        'Philadelphia', 'PA', 'USA', '19101', '+1-555-0106', '1987-12-03', 'ACTIVE', '2025-09-22 10:35:00'),

       ('Robert Martinez', 'robert.martinez@email.net', '$2a$10$S7fEsW1vC8J4QmN3IqYxUm', '147 Birch Court',
        'San Antonio', 'TX', 'USA', '78201', '+1-555-0107', '1979-05-18', 'ACTIVE', '2025-09-23 08:50:00'),

       ('Amanda Taylor', 'amanda.taylor@domain.com', '$2a$10$V4dCrZ8xF7L2RoP9MtBwYl', '258 Spruce Street', 'San Diego',
        'CA', 'USA', '92101', '+1-555-0108', '1994-01-25', 'ACTIVE', '2025-09-22 15:25:00'),

       ('Christopher Lee', 'chris.lee@tech.io', '$2a$10$W3bArY7wE6K9TnM2LsVxZk', '369 Willow Avenue', 'Dallas', 'TX',
        'USA', '75201', '+1-555-0109', '1986-08-12', 'ACTIVE', '2025-09-23 12:40:00'),

       ('Michelle White', 'michelle.white@startup.com', '$2a$10$X2aFqX6vD5J8SmO4NrWyZj', '741 Poplar Road', 'San Jose',
        'CA', 'USA', '95101', '+1-555-0110', '1991-04-07', 'ACTIVE', '2025-09-21 17:55:00');
