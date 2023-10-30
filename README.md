# Central-ordering-system-for-hospitals


## Table of Contents
1. [Introduction](#introduction)
2. [Roles and Capabilities](#roles-and-capabilities)
3. [System Features](#system-features)
4. [Usage Instructions](#usage-instructions)
5. [Security and Privacy](#security-and-privacy)
6. [Contact Information](#contact-information)
7. [Technologies](#technologies)

## Introduction

The Central Ordering System for Hospitals is a software designed to streamline appointment scheduling and order management within hospitals. This system provides four distinct roles: Administrator, Doctor of General Medicine, Specialist Doctor, and Patient, each with specific capabilities and responsibilities within the system.

## Roles and Capabilities

1. **Administrator:**
   - Modify all items within the system, including user accounts, appointments, and orders.

2. **Doctor of General Medicine:**
   - Create patients.
   - Add, modify, and delete patient records and orders.
   - Schedule appointments for patients.

3. **Specialist Doctor:**
   - Modify orders.
   - Create additional controls for specific orders.
   - Send feedback to the Doctor of General Medicine and patients.

4. **Patient:**
   - Check their orders.
   - Request an appointment with a Doctor of General Medicine.

## System Features

- **User Authentication:**
  - Users need to log in using their credentials to access the system and perform tasks according to their roles.

- **Patient Management:**
  - Allows Doctor of General Medicine to create, modify, and delete patient records.
  - Allows patients to view their orders.

- **Order Management:**
  - Enables Doctor of General Medicine to add, modify, and delete orders.
  - Allows Specialist Doctors to modify orders and create additional controls.

- **Appointment Scheduling:**
  - Permits Doctor of General Medicine to schedule appointments for patients.

- **Feedback System:**
  - Allows Specialist Doctors to send feedback to Doctor of General Medicine and patients.

## Usage Instructions

1. **Login:**
   - Upon accessing the system, users will be prompted to log in using their designated credentials for their respective roles.

2. **Administrator:**
   - Use the administrative dashboard to modify any items within the system, including user accounts, appointments, and orders.

3. **Doctor of General Medicine:**
   - Access the patient management module to create, modify, or delete patient records.
   - Utilize the order management module to add, modify, or delete orders.
   - Schedule appointments for patients using the appointment scheduling feature.

4. **Specialist Doctor:**
   - Access the order management module to modify orders and create additional controls.
   - Utilize the feedback system to provide feedback to Doctor of General Medicine and patients.

5. **Patient:**
   - Access the system to view their orders and request an appointment with a Doctor of General Medicine.

## Database diagram
![sql server bolnica](https://github.com/OSS-Java-Seminar-2023/Central-ordering-system-for-hospitals/assets/146756296/0bb05d45-1d26-47a4-92a4-77243332abfc)

## Database SQL query
[Upload-- DoctorOfGeneralMedicine Table
USE [Bolnica_2]
GO

/****** Object:  Table [dbo].[DoctorOfGeneralMedicine]    Script Date: 29.10.2023. 20:32:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DoctorOfGeneralMedicine](
	[ID] [int] NOT NULL,
	[Addres] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DoctorOfGeneralMedicine] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
------------------------------------------
-- SpecialistDoctor Table
--USE [Bolnica_2]
--GO

/****** Object:  Table [dbo].[SpecialistDoctor]    Script Date: 29.10.2023. 20:33:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SpecialistDoctor](
	[ID] [int] NOT NULL,
	[Specialization] [nvarchar](50) NOT NULL,
	[Addres] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_SpecialistDoctor] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
-------------------------------------------
-- Patient Table
--USE [Bolnica_2]
--GO

/****** Object:  Table [dbo].[Patient]    Script Date: 29.10.2023. 20:35:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Patient](
	[ID] [int] NOT NULL,
	[InsuranceNumber] [nvarchar](50) NOT NULL,
	[Bill] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Patient] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
---------------------------------------------
-- Result Table
--USE [Bolnica_2]
--GO

/****** Object:  Table [dbo].[Result]    Script Date: 29.10.2023. 20:36:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Result](
	[ID] [int] NOT NULL,
	[Diagnosis] [nvarchar](100) NOT NULL,
	[Advice] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Result] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
-----------------------------------------------
-- User Table 
--USE [Bolnica_2]
--GO

/****** Object:  Table [dbo].[Users]    Script Date: 29.10.2023. 20:37:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Users](
	[UserID] [int] NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Surname] [nvarchar](50) NOT NULL,
	[Contact] [nvarchar](50) NOT NULL,
	[RoleID] [int] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_DoctorOfGeneralMedicine] FOREIGN KEY([RoleID])
REFERENCES [dbo].[DoctorOfGeneralMedicine] ([ID])
GO

ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_DoctorOfGeneralMedicine]
GO

ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Patient] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Patient] ([ID])
GO

ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Patient]
GO

ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_SpecialistDoctor] FOREIGN KEY([RoleID])
REFERENCES [dbo].[SpecialistDoctor] ([ID])
GO

ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_SpecialistDoctor]
GO
----------------------------------------------------------
-- Order Table
--USE [Bolnica_2]
--GO

/****** Object:  Table [dbo].[Order]    Script Date: 29.10.2023. 20:37:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Order](
	[OrderID] [int] NOT NULL,
	[DoctorOfGeneralMedicineID] [int] NOT NULL,
	[DoctorSpecialistID] [int] NOT NULL,
	[PatientID] [int] NOT NULL,
	[Date] [date] NOT NULL,
	[ResultID] [int] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Result] FOREIGN KEY([ResultID])
REFERENCES [dbo].[Result] ([ID])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Result]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Users] FOREIGN KEY([DoctorOfGeneralMedicineID])
REFERENCES [dbo].[Users] ([UserID])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Users]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Users1] FOREIGN KEY([DoctorSpecialistID])
REFERENCES [dbo].[Users] ([UserID])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Users1]
GO

ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Users2] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Users] ([UserID])
GO

ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Users2]
GOing SQL_kod_baze.sql…]()


## Security and Privacy

- The Central Ordering System employs robust security measures to ensure the confidentiality and integrity of the data.
- Access to the system is controlled through secure user authentication mechanisms.
- Patient data and medical records are handled in compliance with relevant privacy laws and regulations.

## Contact Information

For any inquiries, assistance, or feedback regarding the Central Ordering System for Hospitals, please contact the system administrator at the following email addresses:
- [maroancic@gmail.com](mailto:maroancic@gmail.com)
- [josip.dom98@gmail.com](mailto:josip.dom98@gmail.com)


##Technologies
![Java](https://camo.githubusercontent.com/65b616ed4448c46e59c11345a1d49a01adc6d51f9bd6e93ee61d29573e04c597/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f6a6176612f6a6176612d6f726967696e616c2d776f72646d61726b2e737667)![Spring](https://camo.githubusercontent.com/a8e2a5e36df66e1a1c36912287b4dbc5e72fa5d154ab191b7fc5c6e1f32fc8fd/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f737072696e672f737072696e672d6f726967696e616c2d776f72646d61726b2e737667)![IntelliJ](https://camo.githubusercontent.com/f0370f3415107d0e2c7a4d6ec5b3d8f09dce89d2d7f2ff235fef39c34f47d33f/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f696e74656c6c696a2f696e74656c6c696a2d6f726967696e616c2d776f72646d61726b2e737667)![HTML](https://camo.githubusercontent.com/984b2a88651f862c502e3881c6fa5d27f077948241fe49684a0879cae28014e2/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f68746d6c352f68746d6c352d6f726967696e616c2d776f72646d61726b2e737667)![css](https://camo.githubusercontent.com/7894f44095e8df88e2c12b0f2c91441ca66d029cf10ae3c068362bb9e68d3df9/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f637373332f637373332d6f726967696e616c2d776f72646d61726b2e737667)![js](https://camo.githubusercontent.com/442c452cb73752bb1914ce03fce2017056d651a2099696b8594ddf5ccc74825e/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f6a6176617363726970742f6a6176617363726970742d6f726967696e616c2e737667)![mySQL](https://camo.githubusercontent.com/ad7293939c16e73991b8d60763373b710bf9e96923595e8dd90fb7dee464e9ce/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f6d7973716c2f6d7973716c2d6f726967696e616c2d776f72646d61726b2e737667)![Docker](https://camo.githubusercontent.com/fc836983ed18b80caef906c8f1593bcfd4f5c8c587f51a911b1cb4d657a9588b/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f64657669636f6e732f64657669636f6e2f69636f6e732f646f636b65722f646f636b65722d6f726967696e616c2d776f72646d61726b2e737667)
