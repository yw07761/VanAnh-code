package bai02;

import java.util.Objects;

public class BenhNhan {
	private int maHoSo;
	private String hoTen;
	private String chuanDoanBenh;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maHoSo
	 * @param hoTen
	 * @param chuanDoanBenh
	 */
	public BenhNhan(int maHoSo, String hoTen, String chuanDoanBenh) {
		setMaHoSo(maHoSo);
		setHoTen(hoTen);
		setChuanDoanBenh(chuanDoanBenh);
	}
	/**
	 * hàm khởi tạo mặt định
	 */
	public BenhNhan() {
		this(0,"xxx","xxx");
	}
	public int getMaHoSo() {
		return maHoSo;
	}
	/**
	 * kiểm tra mã > 0
	 * @param maHoSo
	 */
	public void setMaHoSo(int maHoSo) {
		if(maHoSo > 0)
			this.maHoSo = maHoSo;
		else
			this.maHoSo = 0;
	}
	public String getHoTen() {
		return hoTen;
	}
	/**
	 * kiểm tra tên không đc rỗng
	 * @param hoTen
	 */
	public void setHoTen(String hoTen) {
		if(!hoTen.equals(""))
			this.hoTen = hoTen;
		else
			this.hoTen = "xxx";	
	}
	public String getChuanDoanBenh() {
		return chuanDoanBenh;
	}
	/**
	 * kiểm tra bệnh không được rỗng
	 * @param chuanDoanBenh
	 */
	public void setChuanDoanBenh(String chuanDoanBenh) {
		if(!chuanDoanBenh.equals(""))
			this.chuanDoanBenh = chuanDoanBenh;
		else 
			this.chuanDoanBenh = "xxx";
	}
	@Override
	public String toString() {
		return String.format("%-10d %-10s %-10s", maHoSo, hoTen,chuanDoanBenh);
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoSo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenhNhan other = (BenhNhan) obj;
		return maHoSo == other.maHoSo;
	}
	
}
