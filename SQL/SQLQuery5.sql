-- Tuần 4
delete from KHACHHANG
--KhachHang TB
Insert into KHACHHANG Values (1,'Nguyen Thu Hang', 'VL', '12 Nguyen Du', ' ', NULL, NULL, NULL)
Insert into KHACHHANG Values (2,'Lê Minh', 'TV', '34 Dien Bien Phu', '0123943455', NULL, 'LeMinh@yahoo.com', 100)
Insert into KHACHHANG Values (3,'Nguyen Minh Trung', 'VIP', '3 Le Loi Go Vap', '098343434', NULL, 'Trung@gmail.com', 800)


--NhaCungCcap TB
Insert into NHACUNGCAP Values (1, 'Công ty TNHH Nam Phương ', '1 Le Loi Phuong 4 Quan Go Vap', '083843456', '32343434', 'NamPhuong@yahoo.com')
Insert into NHACUNGCAP Values (2, 'Công ty Lan Ngoc', '12 Cao Ba Quat Quan 1 Tp. Ho Chi Minh', '086234567', '8343455', 'LanNgoc@gmail.com')

--NhomSanPham TB
Insert into NHOMSANPHAM Values (1, 'Dien Tu')
Insert into NHOMSANPHAM Values (2, 'Gia Dung')
Insert into NHOMSANPHAM Values (3, 'Dung Cu Gia Dinh')
Insert into NHOMSANPHAM Values (4, 'Cac Mat Hang Khac')

--SanPham TB
Insert into SANPHAM Values (1, 'May Tinh', 'May Sony Ram 2GB', 'Cai', 70000000, 100, 1, 1)
Insert into SANPHAM Values (2, 'Ban Phim', 'Ban Phom 101 Phim', 'Cai', 10000000, 50, 1,1)
Insert into SANPHAM Values (3, 'Chuot', 'Chuot khong day', 'Cai', 8000000, 150, 1, 1)
Insert into SANPHAM Values (4, 'CPU', 'CPU', 'Cai', 30000000, 200, 1, 1)
Insert into SANPHAM Values (5, 'USB', '8GB', 'Cai', 5000000, 100, 1, 1)
Insert into SANPHAM Values (6, 'Lo Vi Song', NULL, 'Cai', 1000000000, 20, 3, 2)

set dateformat dmy
--set dateformat ymd
--HoaDon TB
Insert into HOADON Values (1234, '12-02-2018', '13-02-2018', '12NVB', 1, 'n')
Insert into HOADON Values (1235, '16-02-2019', '17-02-2019', '12NVB', 2,'c')
Insert into HOADON Values (1236, '12-10-2017', '15-10-2017', 'HS-HT', 1,'t')

--CT_HoaDon TB
Insert into CT_HOADON Values (1234, 34, 2, 2300000, 10)
Insert into CT_HOADON Values (1235, 35, 5, 1000000, 20)
Insert into CT_HOADON Values (1236, 36, 7, 2000000, 15)
Insert into CT_HOADON Values (1237, 37, 9, 3000000, 20)
Insert into CT_HOADON Values (1238, 38, 11, 4000000, 25)
Insert into CT_HOADON Values (1239, 39, 13, 5000000, 23)
Insert into CT_HOADON Values (1240, 40, 15, 6000000, 24)

select * from KHACHHANG
select * from CT_HOADON 
select * from NHACUNGCAP
select * from NHOMSANPHAM
select * from SANPHAM
select * from HOADON
--cau 3.a
select * from SANPHAM where masp=34
Update SANPHAM set DonGia=DonGia*1.05 where masp=34
--cau 3.b
select * from SANPHAM where MaNhom=123 and MaNCC=12
Update SANPHAM set SLTon=100 where MaNhom=123 and MaNCC=12
--cau 3.d
select * from KHACHHANG where LoaiKH<>'VL'
Update KHACHHANG set DiemTL=DiemTL+50 where  LoaiKH <>'VL'
--cau 3.e
select * from SANPHAM where TenSP like '%u%'
Update SANPHAM set DonGia=DonGia*1.02 where TenSP like '%u%'

--cau 4.a
select * from SANPHAM where SLTon<2
Delete from SANPHAM Where SLTon<2

--cau 4.b
select * from HOADON where MaKH in (select MaKH from KHACHHANG where LoaiKH='VL')
Delete from HOADON Where MaKH in (select MaKH from KHACHHANG where LoaiKH='VL')

--cau 4.c
select * from KHACHHANG Where LoaiKH = 'VIP' and DiemTL =0
Delete from KHACHHANG Where LoaiKH = 'VIP' and DiemTL =0