package hoHoangVanAnh.bai01;

import java.text.DecimalFormat;

public class ChuyenXe {
	private String maSoChuyen, hoTenTaiXe, soXe;
	private double doanhThu;
	
	// getter && setter
	public String getMaSoChuyen() {
		return maSoChuyen;
	}

	public void setMaSoChuyen(String maSoChuyen) {
		if(maSoChuyen.isEmpty()){
            this.maSoChuyen = "Chua xac dinh !";
        }else
		this.maSoChuyen = maSoChuyen;
	}

	public String getHoTenTaiXe() {
		return hoTenTaiXe;
	}

	public void setHoTenTaiXe(String hoTenTaiXe) {
		if(hoTenTaiXe.isEmpty()){
            this.hoTenTaiXe = "Chua xac dinh !";
        }else
		this.hoTenTaiXe = hoTenTaiXe;
	}

	public String getSoXe() {
		return soXe;
	}

	public void setSoXe(String soXe) {
		if(soXe.isEmpty()){
            this.soXe = "Chua xac dinh !";
        }else
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		if(doanhThu > 0)
			this.doanhThu = doanhThu;
	}
	 // construction
	public ChuyenXe() {
		//super();
		this("","","",0);
	}

	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		super();
		/**this.maSoChuyen = maSoChuyen;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;*/
		// 
		setMaSoChuyen(maSoChuyen);
		setHoTenTaiXe(hoTenTaiXe);
		setSoXe(soXe);
		setDoanhThu(doanhThu);
	}
	// toString
	public String toString() {
		//return "MS chuyen:" + maSoChuyen + ", Tai xe: " + hoTenTaiXe + ", So xe: " + soXe + ", Doanh thu:" + doanhThu;
		DecimalFormat df = new DecimalFormat("#,##0 ");
		return String.format("%-10s %-30s %-20s %s", maSoChuyen,hoTenTaiXe,soXe,df.format(doanhThu));
	}

}
