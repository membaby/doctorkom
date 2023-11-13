CREATE TABLE Account (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL
);

CREATE TABLE "User" (
    AccountId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255) ,
    LastName VARCHAR(255) ,
    Birthdate DATE ,
    Gender VARCHAR(10) ,
    Address VARCHAR(255) ,
    LandlinePhone VARCHAR(20),
    MobilePhone VARCHAR(20),
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE SystemAdmin (
    AccountId INT PRIMARY KEY AUTO_INCREMENT,
    -- Additional SystemAdmin-specific attributes can be added here
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE ClinicAdmin (
    AccountId INT PRIMARY KEY AUTO_INCREMENT,
    -- Additional ClinicAdmin-specific attributes can be added here
    FOREIGN KEY (AccountId) REFERENCES Account(Id)
);

CREATE TABLE Doctor (
    UserId INT PRIMARY KEY AUTO_INCREMENT,
    PatientCount INT,
    TotalRating INT,
    Rating DECIMAL(3, 2) GENERATED ALWAYS AS (
        CASE
            WHEN PatientCount > 0 THEN TotalRating / PatientCount
            ELSE 0
        END
    ),
    -- Additional Doctor-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES "User"(AccountId)
);

CREATE TABLE Patient (
    UserId INT PRIMARY KEY AUTO_INCREMENT,
    Insurance VARCHAR(255),
    MaritalStatus VARCHAR(20),
    Occupation VARCHAR(255),
    -- Additional Patient-specific attributes can be added here
    FOREIGN KEY (UserId) REFERENCES "User"(AccountId)
);