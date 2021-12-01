package hoHoangVanAnh.bai02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuanLyThuVien {
	private String maSach;
	private LocalDate ngayNhap;
	private double donGia;
	private int soLuong;
	private String nhaXuatBan;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maSach
	 * @param ngaynhap
	 * @param dongia
	 * @param soluong
	 * @param nhaxuatban
	 */
	public QuanLyThuVien(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		super();
		setMaSach(maSach);
		setNgayNhap(ngayNhap);
		setDonGia(donGia);
		setSoLuong(soLuong);
		setNhaXuatBan(nhaXuatBan);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public QuanLyThuVien() {
		//super();
		this("xxx",LocalDate.now(),0,0,"xxx");
	}
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		if(maSach.isEmpty()){
            this.maSach = "xxx";
        }else
        	this.maSach = maSach;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		
			this.ngayNhap = ngayNhap;
		
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if(donGia >0) {
			this.donGia = donGia;
		}
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if(soLuong>0) {
		this.soLuong = soLuong;
		}
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		if(nhaXuatBan.isEmpty()){
            this.nhaXuatBan = "xxx";
        }else
        	this.nhaXuatBan = nhaXuatBan;
	}
	
	/**
	 * hàm in xuat thông tin
	 */
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%-10s %-20s %-20.1f %-15d %-8s", maSach,dtf.format(ngayNhap),
				donGia,soLuong,nhaXuatBan);
	}
	/**
	 * hàm tính tiền
	 */
	
	public double tinhTien() {
		// TODO Auto-generated method stub
		return soLuong * donGia;
	}
	
	
}
