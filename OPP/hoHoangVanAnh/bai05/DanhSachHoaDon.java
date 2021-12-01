package hoHoangVanAnh.bai05;

public class DanhSachHoaDon {
	private String maKH;
	private String hoTen;
	private String ngayLapHD;
	private int soKWTieuThu;
	private double donGia;
	
	
	public DanhSachHoaDon(String maKH, String hoTen, String ngayLapHD, int soKWTieuThu, double donGia) {
		super();
		setMaKH(maKH);
		setHoTen(hoTen);
		setNgayLapHD(ngayLapHD);
		setSoKWTieuThu(soKWTieuThu);
		setDonGia(donGia);
	}
	public DanhSachHoaDon() {
		this("xxx","xxx","xxx",0,0.0);
	}

	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		if (!maKH.trim().equals("")) {
			this.maKH = maKH;
		}
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		if (!maKH.trim().equals("")) {
			this.hoTen = hoTen;
		}
	}
	public String getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(String ngayLapHD) {
		if (!maKH.trim().equals("")) {
			this.ngayLapHD = ngayLapHD;
		}
	}
	public int getSoKWTieuThu() {
		return soKWTieuThu;
	}
	public void setSoKWTieuThu(int soKWTieuThu) {
		if(soKWTieuThu > 0)
			this.soKWTieuThu = soKWTieuThu;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia > 0)
			this.donGia = donGia;
	}
	
	public double tinhTien(){
		return soKWTieuThu * donGia;
	}
	
	public String toString() {
		return String.format("%-10s %-20s %-20s %-10d %-10.2f",maKH,hoTen,ngayLapHD,soKWTieuThu,donGia);
	}
}
