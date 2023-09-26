INSERT INTO Clients (name, age, address, birthday, company)
VALUES
    ('John Doe', 30, '123 Main St', '1992-05-15', 'ABC Inc.'),
    ('Jane Smith', 25, '456 Elm St', '1997-02-20', 'XYZ Ltd.');

-- Insert dummy data into Cases table
INSERT INTO Cases (create_date, title, msg, client, status_enum, end_date)
VALUES
    ('2023-09-25 08:00:00', 'Sample Case 1', 'This is the first case', 1, 'COMPLETED', '2023-09-30 17:00:00'),
    ('2023-09-28 08:00:00', 'Sample Case 3', 'This is the third case', 1, 'IN_PROGRESS', NULL),
    ('2023-09-29 08:00:00', 'Sample Case 4', 'This is the 4th case', 1, 'IN_PROGRESS', NULL),
    ('2023-09-26 09:30:00', 'Sample Case 2', 'This is the second case', 2, 'IN_PROGRESS', NULL);