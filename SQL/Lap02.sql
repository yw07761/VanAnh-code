-- Hồ Hoàng Vân Anh
-- 20098521
-- tuần 2&3
-- Bài tập 1:
-- Câu 3:
-- a)
CREATE DATABASE QUANLY_BANHANG
GO
USE QUANLY_BANHANG
GO
CREATE TABLE NHOMSANPHAM
(
	MaNhom INT PRIMARY KEY,
	TenNhom NVARCHAR(15),
	)
GO
CREATE TABLE NHACUNGCAP
(
	MaNCC INT PRIMARY KEY,
	TenNCC NVARCHAR(50) NOT NULL,
	DiaChi NVARCHAR(50),
	Phone VARCHAR(24),
	SoFax VARCHAR(24),
	DCMail VARCHAR(50)
)
GO
CREATE TABLE SANPHAM
(
	MaSP INT PRIMARY KEY,
	TenSP NVARCHAR(50) NOT NULL,
	MoTa NVARCHAR(50),
	DonViTinh NVARCHAR(20),
	DonGia MONEY CHECK (DonGia > 0),
	SLTon INT CHECK (SLTon > 0),
	MaNCC INT,
	MaNhom INT
)
GO
CREATE TABLE KHACHHANG
(
	MaKH CHAR(5) NOT NULL,
	TenKH NVARCHAR(50) NOT NULL,
	LoaiKH NVARCHAR(3) CHECK (LoaiKH IN ('VIP', 'TV', 'VL')),
	DiaChi NVARCHAR(50),
	Phone VARCHAR(24),
	SoFax VARCHAR(24),
	DCMail VARCHAR(50),
	DiemTL INT CHECK (DiemTL >= 0)
)
GO
CREATE TABLE CT_HOADON
(
	MaHD INT NOT NULL,
	SoLuong INT CHECK (SoLuong > 0),
	DonGia MONEY,
	ChietKhau MONEY CHECK (ChietKhau > 0),
	MaSP INT NOT NULL
)
GO
CREATE TABLE HOADON
(
	MaHD INT NOT NULL,
	NgayLapHD DATETIME CHECK (NgayLapHD >=GETDATE()),
	NgayGiao DATETIME,
	NoiChuyen NVARCHAR(50) NOT NULL,
	MaKH CHAR(5)
)
GO
-- b)
ALTER TABLE KHACHHANG
ADD PRIMARY KEY (MaKH)
GO
ALTER TABLE HOADON
ADD PRIMARY KEY (MaHD)
GO
ALTER TABLE CT_HOADON
ADD PRIMARY KEY (MaHD)
GO
-- c)
-- FK_ten : Tên của ràng buộc khóa ngoại muốn tạo.
ALTER TABLE HOADON
ADD FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH)
GO
ALTER TABLE HOADON
ADD FOREIGN KEY (MaHD) REFERENCES CT_HOADON(MaHD)
GO
ALTER TABLE CT_HOADON
ADD CONSTRAINT FK_CT_SP FOREIGN KEY (MaSP) REFERENCES SANPHAM(MaSP)
GO
ALTER TABLE SANPHAM
ADD CONSTRAINT FK_NCC FOREIGN KEY (MaNCC) REFERENCES NHACUNGCAP(MaNCC)
GO
ALTER TABLE SANPHAM
ADD CONSTRAINT FK_NHOMSP FOREIGN KEY (MaNhom) REFERENCES NHOMSANPHAM(MaNhom)
GO

-- d)
ALTER TABLE SANPHAM
ADD CONSTRAINT CK_DonGia CHECK (DonGia > 0)
GO
ALTER TABLE SANPHAM
ADD CONSTRAINT CK_SLTon CHECK (SLTon > 0)
GO
ALTER TABLE HOADON
ADD CONSTRAINT CK_NgayLapHD CHECK (NgayLapHD >= GETDATE())
GO
ALTER TABLE CT_HOADON
ADD CONSTRAINT CK_SoLuong CHECK (SoLuong > 0)
GO
ALTER TABLE CT_HOADON
ADD CONSTRAINT CK_ChietKhau CHECK (ChietKhau >= 0)
GO
ALTER TABLE KHACHHANG
ADD CONSTRAINT CK_LoaiKH CHECK (LoaiKH='VIP' OR LoaiKH='TV' OR LoaiKH='VL')
GO
ALTER TABLE KHACHHANG
ADD CONSTRAINT CK_DiemTL CHECK (DiemTL >= 0)
GO
ALTER TABLE HOADON
ADD CONSTRAINT DF_NgayLapHD DEFAULT (GETDATE()) FOR NgayLapHD
GO
-- e)
ALTER TABLE HOADON
ADD LoaiHD CHAR(1) NULL
GO
ALTER TABLE HOADON
ADD CONSTRAINT CK_LoaiHD
CHECK (LoaiHD='N' OR LoaiHD='X' OR LoaiHD='C' OR LoaiHD='T')
GO
ALTER TABLE HOADON
ADD CONSTRAINT DF_LoaiHD DEFAULT ('N') FOR LoaiHD
GO
-- f)
ALTER TABLE HOADON
ADD CONSTRAINT CK_NgayGiao CHECK (NgayGiao >= NgayLapHD)
GO
---------------------------------------------------------------------
--Bài 2
--Câu 1
CREATE DATABASE Movies
ON PRIMARY 
( NAME = Movies_Data, 
FILENAME = N'D:\Movie\Movies_Data.mdf' , 
SIZE = 25 MB , 
MAXSIZE = 40 MB , 
FILEGROWTH = 1 MB )
 LOG ON 
