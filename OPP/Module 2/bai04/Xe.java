package hoHoangVanAnh.bai04;

public class Xe {
    private String chuXe;
    private String loaiXe;
    private float triGiaXe;
    private int dungTichXylanh;
	static final double  THUEBE = 0.01;
	static final double  THUETRUNGBINH = 0.03;
	static final double  THUELON = 0.05;
	
    public Xe(String chuXe, String loaiXe, float triGiaXe, int dungTichXylanh) {
        this.chuXe = chuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGiaXe;
        this.dungTichXylanh = dungTichXylanh;
    }
    public Xe(){
    	
    }

	public String getChuXe() {
        return chuXe;
    }

    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public float getTriGiaXe() {
        return triGiaXe;
    }

    public void setTriGiaXe(float triGiaXe) {
        this.triGiaXe = triGiaXe;
    }

    public int getDungTichXylanh() {
        return dungTichXylanh;
    }

    public void setDungTichXylanh(int dungTichXylanh) {
        this.dungTichXylanh = dungTichXylanh;
    }
    public double tinhThue() {
		int dTich = this.getDungTichXylanh();
		float giaTri = this.getTriGiaXe();
		double thueXe;
		if(dTich < 100)
		{
			thueXe = giaTri*THUEBE;
		}
		else if(dTich > 100 && dTich < 200)
		{
			thueXe = giaTri*THUETRUNGBINH;
		}
		else
		{
			thueXe = giaTri*THUELON;
		}
		return thueXe;
	}
    @Override
    public String toString() {
        return String.format("%-30s %-15s %-30s %-15s %-15.2f ",chuXe , loaiXe , triGiaXe , dungTichXylanh , tinhThue());
    }
}