package hoHoangVanAnh.bai02;

import java.time.LocalDate;

public class SachThamKhao extends QuanLyThuVien {
	private double Thue;

	public SachThamKhao(String maSach, LocalDate ngaynhap, double dongia, int soluong, String nhaxuatban, double thue) {
		super(maSach, ngaynhap, dongia, soluong, nhaxuatban);
		setThue(thue);
	}

	public double getThue() {
		return Thue;
	}

	public void setThue(double thue) {
		if(thue > 0 )
			this.Thue = thue;
	}
	
	@Override
	public double tinhTien() {
		return super.tinhTien() + Thue;
	}

	@Override
	public String toString() {
		return String.format("%s %-10.1f %-10.1f", super.toString(),Thue,tinhTien());
	}
	public static String tieude() {
		return String.format("%-10s %-20s %-20s %-10s %-13s %-10s %-10s", "Mã sách","Ngày nhập","Đơn giá",
				"Số lượng","Nhà sản xuất","Thuế","Thành tiền");
	}
	
}