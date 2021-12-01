-- Tạo cơ sở dữ liệu
CREATE DATABASE QL_ThucTap
GO
USE QL_ThucTap
GO
-- Tạo bảng
CREATE TABLE TBLKHOA
(
	maKhoa CHAR(10) PRIMARY KEY,
	tenKhoa CHAR(30),
	dienThoai CHAR(10)
)
CREATE TABLE TBLGiangVien
(
	maGV INT PRIMARY KEY,
	hoTenGV CHAR(30),
	luong DECIMAL(5,2),
	maKhoa CHAR(10) FOREIGN KEY REFERENCES TBLKhoa
)
CREATE TABLE TBLSinhVien
(
	maSV INT PRIMARY KEY,
	hoTenSV CHAR(40),
	maKhoa CHAR(10) FOREIGN KEY REFERENCES TBLKhoa,
	namSinh INT,
	queQuan CHAR(30)
)
CREATE TABLE TBLDeTai
(
	maDT CHAR(10)PRIMARY KEY,
	tenDT CHAR(40),
	kinhPhi INT,
	noiThucTap CHAR(30)
)
CREATE TABLE TBLHuongDan
(
	maSV INT PRIMARY KEY,
	maDT CHAR(10) FOREIGN KEY REFERENCES TBLDeTai,
	maGV INT FOREIGN KEY REFERENCES TBLGiangVien,
	ketQua DECIMAL(5,2)
)
-- Thêm đữ liệu vào các bảng
INSERT INTO TBLKhoa VALUES
('Geo','Dia ly va QLTN',3855413),
('Math','Toan',3855411),
('Bio','Cong nghe Sinh hoc',3855412);


INSERT INTO TBLGiangVien VALUES
(11,'Thanh Binh',700,'Geo'),    
(12,'Thu Huong',500,'Math'),
(13,'Chu Vinh',650,'Geo'),
(14,'Le Thi Ly',500,'Bio'),
(15,'Tran Son',900,'Math');


INSERT INTO TBLSinhVien VALUES
(1,'Le Van Son','Bio',1990,'Nghe An'),
(2,'Nguyen Thi Mai','Geo',1990,'Thanh Hoa'),
(3,'Bui Xuan Duc','Math',1992,'Ha Noi'),
(4,'Nguyen Van Tung','Bio',null,'Ha Tinh'),
(5,'Le Khanh Linh','Bio',1989,'Ha Nam'),
(6,'Tran Khac Trong','Geo',1991,'Thanh Hoa'),
(7,'Le Thi Van','Math',null,'null'),
(8,'Hoang Van Duc','Bio',1992,'Nghe An');


INSERT INTO TBLDeTai VALUES
('Dt01','GIS',100,'Nghe An'),
('Dt02','ARC GIS',500,'Nam Dinh'),
('Dt03','Spatial DB',100, 'Ha Tinh'),
('Dt04','MAP',300,'Quang Binh' );


INSERT INTO TBLHuongDan VALUES
(1,'Dt01',13,8),
(2,'Dt03',14,0),
(3,'Dt03',12,10),
(5,'Dt04',14,7),
(6,'Dt01',13,Null),
(7,'Dt04',11,10),
(8,'Dt03',15,6);

-- Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
SELECT GV.Magv, GV.Hotengv, K.Tenkhoa
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.Makhoa = K.Makhoa

-- Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa 'Dia ly và QLTN'
SELECT GV.Magv, GV.Hotengv, K.Tenkhoa
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.Makhoa = K.Makhoa 
WHERE K.Tenkhoa = 'Dia ly va QLTN'

-- Cho biết số sinh viên của khoa 'Cong nghe sinh hoc'
SELECT COUNT(SV.maSV) AS So_SV
FROM TBLSinhVien SV
WHERE maKhoa='Bio'

-- Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa 'Toan hoc'
SELECT SV.Masv, SV.Hotensv
FROM TBLSinhVien SV JOIN TBLKhoa K
ON SV.Makhoa = K.Makhoa
WHERE K.Tenkhoa='TOAN'

-- Cho biết số giảng viên của khoa 'Cong nghe sinh hoc'
SELECT COUNT(GV.maGV) AS So_GV
FROM TBLGiangVien GV join TBLKhoa K
ON GV.maKhoa = K.maKhoa
WHERE K.tenKhoa='Cong nghe sinh hoc'

-- Cho biết thông tin về sinh viên không tham gia thực tập
SELECT SV.maSV , SV.hoTenSV, SV.namSinh, SV.queQuan
FROM TBLSinhVien SV 
WHERE NOT EXISTS( SELECT HD.maSV FROM TBLHuongDan HD WHERE SV.maSV = HD.maSV)

-- Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
SELECT K.maKhoa,K.tenKhoa, COUNT(K.maKhoa) AS So_GV
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.maKhoa = K.maKhoa
GROUP BY K.maKhoa,K.tenKhoa

-- Cho biết số điện thoại của khoa mà sinh viên có tên 'Le Van Son' đang theo học
SELECT K.tenKhoa, K.dienThoai
FROM TBLKhoa K join TBLSinhVien SV
ON K.maKhoa = SV.maKhoa
WHERE SV.hoTenSV = 'Le Van Son'

-- Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
SELECT DT.MaDT,DT.TenDT
FROM TBLGiangVien GV JOIN TBLHuongDan HD
ON GV.MaGV = HD.MaGV JOIN TBLDeTai DT
ON DT.MaDT = HD.MaDT
WHERE GV.HotenGV = 'Tran Son'

-- Cho biết tên đề tài không có sinh viên nào thực tập
SELECT DT.MaDT ,DT.TenDT
FROM TBLDeTai DT
WHERE NOT EXISTS(
SELECT HD.MaDT
FROM TBLHuongDan HD
WHERE HD.MaDT = DT.MaDT)


-- Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 1 sinh viên trở lên.
SELECT GV.MaGV,GV.HotenGV,K.TenKhoa
FROM TBLGiangVien GV JOIN TBLKhoa K
ON GV.MaKhoa = K.MaKhoa
WHERE GV.MaGV IN (
SELECT HD.MaGV
FROM TBLHuongDan HD
GROUP BY HD.MaGV
HAVING COUNT(HD.MaSV)>1)


-- Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
SELECT DT.MaDT,DT.TenDT
FROM TBLDeTai DT 
WHERE DT.kinhPhi = (
SELECT MAX(DT.kinhPhi)
FROM TBLDeTai DT)


-- Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
SELECT DT.maDT,DT.tenDT
FROM TBLDeTai DT
WHERE DT.maDT in (
SELECT HD.maDT
FROM TBLHuongDan HD
GROUP BY HD.maDT
HAVING COUNT(HD.maDT) > 2)


-- Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
SELECT SV.maSV,SV.hoTenSV,HD.ketQua
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON SV.maSV = HD.maSV
JOIN TBLKhoa K
ON K.maKhoa = SV.maKhoa
WHERE K.tenKhoa = 'Dia ly va QLTN'


-- Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
SELECT K.tenKhoa, COUNT(SV.maSV) AS So_SV
FROM TBLSinhVien SV JOIN TBLKhoa K
ON SV.maKhoa = K.maKhoa
GROUP BY K.tenKhoa


-- Cho biết thông tin về các sinh viên thực tập tại quê nhà
SELECT *
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.maSV = SV.maSV
JOIN TBLDeTai DT
ON DT.maDT = HD.maDT
WHERE SV.queQuan = DT.noiThucTap


-- Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
SELECT *
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.maSV = SV.maSV
WHERE HD.ketQua is Null


-- Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
SELECT SV.maSV,SV.hoTenSV
FROM TBLSinhVien SV JOIN TBLHuongDan HD
ON HD.maSV = SV.maSV
WHERE HD.ketQua = 0