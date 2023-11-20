-- DoctorOfGeneralMedicine Table
CREATE TABLE hospital.DoctorOfGeneralMedicine (
                                                  ID INT NOT NULL,
                                                  Address NVARCHAR(50) NOT NULL,
                                                  PRIMARY KEY (ID)
);

-- SpecialistDoctor Table
CREATE TABLE hospital.SpecialistDoctor (
                                           ID INT NOT NULL,
                                           Specialization NVARCHAR(50) NOT NULL,
                                           Address NVARCHAR(50) NOT NULL,
                                           PRIMARY KEY (ID)
);

-- Patient Table
CREATE TABLE hospital.Patient (
                                  ID INT NOT NULL,
                                  InsuranceNumber NVARCHAR(50) NOT NULL,
                                  Bill NVARCHAR(50) NOT NULL,
                                  PRIMARY KEY (ID)
);

-- Result Table
CREATE TABLE hospital.Result (
                                 ID INT NOT NULL,
                                 Diagnosis NVARCHAR(100) NOT NULL,
                                 Advice NVARCHAR(100) NOT NULL,
                                 PRIMARY KEY (ID)
);

-- User Table
CREATE TABLE hospital.Users (
                                UserID INT NOT NULL,
                                Name NVARCHAR(50) NOT NULL,
                                Surname NVARCHAR(50) NOT NULL,
                                Contact NVARCHAR(50) NOT NULL,
                                RoleID INT NOT NULL,
                                PRIMARY KEY (UserID),
                                CONSTRAINT FK_Users_DoctorOfGeneralMedicine FOREIGN KEY (RoleID) REFERENCES DoctorOfGeneralMedicine(ID),
                                CONSTRAINT FK_Users_Patient FOREIGN KEY (RoleID) REFERENCES Patient(ID),
                                CONSTRAINT FK_Users_SpecialistDoctor FOREIGN KEY (RoleID) REFERENCES SpecialistDoctor(ID)
);

-- Order Table
CREATE TABLE hospital.Order (
                                OrderID INT NOT NULL,
                                DoctorOfGeneralMedicineID INT NOT NULL,
                                DoctorSpecialistID INT NOT NULL,
                                PatientID INT NOT NULL,
                                Date DATE NOT NULL,
                                ResultID INT NOT NULL,
                                PRIMARY KEY (OrderID),
                                CONSTRAINT FK_Order_Result FOREIGN KEY (ResultID) REFERENCES Result(ID),
                                CONSTRAINT FK_Order_Users FOREIGN KEY (DoctorOfGeneralMedicineID) REFERENCES Users(UserID),
                                CONSTRAINT FK_Order_Users1 FOREIGN KEY (DoctorSpecialistID) REFERENCES Users(UserID),
                                CONSTRAINT FK_Order_Users2 FOREIGN KEY (PatientID) REFERENCES Users(UserID)
);

-- Unique Constraints
ALTER TABLE hospital.DoctorOfGeneralMedicine ADD CONSTRAINT UNQ_DoctorOfGeneralMedicine_RoleID UNIQUE (ID);
ALTER TABLE hospital.SpecialistDoctor ADD CONSTRAINT UNQ_SpecialistDoctor_RoleID UNIQUE (ID);
ALTER TABLE hospital.Patient ADD CONSTRAINT UNQ_Patient_RoleID UNIQUE (ID);