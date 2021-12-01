package hoHoangVanAnh.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	
	public GiaoDichVang(String maGiaoDich, double donGia, int soLuong, LocalDate ngayGiaoDich, String loaiVang) {
		super(maGiaoDich, donGia, soLuong, ngayGiaoDich);
		setLoaiVang(loaiVang);
	}
	public GiaoDichVang() {
		// TODO Auto-generated constructor stub
		this("xxx",0,0,LocalDate.now(),"xxx");
	}

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) {
		if(loaiVang.isEmpty()){
            this.loaiVang = "xxx";
        }else
        	this.loaiVang = loaiVang;
	}
	
	/**
	 * thành tiền số lượng nhân đơn giá
	 */
	@Override
	public double tinhTien() {
		// TODO Auto-generated method stub
		return super.tinhTien();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %-10s %-10s" , super.toString(), loaiVang,df.format(tinhTien()) );
	}
	public static String ghiteudieu() {
		return String.format("%-15s %-14s %-15s %-16s %-10s %-14s ", "Mã Tiền tệ", "Đơn giá", 
				"Số lượng","Ngày giao dịch","Loại Vàng","Thành tiền");
	}
	
	
}
