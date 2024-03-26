-- Guests
INSERT INTO guest (first_name, last_name, email, phone_number, passport) VALUES
('Alice', 'Smith', 'alice.smith@example.com', '555-123-4567', 'AB1234567'),
('Bob', 'Johnson', 'bob.johnson@example.com', '555-987-6543', 'CD9876543'),
('Emily', 'Brown', 'emily.brown@example.com', '555-234-5678', 'EF2345678'),
('Michael', 'Davis', 'michael.davis@example.com', '555-876-5432', 'GH8765432'),
('Sarah', 'Wilson', 'sarah.wilson@example.com', '555-345-6789', 'IJ3456789'),
('David', 'Martinez', 'david.martinez@example.com', '555-432-1098', 'KL4321098'),
('Jennifer', 'Taylor', 'jennifer.taylor@example.com', '555-210-9876', 'MN2109876'),
('Christopher', 'Anderson', 'christopher.anderson@example.com', '555-876-5432', 'OP8765432'),
('Jessica', 'Thomas', 'jessica.thomas@example.com', '555-987-6543', 'QR9876543'),
('Matthew', 'Hernandez', 'matthew.hernandez@example.com', '555-654-3210', 'ST6543210');

-- Room types
INSERT INTO room_type (type, description)VALUES
('Single', 'Single room'),
('Double', 'Double room'),
('Deluxe', 'Deluxe room'),
('Suite', 'Suite room'),
('Penthouse', 'Penthouse room');

-- Rooms
INSERT INTO room (room_number, room_type_id, is_available, num_of_beds, price) VALUES
('101', 1, false, 1, 40),
('102', 1, false, 1, 50),
('201', 2, false, 2, 80),
('202', 2, true, 2, 90),
('203', 2, true, 2, 100),
('301', 3, true, 3, 200),
('302', 3, true, 2, 210),
('303', 3, true, 3, 220),
('401', 4, true, 4, 300),
('402', 4, true, 4, 310),
('403', 4, true, 5, 320),
('501', 5, true, 5, 400),
('502', 5, true, 6, 410);

-- Reservations
INSERT INTO rental (room_id, guest_id, check_in_date, check_out_date, total_price) VALUES
(1, 1, '2024-03-25', '2024-03-30', 200),
(2, 2, '2024-03-20', '2024-03-30', 500),
(3, 3, '2024-03-25', '2024-04-01', 560);
-- (4, 4, '2021-01-01', '2021-01-05', 450),
-- (5, 5, '2021-01-01', '2021-01-05', 500),
-- (6, 6, '2021-01-01', '2021-01-05', 1000),
-- (7, 7, '2021-01-01', '2021-01-05', 600),
-- (8, 8, '2021-01-01', '2021-01-05', 630),
-- (9, 9, '2021-01-01', '2021-01-05', 800),
-- (10, 10, '2021-01-01', '2021-01-05', 820);

