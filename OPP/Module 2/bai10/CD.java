package hoHoangVanAnh.bai10;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBH;
	private double giaThanh;

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		 if(maCD <= 0)
	            this.maCD = 999999;
	        else
	            this.maCD = maCD;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if(tuaCD == null){
            this.tuaCD = "Chua xac dinh !";
        }else
            this.tuaCD = tuaCD;
	}

	public int getSoBH() {
		return soBH;
	}

	public void setSoBH(int soBH) {
		if(soBH > 0)
            this.soBH = soBH;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		 if(giaThanh > 0)
	            this.giaThanh = giaThanh;
	}

	public CD() {
		// TODO Auto-generated constructor stub
	}

	public CD(int maCD, String tuaCD, int soBH, double giaThanh) {
		super();
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.soBH = soBH;
		this.giaThanh = giaThanh;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub 
		 return "CD{" +
         "MaCD=" + maCD +
         ", TuaCD='" + tuaCD + '\'' +
         ", SoBH=" + soBH +
         ", GiaThanh=" + giaThanh +
         '}';
	}
	public void HienThiCD(){
        System.out.printf("%-10d %-20s %-15d %-20.1f \n",maCD,tuaCD,soBH,giaThanh);
    }
}
