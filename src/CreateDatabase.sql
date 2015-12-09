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
