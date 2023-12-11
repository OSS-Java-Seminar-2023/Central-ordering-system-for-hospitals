


-- DoctorOfGeneralMedicine Table
CREATE TABLE DoctorOfGeneralMedicine (
                                         ID INT NOT NULL,
                                         Address VARCHAR(50) NOT NULL,
                                         PRIMARY KEY (ID)
);

-- SpecialistDoctor Table
CREATE TABLE SpecialistDoctor (
                                  ID INT NOT NULL,
                                  Specialization VARCHAR(50) NOT NULL,
                                  Address VARCHAR(50) NOT NULL,
                                  PRIMARY KEY (ID)
);

-- Patient Table
CREATE TABLE Patient (
                         ID INT NOT NULL,
                         InsuranceNumber VARCHAR(50) NOT NULL,
                         Bill VARCHAR(50) NOT NULL,
                         PRIMARY KEY (ID)
);

-- Result Table
CREATE TABLE Result (
                        ID INT NOT NULL,
                        Diagnosis VARCHAR(100) NOT NULL,
                        Advice VARCHAR(100) NOT NULL,
                        PRIMARY KEY (ID)
);

-- User Table
CREATE TABLE Users (
                       UserId INT NOT NULL,
                       Name VARCHAR(50) NOT NULL,
                       Surname VARCHAR(50) NOT NULL,
                       Contact VARCHAR(50) NOT NULL,
                       DoctorOfGeneralMedicine INT NOT NULL ,
                       Patient INT NOT NULL ,
                       Specialist INT NOT NULL ,


                       PRIMARY KEY (UserID),
                       CONSTRAINT FK_Users_DoctorOfGeneralMedicine FOREIGN KEY (DoctorOfGeneralMedicine) REFERENCES DoctorOfGeneralMedicine(ID),
                       CONSTRAINT FK_Users_Patient FOREIGN KEY (Patient) REFERENCES Patient(ID),
                       CONSTRAINT FK_Users_SpecialistDoctor FOREIGN KEY (Specialist) REFERENCES SpecialistDoctor(ID)
);

-- Order Table
CREATE TABLE Orders (
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
ALTER TABLE DoctorOfGeneralMedicine ADD CONSTRAINT UNQ_DoctorOfGeneralMedicine_RoleID UNIQUE (ID);
ALTER TABLE SpecialistDoctor ADD CONSTRAINT UNQ_SpecialistDoctor_RoleID UNIQUE (ID);
ALTER TABLE Patient ADD CONSTRAINT UNQ_Patient_RoleID UNIQUE (ID);