-- Guests
INSERT INTO guest (first_name, last_name, email, phone_number, passport) VALUES
('Alice', 'Smith', 'alice.smith@gmail.com', '555-123-4567', 'AB1234567'),
('Benjamin', 'Smith', 'ben.smith@gmail.com', '798-144-9812', 'AB1294567'),
('Bob', 'Johnson', 'bob.johnson@gmail.com', '097-987-6543', 'CD9876543'),
('Emily', 'Brown', 'emily.brown@gmail.com', '642-234-5678', 'EF2345678'),
('Michael', 'Davis', 'michael.davis@gmail.com', '423-876-5432', 'GH8765432'),
('Sarah', 'Wilson', 'sarah.wilson@gmail.com', '125-345-6789', 'IJ3456789'),
('David', 'Martinez', 'david.martinez@gmail.com', '095-432-1098', 'KL4321098'),
('Jennifer', 'Taylor', 'jennifer.taylor@gmail.com', '181-210-9876', 'MN2109876'),
('Christopher', 'Anderson', 'christopher.anderson@gmail.com', '963-876-5432', 'OP8765432'),
('Jessica', 'Thomas', 'jessica.thomas@gmail.com', '098-987-6543', 'QR9876543'),
('Matthew', 'Hernandez', 'matthew.hernandez@gmail.com', '465-654-3210', 'ST6543210');

-- Room types
INSERT INTO room_type (type_name, description)VALUES
('Single', 'Single room'),
('Double', 'Double room'),
('Deluxe', 'Deluxe room'),
('Suite', 'Suite room'),
('Penthouse', 'Penthouse room');

-- Rooms
INSERT INTO room (room_number, room_type_id, is_available, num_of_beds, price) VALUES
('101', 1, true, 1, 40),
('102', 1, false, 1, 50),
('103', 1, true, 1, 50),
('104', 1, true, 1, 50),
('105', 1, false, 1, 50),
('106', 1, true, 1, 70),
('201', 2, true, 2, 80),
('202', 2, true, 2, 90),
('203', 2, true, 2, 100),
('204', 2, true, 2, 100),
('205', 2, false, 2, 110),
('206', 2, false, 2, 120),
('207', 2, true, 2, 120),
('301', 3, true, 3, 200),
('302', 3, true, 2, 210),
('303', 3, true, 3, 220),
('304', 3, true, 3, 250),
('305', 3, false, 3, 250),
('306', 3, true, 3, 270),
('401', 4, true, 4, 300),
('402', 4, false, 4, 310),
('403', 4, true, 5, 320),
('404', 4, true, 5, 320),
('405', 4, true, 5, 320),
('406', 4, true, 5, 320),
('501', 5, true, 5, 400),
('502', 5, true, 6, 410);

-- Reservations
INSERT INTO rental (room_id, guest_id, check_in_date, check_out_date, total_price) VALUES
(2,2,'2024-03-29','2024-04-01',150.00),
(21,4,'2024-03-29','2024-04-06',2480.00),
(11,7,'2024-03-29','2024-03-31',220.00),
(18,6,'2024-03-29','2024-04-04',1500.00),
(12,9,'2024-03-27','2024-03-29',240.00),
(5,8,'2024-03-27','2024-03-29',100.00);