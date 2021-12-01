package hoHoangVanAnh.bai04;

import java.util.Objects;

public class SinhVien {
	private int maSV;
	private String TenSV;
	private int nam;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maSV
	 * @param tenSV
	 * @param nam
	 */
	public SinhVien(int maSV, String tenSV, int nam) {
		setMaSV(maSV);
		setTenSV(tenSV);
		setNam(nam);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public SinhVien() {
		this(0,"xxx",0);
	}
	public int getMaSV() {
		return maSV;
	}
	/**
	 * ktr mã sinh viên
	 * @param maSV
	 */
	public void setMaSV(int maSV) {
		if(maSV > 0)
			this.maSV = maSV;
		else
			this.maSV = 0;
	}
	public String getTenSV() {
		return TenSV;
	}
	/**
	 * ktr tên sinh viên không đc rỗng
	 * @param tenSV
	 */
	public void setTenSV(String tenSV) {
		if(!tenSV.equals(""))
			this.TenSV = tenSV;
		else
			this.TenSV = "xxx";
	}
	public int getNam() {
		return nam;
	}
	/**
	 * ktr nam > 0
	 * @param nam
	 */
	public void setNam(int nam) {
		if(nam > 0)
			this.nam = nam;
		else
			this.maSV = 0;
	}
	@Override
	public String toString() {
		return String.format("%10d %-10s %10d", maSV,TenSV,nam);
	}
	public static String tieude() {
		return String.format("%10s %-10s %10s", "mã ", "tên", "năm Sinh");
	}
	@Override
	public int hashCode() {
		return Objects.hash(TenSV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(TenSV, other.TenSV);
	}
	
	
	
}
