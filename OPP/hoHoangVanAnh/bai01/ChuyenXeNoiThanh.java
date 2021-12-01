package hoHoangVanAnh.bai01;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private int soTuyen;
	private double soKmDiDuoc;
	
	// getter && setter
	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		if(soTuyen > 0)
			this.soTuyen = soTuyen;
	}

	public double getSoKmDiDuoc() {
		return soKmDiDuoc;
	}

	public void setSoKmDiDuoc(double soKmDiDuoc) {
		if(soKmDiDuoc > 0)
			this.soKmDiDuoc = soKmDiDuoc;
	}
	
	// 
	public ChuyenXeNoiThanh() {
		super();
		this.soTuyen =0;
		this.soKmDiDuoc = 0;
	}

	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen,
			double soKmDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKmDiDuoc = soKmDiDuoc;
	}
	@Override
	public String toString() {
		return String.format("%s %10s %10s", super.toString(),soTuyen,soKmDiDuoc);
	}
	
	public static String Ghitieude() {
		return String.format("%-10s %-30s %-20s %-10s %10s %10s","Mã số xe",
        		"Họ và tên","Số xe","Doanh Thu","Số tuyến","Số km");
	}
	/*
	 * public String toString() {
		return "CX NoiThanh:" + super.toString() + ", so tuyen: " + this.soTuyen + ", so km di duoc: " + this.soKmDiDuoc;
		//return  String.format("%s %s %s", super.toString(),this.soTuyen,this.soKmDiDuoc);
	}
	 */
}
