package bai02;

public class BenhNhanChuyenVien extends BenhNhan {
	private String noiChuyen;

	/**
	 * hàm khởi tạo đầy đủ
	 * @param maHoSo
	 * @param hoTen
	 * @param chuanDoanBenh
	 * @param noiChuyen
	 */
	public BenhNhanChuyenVien(int maHoSo, String hoTen, String chuanDoanBenh, String noiChuyen) {
		super(maHoSo, hoTen, chuanDoanBenh);
		setNoiChuyen(noiChuyen);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public BenhNhanChuyenVien() {
		this(0, "xxx","xxx","xxx");
	}

	public String getNoiChuyen() {
		return noiChuyen;
	}
	/**
	 * kiểm tra chuỗi không được rỗng
	 * @param noiChuyen
	 */
	public void setNoiChuyen(String noiChuyen) {
		if(!noiChuyen.trim().equals(""))
			this.noiChuyen = noiChuyen;
		else 
			this.noiChuyen = "xxx";
	}
	@Override
	public String toString() {
		return String.format("%s %10s", super.toString(),noiChuyen);
	}
	
	public static String tieuDe() {
		return String.format("%-10s %-10s %-10s %10s  ","Mã Số","Tên BN","Bệnh",
				"noi chuyển");
	}
	
	
	
	
}
