package hoHoangVanAnh.bai05;

import java.text.DecimalFormat;

public class KhachHangVN extends DanhSachHoaDon {
	private String khachHang;
	private int dinhMuc;
	
	public KhachHangVN(String maKH, String hoTen, String ngayLapHD, int soKWTieuThu, double donGia, String khachHang,
			int dinhMuc) {
		super(maKH, hoTen, ngayLapHD, soKWTieuThu, donGia);
		setKhachHang(khachHang);
		setDinhMuc(dinhMuc);
	}
	public KhachHangVN() {
		super();
		khachHang="xxx";
		dinhMuc =0;
	}
	public String getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(String khachHang) {
		if (!khachHang.trim().equals("")) {
			this.khachHang = khachHang;
		}
	}
	public int getDinhMuc() {
		return dinhMuc;
	}
	public void setDinhMuc(int dinhMuc) {
		if(dinhMuc>0)
			this.dinhMuc = dinhMuc;
	}
	
	@Override
	public double tinhTien() {
		if(getSoKWTieuThu() <= dinhMuc) {
			return super.tinhTien() * getDonGia();
		}else {
			return (super.tinhTien() * dinhMuc ) 
					+ (dinhMuc * getSoKWTieuThu()); 
		}
	}
	public static String tieuDieu() {
		return String.format("%-10s %-20s %-20s %-10s %-13s %-9s %-13s %-15s ",
				"Mã KH","Tên KH","Ngày Lập HĐ","Số KW","Đơn Giá","Loại KH","Định Mức","Thành Tiền");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10s %10d %15s", super.toString(),khachHang,
				dinhMuc,df.format(tinhTien()));
		}
	
}