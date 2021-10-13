package hinhChuNhat;

public class HinhChuNhat {
	// thuoc tinh
		private float cDai;
		private float cRong;

		// hanh vi
	public float getCDai(){
		return cDai;
	}
	public void setCDai(float cDai){
		this.cDai= cDai;
	}
	public float getCRong(){
		return cRong;
	}
	public void setCRong(float cRong){
		this.cRong= cRong;
	}
	/**
	* hàm khời tạo 
	*/
	public HinhChuNhat() {
		// TODO Auto-generated constructor stub
	} 
	
	public HinhChuNhat(float a, float b){
		super();
		this.cDai = a;
		this.cRong = b;
	}
	
	public float tinhChuVi(){
			return (cDai+cRong)*2;
	}
	public float tinhDienTich(){
			return cDai*cRong;
	}
	public String layThongTin(){
			return String.format("chieu dai = %f, chieu rong=%f, dien tich=%f, chu vi=%f",cDai,cRong, tinhDienTich(), tinhChuVi());
	}
	
}
