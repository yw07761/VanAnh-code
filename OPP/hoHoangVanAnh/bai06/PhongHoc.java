package hoHoangVanAnh.bai06;

import java.util.Objects;

public abstract class PhongHoc {
	private String maP;
	private String dayNha;
	private int bongDen;
	private float dienTich;
	
	/**
	 * hàm khởi tạo đầy đủ tham số
	 * @param maP
	 * @param dayNha
	 * @param bongDen
	 * @param dienTich
	 */
	public PhongHoc(String maP, String dayNha, int bongDen, float dienTich) {
		setMaP(maP);
		setDayNha(dayNha);
		setBongDen(bongDen);
		setDienTich(dienTich);
	}


	public PhongHoc() {
		this("xxx","xxx",0,0);
	}
	
	public String getMaP() {
		return maP;
	}

	/**
	 * kiểm tra mã phòng 
	 * @return
	 */
	public void setMaP(String maP) {
		if(!maP.equals(""))
			this.maP = maP;
		else 
			this.maP = "xxx";
	}


	public String getDayNha() {
		return dayNha;
	}

	/**
	 * kiểm tra dãy nhà 
	 * @return
	 */
	public void setDayNha(String dayNha) {
		if(!dayNha.equals(""))
			this.dayNha = dayNha;
		else 
			this.dayNha = "xxx";
	}


	public int getBongDen() {
		return bongDen;
	}

	/**
	 * kiểm tra bóng đèn > 0
	 * @return
	 */
	public void setBongDen(int bongDen) {
		if(bongDen > 0) 
			this.bongDen = bongDen;
		else 
			this.bongDen = 0;
	}

	
	public float getDienTich() {
		return dienTich;
	}
	

	public void setDienTich(float dienTich) {
		if(dienTich > 0)
			this.dienTich = dienTich;
		else 
			this.dienTich = 0;
	}


	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10d %-10.1f", maP,dayNha,bongDen,dienTich);
	}
	
	public static String TieuDeLT() {
		return String.format("%-10s %-10s %-10s %-10s %-15s %-15s",
				"Mã Phòng","Dãy Nhà","Bóng Đèn","Diện Tích","Máy Chiếu","Đạt Chuẩn");
	}
	public static String TieuDeMT() {
		return String.format("%-10s %-10s %-10s %-10s %-15s %-15s",
				"Mã Phòng","Dãy Nhà","Bóng Đèn","Diện Tích","Máy Tính","Đạt Chuẩn");
	}
	
	public static String TieuDeTN() {
		return String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-15s %-15s",
				"Mã Phòng","Dãy Nhà","Bóng Đèn","Diện Tích","chuyên ngành",
				"Sức Chứa","Bồn Rữa","Đạt Chuẩn");
	}
	public static String TieuDe() {
		return String.format("%-10s %-10s %-10s %-10s ",
				"Mã Phòng","Dãy Nhà","Bóng Đèn","Diện Tích");
	}
	
	
	public boolean duAnhSang() {
		if(dienTich / bongDen <= 10)
			return true;
		else
			return false;
	}
	
	public abstract boolean DatChuan();


	@Override
	public int hashCode() {
		return Objects.hash(maP);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		return Objects.equals(maP, other.maP);
	}
	
	
}

