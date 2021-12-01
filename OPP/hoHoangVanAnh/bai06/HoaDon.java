package hoHoangVanAnh.bai06;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class HoaDon {
	private String Mahoadon;
	private String tenKH;
	private String Maphong;
	private LocalDate ngayLDH;
	private double Dongia;
	
	
	public String getMahoadon() {
		return Mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		if(!mahoadon.equals("")) {
			this.Mahoadon = mahoadon;
		}else {
			this.Mahoadon = "xxx";
		}
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		if(!tenKH.equals("")) {
			this.tenKH = tenKH;
		}else {
			this.tenKH = "xxx";
		}
	}
	public String getMaphong() {
		return Maphong;
	}
	public void setMaphong(String maphong) {
		if(!maphong.equals("")) {
			this.Maphong = maphong;
		}else {
			this.Maphong = "xxx";
		}
	}
	
	public LocalDate getNgayLDH() {
		return ngayLDH;
	}
	public void setNgayLDH(LocalDate ngayLDH) {
		this.ngayLDH = ngayLDH;
	}

	public double getDongia() {
		return Dongia;
	}
	public void setDongia(double dongia) {
		if(dongia > 0) {
			this.Dongia = dongia;
		}
	}
	/**
	 * nếu số ngày thuê lớn hơn 7 thì giảm 20%
	 * @return
	 */
	public double getThanhTien(){
        return getThanhTien();
    }
    
	public String toString() {
	    Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%-20s %-20s %-13s %-13s %-10s",Mahoadon,tenKH,Mahoadon,dtf.format(ngayLDH),
				df.format(Dongia));
	}
	public static String getTieuDe() {
        return String.format("%-10s %-20s %-20s %-10s %-10s %10s %10s","Mã HD",
        		"Tên KH", "Mã Phòng","Ngày HD", "Đơn Giá","thuê","Thành Tiền");
    }
	
	public HoaDon(String mahoadon, String tenKH, String maphong, LocalDate ngayLDH, double dongia) {
		setMahoadon(mahoadon);
		setTenKH(tenKH);
		setMaphong(maphong);
		setNgayLDH(ngayLDH);
		setDongia(dongia);
	}
	public HoaDon() {
		this("xxx", "xxx", "xxx", LocalDate.now(), 0);
	}
	@Override
	public int hashCode() {
		return Objects.hash(Mahoadon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(Mahoadon, other.Mahoadon);
	}
	
	
	
}
