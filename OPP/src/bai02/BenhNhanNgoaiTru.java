package bai02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BenhNhanNgoaiTru extends BenhNhan {
	private LocalDate ngayKham;
	private int BHYT;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maHoSo
	 * @param hoTen
	 * @param chuanDoanBenh
	 * @param ngayKham
	 * @param bHYT
	 */
	public BenhNhanNgoaiTru(int maHoSo, String hoTen, String chuanDoanBenh, LocalDate ngayKham, int bHYT) {
		super(maHoSo, hoTen, chuanDoanBenh);
		setNgayKham(ngayKham);
		setBHYT(bHYT);
	}
	/**
	 * hàm khởi tạo mặt định
	 */
	public BenhNhanNgoaiTru() {
		this(0,"xxx","xxx",LocalDate.now(),0);
	}
	public LocalDate getNgayKham() {
		return ngayKham;
	}
	/**
	 *  ngày <= ngày hiện tại
	 * @param ngayKham
	 */
	public void setNgayKham(LocalDate ngayKham) {
		if(ngayKham.isBefore(LocalDate.now()))
			this.ngayKham = ngayKham;
		else
			this.ngayKham = LocalDate.now();
	}
	public int getBHYT() {
		return BHYT;
	}
	/**
	 * BHYT >= 0
	 * @param bHYT
	 */
	public void setBHYT(int bHYT) {
		if(BHYT >= 0)
			this.BHYT = bHYT;
		else
			this.BHYT = 0;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s %-10s %10d",super.toString(),dtf.format(ngayKham),BHYT);
	}
	
	public static String tieuDe() {
		return String.format("%-10s %-10s %-10s %-10s %10s ","Mã Số","Tên BN","Bệnh",
				"Ngày Khám","BHYT");
	}
	
	
	
}
