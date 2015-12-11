USE [master]
GO

/****** Object:  Database [MovieRental]    Script Date: 12/11/2015 11:06:20 ******/
IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'MovieRental')
DROP DATABASE [MovieRental]
GO

USE [master]
GO

/****** Object:  Database [MovieRental]    Script Date: 12/11/2015 11:06:20 ******/
CREATE DATABASE [MovieRental] ON  PRIMARY 
( NAME = N'MovieRental', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\MovieRental.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MovieRental_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10.MSSQLSERVER\MSSQL\DATA\MovieRental_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [MovieRental] SET COMPATIBILITY_LEVEL = 100
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MovieRental].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [MovieRental] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [MovieRental] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [MovieRental] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [MovieRental] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [MovieRental] SET ARITHABORT OFF 
GO

ALTER DATABASE [MovieRental] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [MovieRental] SET AUTO_CREATE_STATISTICS ON 
GO

ALTER DATABASE [MovieRental] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [MovieRental] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [MovieRental] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [MovieRental] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [MovieRental] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [MovieRental] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [MovieRental] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [MovieRental] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [MovieRental] SET  DISABLE_BROKER 
GO

ALTER DATABASE [MovieRental] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [MovieRental] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [MovieRental] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [MovieRental] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [MovieRental] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [MovieRental] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [MovieRental] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [MovieRental] SET  READ_WRITE 
GO

ALTER DATABASE [MovieRental] SET RECOVERY FULL 
GO

ALTER DATABASE [MovieRental] SET  MULTI_USER 
GO

ALTER DATABASE [MovieRental] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [MovieRental] SET DB_CHAINING OFF 
GO


USE [MovieRental]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 12/11/2015 11:11:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Users] ([UserName], [Password]) VALUES (N'admin', N'admin')
/****** Object:  Table [dbo].[RentalHistory]    Script Date: 12/11/2015 11:11:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RentalHistory](
	[Customer_ID] [int] NULL,
	[Movie_ID] [int] NULL,
	[BorrowedDate] [date] NULL,
	[ReturnDate] [date] NULL,
	[ExpectedReturnDate] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movies]    Script Date: 12/11/2015 11:11:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Movies](
	[Movie_ID] [int] IDENTITY(1,1) NOT NULL,
	[MovieName] [varchar](100) NULL,
	[Genre] [varchar](100) NULL,
	[RentalPrice] [decimal](18, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Movies] ON
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (1, N'Only You', N'Drama', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (2, N'Longest Ride', N'Drama', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (3, N'True Lies', N'Action', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (4, N'Universal Soldier', N'Action', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (5, N'The Godfather', N'Action', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (6, N'Friends with Benefits', N'Comedy', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (7, N'Nothin Hill', N'Drama', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (8, N'My Bestfriends Wedding', N'Comedy', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (9, N'Charlie''s Angel', N'Action', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (10, N'Jurassic Park', N'Adventure', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (11, N'The Goonies', N'Adventure', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (12, N'The Mummy', N'Adventure', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (13, N'Tom Raider', N'Action', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (14, N'Kung Fu Panda', N'Animation', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (15, N'Inside Out', N'Animation', CAST(5 AS Decimal(18, 0)))
INSERT [dbo].[Movies] ([Movie_ID], [MovieName], [Genre], [RentalPrice]) VALUES (16, N'Brave', N'Animation', CAST(5 AS Decimal(18, 0)))
SET IDENTITY_INSERT [dbo].[Movies] OFF
/****** Object:  Table [dbo].[Customers]    Script Date: 12/11/2015 11:11:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customers](
	[Customer_ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Contact] [varchar](50) NULL,
	[Member] [tinyint] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Customers] ON
INSERT [dbo].[Customers] ([Customer_ID], [Name], [Contact], [Member]) VALUES (1, N'Mike Tan', N'896780', 0)
INSERT [dbo].[Customers] ([Customer_ID], [Name], [Contact], [Member]) VALUES (2, N'Mickey Mouse', N'0696677', 1)
INSERT [dbo].[Customers] ([Customer_ID], [Name], [Contact], [Member]) VALUES (3, N'Jackie Chan', N'577989', 0)
INSERT [dbo].[Customers] ([Customer_ID], [Name], [Contact], [Member]) VALUES (4, N'Mako Pah', N'347457', 1)
INSERT [dbo].[Customers] ([Customer_ID], [Name], [Contact], [Member]) VALUES (5, N'Titin Bit', N'547457', 0)
SET IDENTITY_INSERT [dbo].[Customers] OFF
