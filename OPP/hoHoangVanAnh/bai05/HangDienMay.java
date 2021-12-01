package hoHoangVanAnh.bai05;

import java.text.DecimalFormat;

public class HangDienMay extends HangHoa {
	private int congSuat;
	private int thoiGianBaoHanh;
	
	
	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int congSuat,
			int thoiGianBaoHanh) {
		super(maHang, tenHang, soLuongTon, donGia);
		setCongSuat(congSuat);
		setThoiGianBaoHanh(thoiGianBaoHanh);
	}


	public HangDienMay() {
		this("xxx","xxx",0,0,0,0);
	}

	
	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) {
		if(congSuat >= 0)
			this.congSuat = congSuat;
		else
			this.congSuat = 0;
	}

	
	
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}


	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if(thoiGianBaoHanh >= 0)
			this.thoiGianBaoHanh = thoiGianBaoHanh;
		else 
			this.thoiGianBaoHanh = 0;
	}

	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10d %10d %10s %10s", super.toString(), 
				congSuat, thoiGianBaoHanh, df.format(tinhTienVat()),mucDoBanBuon().toString());
	}
	public static String getTieuDe() {
        return String.format("%-10s %-15s %-10s %-10s %10s %10s %10s %10s", 
        		"Ma hang", "Ten Hang","Don Gia","So Luong Ton","Công Suất",
        		"Bảo Hành","VAT","Mục �?ánh Giá");
	}

	@Override
	public MucDoBuonBan mucDoBanBuon() {
		if(super.getSoLuongTon() < 3)
			return MucDoBuonBan.BanDuoc;
		else
			return MucDoBuonBan.KhongDanhGia;
	}

	@Override
	public double tinhTienVat() {
		return super.getDonGia() * 10/100;
	}

}
