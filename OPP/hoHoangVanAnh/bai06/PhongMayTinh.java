package hoHoangVanAnh.bai06;

public class PhongMayTinh extends PhongHoc {
	private int mayTinh;
	
	/**
	 * hàm khởi tạo đầy đủ
	 * @param maP
	 * @param dayNha
	 * @param bongDen
	 * @param dienTich
	 * @param mayTinh
	 */
	
	public PhongMayTinh(String maP, String dayNha, int bongDen, float dienTich, int mayTinh) {
		super(maP, dayNha, bongDen, dienTich);
		this.mayTinh = mayTinh;
	}

	

	public PhongMayTinh() {
		this("xxx","xxx",0,0,0);
	}

	public int getMayTinh() {
		return mayTinh;
	}

	/**
	 * ktr phươn thức máy tính > 0
	 * @param mayTinh
	 */
	
	public void setMayTinh(int mayTinh) {
		if(mayTinh > 0)
			this.mayTinh = mayTinh;
		else
			this.mayTinh = 0;
	}

	@Override
	public String toString() {
		return String.format("%s %-15d %-15b", super.toString(), mayTinh, DatChuan());
	}
	/**
	 * Phòng máy tính: trung bình 1.5m2 đặt một máy 
	 */
	@Override
	public boolean DatChuan() {
		if(duAnhSang() && super.getDienTich() / mayTinh >= 1.5f)
			return true;
		return false;
	}

	
	
}

