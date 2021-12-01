package hoHoangVanAnh.bai04;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuanLyNhaDat {
	private String maGiaoDich;
	private LocalDate ngayGiaoDich;
	private double donGia;
	private float dienTich;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 */
	
	public QuanLyNhaDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, float dienTich) {
		super();
		setMaGiaoDich(maGiaoDich);
		setNgayGiaoDich(ngayGiaoDich);
		setDonGia(donGia);
		setDienTich(dienTich);
	}
	/**
	 * hàm mặc định
	 */
	public QuanLyNhaDat() {
		this("xxx",LocalDate.now(),0,0);
	}
	
	/**
	 * getter and setter
	 * @return
	 */
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		if(maGiaoDich.isEmpty()){
            this.maGiaoDich = "xxx";
        }else
        	this.maGiaoDich = maGiaoDich;
	}
	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}
	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia>0)
			this.donGia = donGia;
	}
	
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		if(dienTich>0)
			this.dienTich = dienTich;
	}
	/**
	 * hàm tính thành tiền 
	 * @return
	 */
	public double tinhTien() {
		return dienTich * donGia;
	}
	/**
	 * hàm in thông tin
	 */
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%12s %15s %10s %10.1f", maGiaoDich,dtf.format(ngayGiaoDich),
				df.format(donGia),dienTich);
	}
	
	
}

