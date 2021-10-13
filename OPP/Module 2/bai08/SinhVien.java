package hoHoangVanAnh.bai08;

public class SinhVien {
	private String maSV;
	private String hoTen;
	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public SinhVien(String maSV, String hoTen) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
	}
	
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
        return String.format("Danh sách sinh viên \n"+ maSV +" | "+ hoTen);
      
		
	}
}
