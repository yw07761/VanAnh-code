package hoHoangVanAnh.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDich {
	private String maGiaoDich;
	private double donGia;
	private int soLuong;
	private LocalDate ngayGiaoDich;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maGiaoDich
	 * @param dongia
	 * @param soluong
	 * @param ngaygiaodich
	 */
	public GiaoDich(String maGiaoDich, double donGia, int soLuong, LocalDate ngayGiaoDich) {
		setMaGiaoDich(maGiaoDich);
		setDonGia(donGia);
		setSoLuong(soLuong);
		setNgayGiaoDich(ngayGiaoDich);
	}
	
	/**
	 * hàm khởi tạo mặc định
	 */
	public GiaoDich() {
		this("xxx",0,0,LocalDate.now());
	}

	// Getter Setter

	public String getMaGiaoDich() {
		return maGiaoDich;
	}


	public void setMaGiaoDich(String maGiaoDich) {
		if(maGiaoDich.isEmpty()){
            this.maGiaoDich = "xxx";
        }else
        	this.maGiaoDich = maGiaoDich;
	}


	public double getDonGia() {
		return donGia;
	}


	public void setDonGia(double donGia) {
		if(donGia > 0)
			this.donGia = donGia;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		if(soLuong > 0)
			this.soLuong = soLuong;
	}


	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}


	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	
	/**
	 * hàm thành tiền lấy số lượng nhân đơn giá
	 * @return
	 */
	public double tinhTien() {
		return soLuong * donGia;
	}

	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%-15s %-20s %-13d %-12s", maGiaoDich, df.format(donGia),soLuong, dtf.format(ngayGiaoDich));
	}	
}