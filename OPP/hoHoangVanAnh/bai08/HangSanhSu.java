package hoHoangVanAnh.bai08;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat;
    private LocalDate ngayNhapKho;
    

	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
			LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, donGia);
		setNhaSanXuat(nhaSanXuat);
		setNgayNhapKho(ngayNhapKho);
	}
	
	
	public HangSanhSu() {
		this("xxx","xxx",0,0,"xxx",LocalDate.now());
	}
	
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}


	public void setNhaSanXuat(String nhaSanXuat) {
		if(!nhaSanXuat.trim().equals(""))
			this.nhaSanXuat = nhaSanXuat;
		else 
			this.nhaSanXuat = "xxx";
	}


	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
	/**
	 * 
	 * @param ngayNhapKho
	 */

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if(ngayNhapKho.isBefore(LocalDate.now()))
			this.ngayNhapKho = ngayNhapKho;
		else 
			this.ngayNhapKho = LocalDate.now();
	}
	
	
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10s %10s %10s %10s", super.toString(),
				nhaSanXuat, dtf.format(ngayNhapKho), df.format(tinhTienVat()),mucDoBanBuon().toString());
	}
	public static String getTieuDe() {
        return String.format("%-10s %-15s %-10s %-10s %10s %10s %10s %10s", 
        		"Ma hang", "Ten Hang","Don Gia","So Luong Ton","nhà sản xuất",
        		"Ngày nhập kho","VAT","Mục Đánh Giá");
	}
	
	/**
	 * nếu số lượng tồn kho >50 và thời gian lưu kho >10 ngày thì đánh giá là bán chậm. 
	 */
	@Override
	public MucDoBuonBan mucDoBanBuon() {
		 Period ngay = Period.between(ngayNhapKho, LocalDate.now());
	        int day = ngay.getDays();
	        int mounth = ngay.getMonths();
	        int year = ngay.getYears();
	        int thoiGianLuuKho = day + mounth*30 + year*365;
	        if (super.getSoLuongTon() > 50 && thoiGianLuuKho> 10 ) {
	            return MucDoBuonBan.BanCham;
	        }
	        return MucDoBuonBan.KhongDanhGia;
	}

	@Override
	public double tinhTienVat() {
		// TODO Auto-generated method stub
		return getDonGia() * 10/100;
	}

}
