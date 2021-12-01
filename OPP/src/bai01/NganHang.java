package bai01;

import java.util.Objects;

public abstract class NganHang {
	private int maThe;
	private String tenChuSoHuu;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maThe
	 * @param tenChuSoHuu
	 */
	public NganHang(int maThe, String tenChuSoHuu) {
		setMaThe(maThe);
		setTenChuSoHuu(tenChuSoHuu);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public NganHang() {
		this(0,"xxx");
	}
	public int getMaThe() {
		return maThe;
	}
	/**
	 * mã thẻ phải >= 0
	 * @param maThe
	 */
	public void setMaThe(int maThe) {
		if(maThe >= 0)
			this.maThe = maThe;
		else
			this.maThe = 0;
	}
	public String getTenChuSoHuu() {
		return tenChuSoHuu;
	}
	/**
	 * kiểm tra tên không được rỗng
	 * @param tenChuSoHuu
	 */
	public void setTenChuSoHuu(String tenChuSoHuu) {
		if(!tenChuSoHuu.trim().equals(""))
			this.tenChuSoHuu = tenChuSoHuu;
		else
			this.tenChuSoHuu = "xxx";
	}
	/**
	 * lớp trừu tượng
	 * @return
	 */
	public abstract boolean KhaNangchitieu();
	
	@Override
	public String toString() {
		return String.format("%-10d %-10s", maThe,tenChuSoHuu);
	}
	public static String tieude() {
		return String.format("%-10s %-10s", "mã thẻ", "Tên chủ sỡ hữu");
	}
	@Override
	public int hashCode() {
		return Objects.hash(maThe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NganHang other = (NganHang) obj;
		return maThe == other.maThe;
	}
}