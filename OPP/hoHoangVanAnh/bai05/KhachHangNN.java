package hoHoangVanAnh.bai05;

import java.text.DecimalFormat;

public class KhachHangNN extends DanhSachHoaDon{
	private String quocTich;

	public KhachHangNN(String maKH, String hoTen, String ngayLapHD, int soKWTieuThu, double donGia, String quocTich) {
		super(maKH, hoTen, ngayLapHD, soKWTieuThu, donGia);
		setQuocTich(quocTich);
	}

	public KhachHangNN() {
		super();
		quocTich ="xxx";
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		if (!quocTich.trim().equals("")) {
			this.quocTich = quocTich;
		}
	}
	
	@Override
	public double tinhTien() {
		// TODO Auto-generated method stub
		return super.tinhTien();
	}
	public static String tieuDieu() {
		return String.format("%-10s %-20s %-20s %-10s %-11s %-25s %-20s  ",
				"Mã KH","Tên KH","Ngày","Số KW","Đơn Giá","Quốc Tịch","Thành Tiền");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10s %26s", super.toString(), quocTich, df.format(tinhTien()));
	}
	
	
}