( NAME = Movies_Log, 
FILENAME = N'D:\Movie\Movies_Log.ldf' , 
SIZE = 6 MB , 
MAXSIZE = 8 MB , 
FILEGROWTH = 1 MB )
GO
USE Movies
GO
sp_helpDb Movies
GO
--Câu 2
ALTER DATABASE Movies ADD FILE (NAME = Movies_Data2,
FILENAME = N'D:\Movie\Movies_Data2.ndf', 
SIZE = 10MB) 
GO
ALTER DATABASE Movies
SET SINGLE_USER
GO
ALTER DATABASE Movies
SET RESTRICTED_USER
GO
ALTER DATABASE Movies
SET MULTI_USER
GO
sp_helpDb Movies
GO
ALTER DATABASE Movies 
MODIFY FILE (NAME = N'Movies_Data2', 
SIZE = 15MB)
GO
sp_helpDb Movies
GO
USE Master;
GO
DROP DATABASE Movies
GO
--Câu 3
ALTER DATABASE Movies ADD FILEGROUP Data
GO
ALTER DATABASE Movies 
MODIFY FILE (NAME = N'Movies_Log', 
MAXSIZE = 10MB)
GO
ALTER DATABASE Movies 
ADD FILE (NAME = Movies_Data2,
FILENAME = N'D:\Movie\Movies_Data2.ndf', 
SIZE = 10MB) 
TO FILEGROUP Data
GO
sp_helpDb Movies
GO
--Câu 5
EXEC sp_addtype Movie_num, 'int', 'NOT NULL'
EXEC sp_addtype Category_num, 'int', 'NOT NULL'
EXEC sp_addtype Cust_num, 'int', 'NOT NULL'
EXEC sp_addtype Invoice_num, 'int', 'NOT NULL'

sp_helpDb 

-- Câu 6 

CREATE TABLE Customer
( Cust_num cust_num IDENTITY (300,1) NOT NULL ,
 Lname varchar(20) NOT NULL,
 Fname varchar(20) NOT NULL, 
 Address1 varchar(30), 
 Address2 varchar(20),
 City varchar(20), 
 State Char(2), 
 Zip Char(10), 
 Phone Varchar(10) NOT NULL, 
 Join_date Smalldatetime NOT NULL
)
CREATE TABLE Category
( Category_num category_num IDENTITY(1,1) NOT NULL,
 Description Varchar(20) NOT NULL
)

CREATE TABLE Movie
( Movie_num Movie_num NOT NULL,
 Title Cust_num NOT NULL,
 Category_Num category_num NOT NULL,
 Date_purch Smalldatetime ,
 Rental_price Int ,
 Rating Char(5)
)
CREATE TABLE Rental 
( Invoice_num Invoice_num NOT NULL,
 Cust_num Cust_num NOT NULL,
 Rental_date Smalldatetime NOT NULL,
 Due_date Smalldatetime NOT NULL
)
CREATE TABLE Rental_Detail
(Invoice_num Invoice_num NOT NULL,
Line_num Int NOT NULL,
Movie_num Movie_num NOT NULL,
Rental_price Smallmoney NOT NULL,
)
--Câu 9 
ALTER TABLE Movie
ADD CONSTRAINT PK_movie
PRIMARY KEY (Movie_num)
EXEC Sp_helpconstraint Movie

ALTER TABLE Customer
ADD CONSTRAINT PK_customer
PRIMARY KEY (Cust_num)
EXEC Sp_helpconstraint Customer

ALTER TABLE Category
ADD CONSTRAINT PK_category
PRIMARY KEY (Category_num)A
EXEC Sp_helpconstraint Category

ALTER TABLE Rental
ADD CONSTRAINT PK_rental
PRIMARY KEY (Invoice_num)
EXEC Sp_helpconstraint Rental
--Câu 10 
ALTER TABLE Movie
ADD CONSTRAINT FK_movie Foreign key (Category_num) REFERENCES Category (Category_num)

ALTER TABLE Rental
ADD CONSTRAINT FK_rental Foreign key (Cust_num) REFERENCES Customer (Cust_num)

ALTER TABLE Rental_detail
ADD CONSTRAINT FK_detail_invoice Foreign key (Invoice_num) REFERENCES Rental (Invoice_num)

ALTER TABLE Rental_detail
ADD CONSTRAINT PK_detail_movie Foreign key (Movie_num) REFERENCES Movie (Movie_num)

-- Câu 12
ALTER TABLE Movie
ADD CONSTRAINT DK_movie_date_purch DEFAULT Getdate() FOR Date_purch

ALTER TABLE Customer
ADD CONSTRAINT DK_customer_join_date DEFAULT Getdate() FOR join_date

ALTER TABLE Rental
ADD CONSTRAINT DK_rental_rental_date DEFAULT Getdate() FOR Rental_date

ALTER TABLE Rental
ADD CONSTRAINT DK_rental_due_date DEFAULT Getdate()+2 FOR Due_date

 --Câu 13
 ALTER TABLE Movie
ADD CONSTRAINT CK_movie 
CHECK (Rating IN ('G','PG','R','NC17','NR'))

ALTER TABLE Rental
ADD CONSTRAINT CK_Due_date
CHECK (Due_date >= Rental_date )


