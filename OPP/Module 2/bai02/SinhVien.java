package hoHoangVanAnh.bai02;
public class SinhVien {
	private int maSV;
	private String hoTen;
	private float diemLT;
	private float diemTH;

	public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public SinhVien() {
		this(0, "", 0.0f, 0.0f);
	}


	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) throws Exception {
		if(maSV > 0)
			this.maSV = maSV;
		else
			throw new Exception ("Mã SV phải lớn hơn 0");
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen.equals(""))
			throw new Exception (" Họ tên không được trống");
		else
			this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		if (diemLT >= 0 && diemLT <= 10)
			this.diemLT = diemLT;
		else
			this.diemLT = 0;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		if (diemTH >= 0 && diemTH <= 10)
			this.diemTH = diemTH;
		else
			this.diemTH = 0;
	}

	public float getDiemTB() {
		return (diemLT + diemTH) / 2;
	}
	@Override
	public String toString() {
		return String.format("%-5s %-30s %10.2f %10.2f %10.2f", this.maSV, this.hoTen, this.diemLT, this.diemTH,
				getDiemTB());
	}
}