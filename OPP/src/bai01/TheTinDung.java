package bai01;
import java.text.DecimalFormat;

public class TheTinDung  extends NganHang{
	private int hanMuc;
	private double tienChiTieu;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maThe
	 * @param tenChuSoHuu
	 * @param hanMuc
	 * @param tienChiTieu
	 */
	public TheTinDung(int maThe, String tenChuSoHuu, int hanMuc, double tienChiTieu) {
		super(maThe, tenChuSoHuu);
		setHanMuc(hanMuc);
		setTienChiTieu(tienChiTieu);
	}
	/**
	 * hàm khởi tạo mặc định
	 */
	public TheTinDung() {
		this(0,"xxx",0,0);
	}


	public int getHanMuc() {
		return hanMuc;
	}
	/**
	 * hạn mức phải >= 0
	 * @param hanMuc
	 */
	public void setHanMuc(int hanMuc) {
		if(hanMuc >= 0)
			this.hanMuc = hanMuc;
		else
			this.hanMuc = 0;
	}

	public double getTienChiTieu() {
		return tienChiTieu;
	}
	/**
	 * tiền chi tiêu phải > 0
	 * @param tienChiTieu
	 */
	public void setTienChiTieu(double tienChiTieu) {
		if(tienChiTieu >= 0)
			this.tienChiTieu = tienChiTieu;
		else 
			this.tienChiTieu = 0;
	}
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("%s %-10d %-10s %-10b", super.toString(), 
				hanMuc,df.format(tienChiTieu),KhaNangchitieu());
	}
	public static String tieude() {
		return String.format("%-10s %-10s %-10s %-10s %-10s", 
				"mã thẻ", "Tên","Hạn Mức","Chi Tiêu","Khả Năng");
	}
	/**
	 * : Còn khả năng chi tiêu nếu tổng chi tiêu/tháng chưa vượt quá hạn mức tín dụng.
	 */
	@Override
	public boolean KhaNangchitieu() {
		// TODO Auto-generated method stub
		if(tienChiTieu <= hanMuc)
			return true;
		return false;
	}

}

