package hoHoangVanAnh.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich {
	private double tiGia;
	private String loaiTienTe;
	
	public GiaoDichTienTe(String maGiaoDich, double donGia, int soLuong, LocalDate ngayGiaoDich, double tiGia, String loaiTienTe) {
		super(maGiaoDich, donGia, soLuong, ngayGiaoDich);
		setTiGia(tiGia);
		setLoaiTienTe(loaiTienTe);
	
	}
	
	public GiaoDichTienTe() {
		this("xxx",0,0,LocalDate.now(),0,"xxx");
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) {
		if(tiGia>0)
			this.tiGia = tiGia;
	}

	public String getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(String loaiTienTe) {
		if(loaiTienTe.isEmpty()){
            this.loaiTienTe = "xxx";
        }else
        	this.loaiTienTe = loaiTienTe;
	}
	/**
	 * nếu là USD and EURO thì * với tỉ giá
	 * ngược lại số lượng * đơn giá
	 */
	@Override
	public double tinhTien() {
		if(loaiTienTe == "USD" || loaiTienTe == "EURO") {
			return super.tinhTien() * tiGia;
		}else {
			return super.tinhTien();
		}
	}
	public static String teudieu() {
		return String.format("%-15s %-14s %-15s %-16s %-6s %-14s %-10s", "Mã Tiền tệ", "Đơn giá", 
				"Số lượng","Ngày giao dịch","Tỉ giá","Loại tiền tệ","Thành tiền");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %-10s %-10s %10s", super.toString(), df.format(tiGia), 
				loaiTienTe,df.format(tinhTien()));
	}
	
}
