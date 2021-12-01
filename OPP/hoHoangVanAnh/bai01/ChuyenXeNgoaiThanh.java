package hoHoangVanAnh.bai01;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgayDiDuoc;
	
	// getter && setter
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// construction
	public ChuyenXeNgoaiThanh() {
		super();
		noiDen="";
		soNgayDiDuoc=0;
	}
	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, String noiDen,
			int soNgayDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}

	/*
	 * public String toString() {
			return "CX NoiThanh:" + super.toString() + ", noi den: " + this.noiDen + ", so ngay di duoc: " + this.soNgayDiDuoc;
	}
	 */
	@Override
	public String toString() {
		return String.format("%s %5s %15d", super.toString(),noiDen,soNgayDiDuoc);
	}
	public static String Ghitieude() {
		return String.format("%-10s %-30s %-20s %-10s %5s %20s","Mã số xe",
        		"Họ và tên","Số xe","Doanh Thu","Nơi đến","Số ngày đi được");
	}
}

