package hoHoangVanAnh.bai05;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HangThucPham {
	private String maHang;
	private String tenHang;
	private float donGia;
	private LocalDate ngaySx, ngayHH;

	public HangThucPham(String maHang, String tenHang, float donGia, LocalDate ngaySx, LocalDate ngayHH) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySx = ngaySx;
		this.ngayHH = ngayHH;

	}

	public HangThucPham(String maHang) throws Exception {
		super();
		if (!maHang.trim().equals("")) {
			this.maHang = maHang;
		} else
			throw new Exception("Loi: ma hang rong!");

	}

	public String getMaHang() {
		return maHang;
	}

	private void setMaHang(String maHang) throws Exception {
		if (!maHang.trim().equals("")) {
			this.maHang = maHang;
		} else
			throw new Exception("Loi: ma hang rong!");

	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public LocalDate getNgaySx() {
		return ngaySx;
	}

	public void setNgaySx(LocalDate ngaySx) {
		this.ngaySx = ngaySx;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) {
		this.ngayHH = ngayHH;
	}

	public boolean hetHan() {
		return ngayHH.isBefore(LocalDate.now()) ? true : false;
	}

	public String getGhiChu() {
		if (hetHan() == false) {
			return "Còn hạn sử dụng";
		}
		else {
			return "Hết hạn sử dụng";

		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#,##0.00");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
		String sx = ngaySx.format(dtf);
		String hh = ngayHH.format(dtf);
		String gia = df.format(donGia);
		
		return  String.format("%-10s %-15s %-20s %-10s %20s %20s", maHang, tenHang, gia, sx, hh, getGhiChu());
	}
}