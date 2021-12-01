package hoHoangVanAnh.bai06;

public class PhongLyThuyet extends PhongHoc {
	private boolean mayChieu; // true là có , false là không;
	
	
	public PhongLyThuyet(String maP, String dayNha, int bongDen, float dienTich, boolean mayChieu) {
		super(maP, dayNha, bongDen, dienTich);
		this.mayChieu = mayChieu;
	}


	public PhongLyThuyet() {
		this("xxx","xxx",0,0,false);
	}


	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	/**
	 * Phòng lý thuyết: phải có máy chiếu. trả về true;
	 */
	

	@Override
	public String toString() {
		String s = "";
		if(mayChieu)
			s += "có máy chiếu";
		else
			s += "không có máy chiếu";
		return String.format("%s %-15s %-105b", super.toString(),s, DatChuan());
	}


	@Override
	public boolean DatChuan() {
		if(duAnhSang() && mayChieu == true)
			return true;
		else 
			return false;
	}
	
	
	
	
}

