CREATE TABLE Account (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Email VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(68) NOT NULL,
    Role VARCHAR(20) NOT NULL,
    Enabled TINYINT
);

CREATE TABLE Verification (
      AccountId INT PRIMARY KEY,
      Code VARCHAR(6) NOT NULL,
      ExpirationTime DATETIME NOT NULL,
      FOREIGN KEY (AccountId) REFERENCES Account(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- SET GLOBAL event_scheduler = ON;
--
-- DELIMITER //
-- CREATE PROCEDURE removeUnusedVerifications()
--     BEGIN
--         START TRANSACTION;
--         BEGIN
--             DELETE FROM Account
--             WHERE Id IN (SELECT AccountId FROM Verification WHERE ExpirationTime < NOW());
--         END;
--
--         BEGIN
--             DELETE FROM Verification WHERE ExpirationTime < NOW();
--         END;
--         COMMIT;
--     END //
-- DELIMITER ;
--
-- CREATE EVENT removeUnusedVerificationsEvent
-- ON SCHEDULE EVERY 1 HOUR
-- DO
-- CALL removeUnusedVerifications();
--
-- SHOW EVENTS;

CREATE TABLE SystemUser (
    AccountId INT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    Birthdate DATE NOT NULL,
    Gender VARCHAR(10) NOT NULL,
    Address VARCHAR(250) NOT NULL,
    LandlinePhone VARCHAR(20),
    MobilePhone VARCHAR(20) UNIQUE,
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE SystemAdmin (
    AccountId INT PRIMARY KEY,
    -- Additional SystemAdmin-specific attributes can be added here
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE ClinicAdmin (
    AccountId INT PRIMARY KEY,
    -- Additional ClinicAdmin-specific attributes can be added here
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE Doctor (
    UserId INT PRIMARY KEY,
    Title VARCHAR(20) NOT NULL,
    Specialty VARCHAR(30) NOT NULL,
    PatientCount INT,
    -- TotalRating INT,
    -- Rating DECIMAL(3, 2) GENERATED ALWAYS AS (
    --            CASE
    --                WHEN PatientCount > 0 THEN TotalRating / PatientCount
    --                ELSE 0
    --                END
    --            ),
    -- Additional Doctor-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES SystemUser(AccountId)
);

CREATE TABLE Patient (
    UserId INT PRIMARY KEY,
    Insurance VARCHAR(250),
    MaritalStatus VARCHAR(10),
    Occupation VARCHAR(250),
    -- Additional Patient-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES SystemUser(AccountId)
);

CREATE TABLE Clinic (
    ClinicId INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Address VARCHAR(250) NOT NULL,
    LandlinePhone VARCHAR(20) NOT NULL,
    MobilePhone VARCHAR(20) NOT NULL,
    FOREIGN KEY (ClinicId) REFERENCES ClinicAdmin(AccountId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE MedicalNote (
     DoctorId INT,
     PatientId INT,
     Date DATE,
     Diagnosis VARCHAR(255),
     Investigations VARCHAR(511),
     Prescription VARCHAR(255),
     PRIMARY KEY (DoctorId, PatientId, Date),
     FOREIGN KEY (DoctorId) REFERENCES Doctor(UserId),
     FOREIGN KEY (PatientId) REFERENCES Patient(UserId)
);

CREATE TABLE WorksFor (
      DoctorId INT,
      ClinicId INT,
      fees DOUBLE NOT NULL,
      PRIMARY KEY (DoctorId, ClinicId),
      FOREIGN KEY (DoctorId) REFERENCES Doctor(UserId),
      FOREIGN KEY (ClinicId) REFERENCES Clinic(ClinicId)
);

CREATE TABLE TimeSlot (
      DoctorId INT,
      ClinicId INT,
      date DATE,
--       weekday VARCHAR(20) GENERATED ALWAYS AS (UPPER(DATE_FORMAT(date, '%W'))) VIRTUAL,
      PRIMARY KEY (DoctorId, ClinicId, Date),
      FOREIGN KEY (DoctorId) REFERENCES Doctor(UserId),
      FOREIGN KEY (ClinicId) REFERENCES Clinic(ClinicId)
);
