package hoHoangVanAnh.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Nha extends QuanLyNhaDat{
	private String loaiNha;
	
	/**
	 * Ham khoi tao
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 * @param loaiNha
	 */
	public Nha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, float dienTich, String loaiNha) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		setLoaiNha(loaiNha);
	}
	
	/**
	 * ham khoi tao khong tham so
	 * 
	 */
	public Nha() {
		this("xxx",LocalDate.now(),0,0,"xxx");
	}
	/**
	 * get/set loaiNha
	 * @return
	 */
	public String getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(String loaiNha) {
		if(loaiNha.isEmpty()){
            this.loaiNha = "xxx";
        }else
        	this.loaiNha = loaiNha;
	}
	
	@Override
	public double tinhTien() {
		if(loaiNha.equals("cao cấp")) {
			return super.tinhTien();
		}else {
			return super.tinhTien() * 90/100;
		}
	}
	public static String tieudeu() {
		return String.format("%-13s %-12s %10s %10s %10s %15s","Mã Giao Dịch",
				"Ngày Giao Dịch","Đơn Giá","Diện tích","Loại nhà","Thành Tiền");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10s %15s", super.toString(), loaiNha,df.format(tinhTien()));
	}
	
	
}

