USE [master]
GO

/****** Object:  Database [MovieRental]    Script Date: 12/10/2015 11:59:23 ******/
IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'MovieRental')
DROP DATABASE [MovieRental]
GO

USE [master]
GO

/****** Object:  Database [MovieRental]    Script Date: 12/10/2015 11:59:23 ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 12/09/2015 13:37:27 ******/
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