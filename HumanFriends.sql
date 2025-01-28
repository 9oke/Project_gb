USE HumanFriends;

CREATE TABLE Pets (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(50),
    BirthDate DATE,
    Commands TEXT
);

CREATE TABLE PackAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(50),
    BirthDate DATE,
    Commands TEXT
);

INSERT INTO Pets (Name, Type, BirthDate, Commands) VALUES
('Fido', 'Dog', '2020-01-01', 'Sit, Stay, Fetch'),
('Whiskers', 'Cat', '2019-05-15', 'Sit, Pounce'),
('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide');

 INSERT INTO PackAnimals (Name, Type, BirthDate, Commands) VALUES
('Thunder', 'Horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Sandy', 'Camel', '2016-11-03', 'Walk, Carry Load'),
('Eeyore', 'Donkey', '2017-09-18', 'Walk, Carry Load, Bray');

SELECT * FROM Pets;
SELECT * FROM PackAnimals;

DELETE FROM PackAnimals WHERE Type = 'Camel';

CREATE TABLE Combined AS
SELECT * FROM PackAnimals WHERE Type IN ('Horse', 'Donkey');

CREATE TABLE YoungAnimals AS
SELECT *, TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeInMonths
FROM Pets
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;

CREATE TABLE AllAnimals AS
SELECT * FROM Pets
UNION
SELECT * FROM PackAnimals
UNION
SELECT * FROM Combined;
