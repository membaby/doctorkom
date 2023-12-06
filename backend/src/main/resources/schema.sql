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
      CreationTime DATETIME NOT NULL,
      FOREIGN KEY (AccountId) REFERENCES Account(Id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- SET GLOBAL event_scheduler = ON;
--
-- DELIMITER //
-- CREATE PROCEDURE removeUnusedVerifications()
--     BEGIN
--         DECLARE LifeTime DATETIME;
--
--         SET LifeTime = NOW() - INTERVAL 6 HOUR;
--
--         START TRANSACTION;
--         BEGIN
--             DELETE FROM Account
--             WHERE Id IN (SELECT AccountId FROM Verification WHERE CreationTime < LifeTime);
--         END;
--
--         BEGIN
--             DELETE FROM Verification WHERE CreationTime < LifeTime;
--         END;
--         COMMIT;
--     END //
-- DELIMITER ;
--
-- CREATE EVENT removeUnusedVerificationsEvent
-- ON SCHEDULE EVERY 1 MINUTE
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
    AdminId INT PRIMARY KEY,
    Name VARCHAR(50) UNIQUE NOT NULL,
    Email VARCHAR(50) UNIQUE NOT NULL,
    Address VARCHAR(250) UNIQUE NOT NULL,
    Landline VARCHAR(20) UNIQUE NOT NULL,
    Phone VARCHAR(20) UNIQUE NOT NULL,
    FOREIGN KEY (AdminId) REFERENCES ClinicAdmin(AccountId)
)
