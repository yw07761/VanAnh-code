Create Database DieuTri
GO
USE DieuTri
GO

Create table Khoa
(
	TenKhoa varchar(20) primary key,
	MoTa varchar(30),
	SoLuongBS int
)
create table BS
(
	MaBS varchar(6) primary key,
	HoTenBS nvarchar(30),
	DiaChiBS varchar(50),
	SDT varchar(12),
	TenKhoa varchar(20)
)
create table BenhNhan
(
	CMND varchar(10) primary key,
	HoTenBN nvarchar(30),
	DiaChiBN nvarchar(50),
	BHYT varchar (10)
)
create table SoDieuTri
(
	MaDieuTri varchar (6) primary key,
	NgayNhap datetime,
	MoTa nvarchar(50),
	NgayXuat datetime,
	MaPhong varchar(6),	
	CMND varchar(10),
	MaBS varchar(6)
)
create table ChiTietDieuTri 
(
	MaChiTietDieuTri int primary key,
	Ngay datetime,
	LieuPhap nvarchar(50),
	MaDieuTri varchar(6),
	MaBS varchar(6)
)
ALTER TABLE BS
ADD CONSTRAINT FK_BS_K FOREIGN KEY (TenKhoa) REFERENCES Khoa(TenKhoa)
GO
ALTER TABLE SoDieuTri
ADD CONSTRAINT FK_SDT_BN FOREIGN KEY (CMND) REFERENCES BenhNhan(CMND)
GO
ALTER TABLE SoDieuTri
ADD CONSTRAINT FK_SDT_BS FOREIGN KEY (MaBS) REFERENCES BS(MaBS)
GO
ALTER TABLE ChiTietDieuTri
ADD CONSTRAINT FK_CT_SDT FOREIGN KEY (MaDieuTri) REFERENCES SoDieuTri(MaDieuTri)
GO
ALTER TABLE ChiTietDieuTri
ADD CONSTRAINT FK_CT_BS FOREIGN KEY (MaBS) REFERENCES MaBS(MaBS)
GO

-- Thêm đữ liệu vào các bảng
INSERT INTO Khoa VALUES
('Nhi','Chua benh tre em',10),
('TimMach','Chua benh tim mach',12),
('NgoaiTongQuat','Chua benh ngoai khoa',15);
INSERT INTO BS VALUES
('001','Tuan','Quan 3',090,'TimMach'),
('002','Hong','Quan 5', 091,'NgoaiTongQuat'),
('003','Nam','Quan 1', 099,'Nhi');
INSERT INTO BenhNhan VALUES
('022','Lan','Tien Giang',922),
('023','Hoang','Binh Thanh', 923),
('024','Thanh','Quan 8', 924);
INSERT INTO SoDieuTri VALUES
('1',1/1/2020,'Dau Khop',15/1/2020, NULL, '022','003'),
('2',18/3/2020,'Ho', 30/4/2020, 'A11', '023', '002'),
('3',25/4/2020,'Sot', 19/4/2020, 'B22', '024', '002');
INSERT INTO ChiTietDieuTri VALUES
(1,18/3/2020,'Chup XQ','2', '002'),
(2,19/3/2020,'Uong khang sinh','2', '002'),
(3,20/3/2020,'Uong thuoc ha huyet ap', '2', '001');

--Truy van
-- a.Liệt kê họ tên bác sĩ không có số điện thoại 
SELECT bs.HoTenBS
FROM BS bs 
WHERE bs.SDT = NULL
-- b.Liệt kê họ tên bệnh nhân có họ tên bắt đầu bằng chữ T.
SELECT bn.HoTenBN
FROM BenhNhan bn
where bn.HoTenBN like 't%'
-- c.Liệt kê họ tên bệnh nhân, địa chỉ của bệnh nhân có ngày nhập viện là 18/3/2020
SELECT bn.HoTenBN, bn.DiaChiBN
FROM BenhNhan bn JOIN SoDieuTri sdt
ON bn.CMND = sdt.CMND
WHERE  sdt.NgayNhap = 18/3/2020
--d.Liệt kê danh sách bệnh nhân gồm HoTenBN, SoNgayNamVien = Ngày hiện tại – Ngày nhập viện. 
select bn.HoTenBN, count( getdate()-sdt.NgayNhap) as SoNgayNamVien 
from BenhNhan bn join SoDieuTri sdt 
on bn.CMND=sdt.CMND 
group by bn.HoTenBN
--e.Liệt kê họ tên bệnh nhân nhập viện hơn 30 ngày.
SELECT bn.HoTenBN, count( getdate()-sdt.NgayNhap) 
AS SoNgayNamVien 
FROM BenhNhan bn join SoDieuTri sdt 
ON bn.CMND=sdt.CMND group by bn.HoTenBN 
HAVING count( getdate()-sdt.NgayNhap) > 30