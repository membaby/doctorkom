CREATE TABLE Account (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Email VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Role VARCHAR(20) NOT NULL
);

CREATE TABLE SystemUser (
    AccountId INT PRIMARY KEY,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(20) NOT NULL,
    Birthdate DATE NOT NULL,
    Gender VARCHAR(10) NOT NULL,
    Address VARCHAR(255) NOT NULL,
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
    TotalRating INT,
    Rating DECIMAL(3, 2) GENERATED ALWAYS AS (
        CASE
            WHEN PatientCount > 0 THEN TotalRating / PatientCount
            ELSE 0
        END
    ),
    -- Additional Doctor-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES SystemUser(AccountId)
);

CREATE TABLE Patient (
    UserId INT PRIMARY KEY,
    Insurance VARCHAR(255),
    MaritalStatus VARCHAR(10),
    Occupation VARCHAR(255),
    -- Additional Patient-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES SystemUser(AccountId)
);