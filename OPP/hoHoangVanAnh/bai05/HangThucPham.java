package hoHoangVanAnh.bai05;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham extends HangHoa {
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	
	
	public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super(maHang, tenHang, soLuongTon, donGia);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}
	
	public HangThucPham() {
		this("xxx","xxx",0,0,"xxx",LocalDate.now(),LocalDate.now());
	}
	
	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		if(!nhaCungCap.trim().equals(""))
			this.nhaCungCap = nhaCungCap;
		else 
			this.nhaCungCap = "xxx";
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	/**
	 * phải trước ngày hiện tại, mặc định là ngày hiện tại
	 * @param ngaySanXuat
	 */
	
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(ngaySanXuat.isBefore(LocalDate.now()))
			this.ngaySanXuat = ngaySanXuat;
		else 
			this.ngaySanXuat = LocalDate.now();
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	/**
	 * (phải sau ngày sản xuất, mặc định là ngày sản xuất
	 * @param ngayHetHan
	 */
	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(ngayHetHan.isAfter(ngaySanXuat))
			this.ngayHetHan = ngayHetHan;
		else
			this.ngayHetHan = ngaySanXuat;
	}
	
	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("̀€̀€%s %10s %10s %10s %10s %10s", super.toString(),nhaCungCap, 
				dtf.format(ngaySanXuat),dtf.format(ngayHetHan),df.format(tinhTienVat()),mucDoBanBuon().toString());
	}
	public static String getTieuDe() {
        return String.format("%-10s %-15s %-10s %-10s %10s %10s %10s %10s %10s", 
        		"Ma hang", "Ten Hang","Don Gia","So Luong Ton","Nha Cung Cap",
        		"Ngay San Xuat","Ngay Het Han","VAT","Mục �?ánh Giá");
	}

	@Override
	public MucDoBuonBan mucDoBanBuon() {
		// TODO Auto-generated method stub
		if(super.getSoLuongTon() > 0 && ngayHetHan.isBefore(LocalDate.now())) {
			return MucDoBuonBan.KhoBan; 
		}else {
			return MucDoBuonBan.KhongDanhGia;
		}
	}

	@Override
	public double tinhTienVat() {
		// TODO Auto-generated method stub
		return super.getDonGia() * 0.5;
	}
	
	
}
