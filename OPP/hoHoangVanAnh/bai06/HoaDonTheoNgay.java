package hoHoangVanAnh.bai06;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HoaDonTheoNgay extends HoaDon {
	private int soNgayThue;

	public HoaDonTheoNgay(String mahoadon, String tenKH, String maphong, LocalDate ngayLDH, double dongia,
		int soNgayThue) {
		super(mahoadon, tenKH, maphong, ngayLDH, dongia);
		setSoNgayThue(soNgayThue);
	}
	
	public HoaDonTheoNgay() {
		this("xxx", "xxx", "xxx", LocalDate.now(), 0,0);
	}

	public int getSoNgayThue() {
		return soNgayThue;
	}

	public void setSoNgayThue(int soNgayThue) {
		if(soNgayThue > 0) {
			this.soNgayThue = soNgayThue;
		}else {
			this.soNgayThue = 0;
		}
	}
	
	@Override
	public double getThanhTien(){
		// TODO Auto-generated method stub
		if(soNgayThue > 7) {
			return (super.getDongia() * 0.2) * soNgayThue;
		}else {
			return super.getDongia() * soNgayThue;
		}
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10d %10s", super.toString(), soNgayThue, df.format(getThanhTien()));
	}
	public static String getTieuDe() {
        return String.format("%-20s %-20s %-15s %-15s %-10s %10s %10s","Mã HD",
        		"Tên KH", "Mã Phòng","Ngày HD", "Đơn Giá","ngày thuê","Thành Tiền");
    }
	

}

