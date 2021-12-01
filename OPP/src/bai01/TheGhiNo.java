package bai01;

import java.text.DecimalFormat;

public class TheGhiNo extends NganHang {
	private double tienDu;
	
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maThe
	 * @param tenChuSoHuu
	 * @param tienDu
	 */
	public TheGhiNo(int maThe, String tenChuSoHuu, double tienDu) {
		super(maThe, tenChuSoHuu);
		setTienDu(tienDu);
	}

	/**
	 * hàm khởi tạo mặc định
	 */
	public TheGhiNo() {
		this(0,"xxx",0);
	}

	public double getTienDu() {
		return tienDu;
	}
	
	/**
	 * tiền dư phải >= 0
	 * @param tienDu
	 */
	public void setTienDu(double tienDu) {
		if(tienDu >= 0)
			this.tienDu = tienDu;
		else
			this.tienDu = 0;
	}
	
	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %-10s %-10b ", super.toString(), df.format(tienDu), KhaNangchitieu());
	}
	public static String tieude() {
		return String.format("%-10s %-10s %-10s %-10s", "mã thẻ", "Tên","Tiền Dư","Khả Năng");
	}
	/**
	 * Còn khả năng chi tiêu nếu số dư của tài khoản >=100.000
	 */
	@Override
	public boolean KhaNangchitieu() {
		// TODO Auto-generated method stub
		if(tienDu >= 100000)
			return true;
		return false;
	}

}

