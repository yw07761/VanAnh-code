USE [QLBH]
GO

CREATE TABLE NhomSanPham(
	MaNhom int NOT NULL,
	TenNhom nchar(15) NULL
) 
CREATE TABLE SanPham(
	MaSp int NOT NULL,
	TenSp nvarchar(40) NOT NULL,
	MaNCC int,
	MoTa nvarchar(50),
	MaNhom int,
	DonViTinh nvarchar(20),
	GiaGoc Money CHECK (GiaGoc > 0),
	SLTON int CHECK (SLTON >0)
)
CREATE TABLE HoaDon(
	MaHD int NOT NULL,
	NgayLapHD DateTime ,
	NgayGiao DateTime DEFAULT GETDATE(),
	Noichuyen NVarchar(60) NOT NULL,
	MaKh NChar(5)
)
CREATE TABLE CT_HoaDon(
	MaHD int NOT NULL,
	MaSp int NOT NULL,
	Soluong SmallInt CHECK (Soluong > 0),
	Dongia Money,
	ChietKhau Money CHECK (ChietKhau >=0)
)
CREATE TABLE NhaCungCap(
	MaNCC int NOT NULL,
	TenNcc NvarChar(40) NOT NULL,
	Diachi NvarChar(60),
	Phone NvarChar(24),
	SoFax NvarChar(24),
	DCMail NvarChar(50)
)
CREATE TABLE KhachHang(
	MaKh NChar(5) NOT NULL,
	TenKh NvarChar(40) NOT NULL,
	LoaiKh NvarChar(3) CHECK (LoaiKh IN ('VIP','TV','VL')),
	DiaChi NvarChar(60),
	Phone NvarChar(24),
	SoFax NvarChar(24),
	DCMail NvarChar(50),
	DiemTL int CHECK (DiemTL >=0)
)
