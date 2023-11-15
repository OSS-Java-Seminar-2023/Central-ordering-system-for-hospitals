-- DoctorOfGeneralMedicine Table
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
GO

ALTER TABLE [dbo].[DoctorOfGeneralMedicine]
ADD CONSTRAINT [UNQ_DoctorOfGeneralMedicine_RoleID] UNIQUE ([ID]);

ALTER TABLE [dbo].[SpecialistDoctor]
ADD CONSTRAINT [UNQ_SpecialistDoctor_RoleID] UNIQUE ([ID]);

ALTER TABLE [dbo].[Patient]
ADD CONSTRAINT [UNQ_Patient_RoleID] UNIQUE ([ID]);
GO
