-- Drop the users table if it exists
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  mobile_number VARCHAR(10) NOT NULL
);

INSERT INTO users (first_name, last_name, username, email, mobile_number) VALUES
('John', 'Smith', 'johnsmith123', 'john.smith@example.com', '1234567890'),
('Alice', 'Johnson', 'alice.johnson', 'alice.johnson@example.com', '9876543210'),
('Michael', 'Williams', 'michael.will', 'michael.will@example.com', '5558889999'),
('Emma', 'Brown', 'emma_b', 'emma.brown@example.com', '1112223333'),
('Robert', 'Jones', 'r.jones', 'robert.jones@example.com', '4445556666'),
('Sophia', 'Garcia', 'sophia', 'sophia.garcia@example.com', '7778889999'),
('William', 'Miller', 'will.miller', 'william.miller@example.com', '9998887777'),
('Olivia', 'Davis', 'olivia_d', 'olivia.davis@example.com', '6665554444'),
('David', 'Martinez', 'david123', 'david.martinez@example.com', '1231231234'),
('Alex', 'Wilson', 'wilson_alex', 'alex.wilson@example.com', '9876549876'),
('Sophie', 'Lee', 'sophie_l', 'sophie.lee@example.com', '2345678901'),
('James', 'Taylor', 'james_t', 'james.taylor@example.com', '8901234567'),
('Emily', 'Anderson', 'emily_a', 'emily.anderson@example.com', '7654321098'),
('Daniel', 'White', 'daniel.white', 'daniel.white@example.com', '1119992222'),
('Grace', 'Harris', 'grace_h', 'grace.harris@example.com', '4449996666'),
('Liam', 'Martin', 'liam.martin', 'liam.martin@example.com', '7772225555'),
('Mia', 'Thompson', 'mia_t', 'mia.thompson@example.com', '9991113333'),
('Jacob', 'Garcia', 'jacobg', 'jacob.garcia@example.com', '6543210987'),
('Charlotte', 'Thomas', 'char_thomas', 'charlotte.thomas@example.com', '7773331111'),
('Ava', 'Rodriguez', 'ava_r', 'ava.rodriguez@example.com', '6549873210');
