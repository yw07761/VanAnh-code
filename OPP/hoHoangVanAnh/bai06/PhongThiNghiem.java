package hoHoangVanAnh.bai06;

public class PhongThiNghiem extends PhongHoc {
	private String chuyenNganh;
	private int sucChua;
	private boolean bonRua; //true = có , false = không
	
	
	
	public PhongThiNghiem(String maP, String dayNha, int bongDen, float dienTich, String chuyenNganh, int sucChua,
			boolean bonRua) {
		super(maP, dayNha, bongDen, dienTich);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.bonRua = bonRua;
	}


	public PhongThiNghiem() {
		this("xxx","xxx",0,0,"xxx",0,false);
	}

	

	public String getChuyenNganh() {
		return chuyenNganh;
	}


	public void setChuyenNganh(String chuyenNganh) {
		if(!chuyenNganh.equals(""))
			this.chuyenNganh = chuyenNganh;
		else
			this.chuyenNganh = "xxx";
	}


	public int getSucChua() {
		return sucChua;
	}


	public void setSucChua(int sucChua) {
		if(sucChua > 0)
			this.sucChua = sucChua;
		else
			this.sucChua = 0; 
	}


	public boolean isBonRua() {
		return bonRua;
	}


	public void setBonRua(boolean bonRua) {
		this.bonRua = bonRua;
	}

	
	
	@Override
	public String toString() {
		String s ="";
		if(bonRua == true) {
			s += "có bồn rửa";
		}else {
			s += "không có bồn rửa";
		}
		return String.format("%s %-10s %-10d %-15s %-15b", 
				super.toString(),chuyenNganh,sucChua,s,DatChuan());
	}

	/**
	 * Phòng thí nghiệm: phải có bồn rửa đi kèm.
	 */
	@Override
	public boolean DatChuan() {
		// TODO Auto-generated method stub
		if(duAnhSang() && bonRua == true)
			return true;
		return false;
	}

}

