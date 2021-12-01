package hoHoangVanAnh.bai06;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HoaDonTheoGio extends HoaDon {
	private int gioThue;

	

	public HoaDonTheoGio(String mahoadon, String tenKH, String maphong,
			LocalDate ngayLDH, double dongia, int gioThue) throws Exception {
		super(mahoadon, tenKH, maphong, ngayLDH, dongia);
		setGioThue(gioThue);
	}

	public HoaDonTheoGio() throws Exception {
		this("xxx", "xxx", "xxx", LocalDate.now(), 0,0);
	}

	public int getGioThue() {
		return gioThue;
	}
	
	public void setGioThue(int gioThue)throws Exception {
		if(gioThue > 30) {
			throw new Exception("không dùng hóa đơn theo giờ");
		}else {
			this.gioThue = gioThue;
		}
	}
	 
	@Override
	public double getThanhTien()  {
		// TODO Auto-generated method stub
		if(gioThue >= 24 && gioThue <= 30)
		{
			return 24 * super.getDongia();
		} else {
			return gioThue * super.getDongia();
	}
}
	 
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10d %10s", super.toString(), gioThue, df.format(getThanhTien()));
	}
	
	public static String getTieuDe() {
        return String.format("%-20s %-20s %-15s %-15s %-10s %10s %10s","Mã HD",
        		"Tên KH", "Mã Phòng","Ngày HD", "Đơn Giá","giờ thê","Thành Tiền");
    }
	
	
	
	
}
