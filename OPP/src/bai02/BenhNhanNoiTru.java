package bai02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BenhNhanNoiTru extends BenhNhan {
	private LocalDate ngaynhapvien;
	private String TenKhoa; // chỉ đc nhập k1 , k2 ,k3
	private int soGiuong;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maHoSo
	 * @param hoTen
	 * @param chuanDoanBenh
	 * @param ngaynhapvien
	 * @param tenKhoa
	 * @param soGiuong
	 */
	public BenhNhanNoiTru(int maHoSo, String hoTen, String chuanDoanBenh, LocalDate ngaynhapvien, String tenKhoa,
			int soGiuong) {
		super(maHoSo, hoTen, chuanDoanBenh);
		setNgaynhapvien(ngaynhapvien);
		setTenKhoa(tenKhoa);
		setSoGiuong(soGiuong);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public BenhNhanNoiTru() {
		this(0,"xxx","xxx",LocalDate.now(),"xxx",0);
	}
	
	public LocalDate getNgaynhapvien() {
		return ngaynhapvien;
	}
	
	/**
	 *  ngày <= ngày hiện tại
	 * @param ngaynhapvien
	 */
	public void setNgaynhapvien(LocalDate ngaynhapvien) {
		if(ngaynhapvien.isBefore(LocalDate.now()))
			this.ngaynhapvien = ngaynhapvien;
		else
			this.ngaynhapvien = LocalDate.now();
	}
	
	public String getTenKhoa() {
		return TenKhoa;
	}
	/**
	 * riêng tên khoa chỉ được là “K1”, “K2”, “K3”. 
	 * @param tenKhoa
	 */
	public void setTenKhoa(String tenKhoa) {
		if(tenKhoa == "K1" || tenKhoa == "K2" || tenKhoa == "k3")
			this.TenKhoa = tenKhoa;
		else
			this.TenKhoa = "xxx";
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	/**
	 * số giường phải >= 0
	 * @param soGiuong
	 */
	public void setSoGiuong(int soGiuong) {
		if(soGiuong >= 0)
			this.soGiuong = soGiuong;
		else 
			this.soGiuong = 0;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s %-10s %-15s %10d",
				super.toString(),dtf.format(ngaynhapvien),TenKhoa,soGiuong);
	}
	
	public static String tieuDe() {
		return String.format("%-10s %-10s %-10s %-10s %-15s %10s","Mã Số","Tên BN","Bệnh",
				"Ngày Nhập Viện","Tên Khoa","Số Giường");
	}
	
	
	
}