package hoHoangVanAnh.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Dat extends QuanLyNhaDat {
	private String loaiDat;
	
	/**
	 * Ham khoi tao day du tham so
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 * @param loaiDat
	 */
	public Dat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, float dienTich, String loaiDat) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		setLoaiDat(loaiDat);
	}

	/**
	 * 
	 public Dat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, float dienTich) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiDat ="xxx";
	}
	*/
	
	/**
	 * Ham khoi tao khong tham so
	 */
	public Dat() {
		this("xxx",LocalDate.now(),0,0,"xxx");
	}
	
	/**
	 * get/set loaiDat
	 * @return
	 */
	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		if(loaiDat.isEmpty()){
            this.loaiDat = "xxx";
        }else
        	this.loaiDat = loaiDat;
	}
	/**
	 * Ham tinh tien
	 */
	@Override
	public double tinhTien() {
		if(loaiDat.equals("A")) {
			return super.tinhTien() *1.5;
		}else {
			return super.tinhTien();
		}
	}
	public static String tieudeu() {
		return String.format("%-13s %-12s %10s %10s %10s %15s","Mã Giao Dịch",
				"Ngày Giao Dịch","Đơn Giá","Diện tích","Loại Đất","Thành Tiền");
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %10s %15s", super.toString(), loaiDat, df.format(tinhTien()));
	}
	
}

