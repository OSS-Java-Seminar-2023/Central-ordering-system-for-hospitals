-- Username

CREATE TABLE username (
                          id VARCHAR(255) PRIMARY KEY AUTO_INCREMENT,
                          username VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          email varchar(255) NOT NULL
);



-- DoctorOfGeneralMedicine Table
CREATE TABLE DoctorOfGeneralMedicine (
                                         ID VARCHAR(255) NOT NULL,
                                         Address VARCHAR(50) NOT NULL,
                                         PRIMARY KEY (ID)
);

-- SpecialistDoctor Table
CREATE TABLE SpecialistDoctor (
                                  ID VARCHAR(255) NOT NULL,
                                  Specialization VARCHAR(50) NOT NULL,
                                  Address VARCHAR(50) NOT NULL,
                                  PRIMARY KEY (ID)
);

-- Patient Table
CREATE TABLE Patient (
                         ID VARCHAR(255) NOT NULL,
                         InsuranceNumber VARCHAR(50) NOT NULL,
                         Bill VARCHAR(50) NOT NULL,
                         PRIMARY KEY (ID)
);

-- Result Table
CREATE TABLE Result (
                        ID VARCHAR(255) NOT NULL,
                        Diagnosis VARCHAR(100) NOT NULL,
                        Advice VARCHAR(100) NOT NULL,
                        PRIMARY KEY (ID)
);

-- User Table
CREATE TABLE User(
                     ID VARCHAR(255) NOT NULL,
                     Name VARCHAR(50) NOT NULL,
                     Surname VARCHAR(50) NOT NULL,
                     Contact VARCHAR(50) NOT NULL,
                     DoctorOfGeneralMedicine INT NOT NULL ,
                     Patient INT NOT NULL ,
                     Specialist INT NOT NULL ,
                     Username INT NOT NULL ,


                     PRIMARY KEY (ID),
                     CONSTRAINT FK_User_DoctorOfGeneralMedicine FOREIGN KEY (DoctorOfGeneralMedicine) REFERENCES DoctorOfGeneralMedicine(ID),
                     CONSTRAINT FK_User_Patient FOREIGN KEY (Patient) REFERENCES Patient(ID),
                     CONSTRAINT FK_User_SpecialistDoctor FOREIGN KEY (Specialist) REFERENCES SpecialistDoctor(ID),
                     CONSTRAINT FK_User_Username FOREIGN KEY (username) REFERENCES username(ID)
);

-- Order Table
CREATE TABLE `order`(
                        ID VARCHAR(255) NOT NULL,
                        DoctorOfGeneralMedicineID INT NOT NULL,
                        DoctorSpecialistID INT NOT NULL,
                        PatientID INT NOT NULL,
                        Date DATE NOT NULL,
                        ResultID INT NOT NULL,
                        PRIMARY KEY (ID),
                        CONSTRAINT FK_Order_Result FOREIGN KEY (ResultID) REFERENCES Result(ID),
                        CONSTRAINT FK_Order_User FOREIGN KEY (DoctorOfGeneralMedicineID) REFERENCES User(ID),
                        CONSTRAaINT FK_Order_Users1 FOREIGN KEY (DoctorSpecialistID) REFERENCES User(ID),
                        CONSTRAINT FK_Order_Users2 FOREIGN KEY (PatientID) REFERENCES User(ID)
);

-- Unique Constraints
ALTER TABLE DoctorOfGeneralMedicine ADD CONSTRAINT UNQ_DoctorOfGeneralMedicine_RoleID UNIQUE (ID);
ALTER TABLE SpecialistDoctor ADD CONSTRAINT UNQ_SpecialistDoctor_RoleID UNIQUE (ID);
ALTER TABLE Patient ADD CONSTRAINT UNQ_Patient_RoleID UNIQUE (ID);
