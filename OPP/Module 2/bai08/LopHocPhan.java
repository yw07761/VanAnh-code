package hoHoangVanAnh.bai08;



public class LopHocPhan {
	private String maLHP;
	private String tenLHP;
	private String tenGV;
	private String thongTinLopHoc;
	static SinhVien [] dsSV = new SinhVien[3];
	
// getters & setter
	public String getMaLHP() {
		return maLHP;
	}
	public void setMaLHP(String maLHP) {
		this.maLHP = maLHP;
	}
	public String getTenLHP() {
		return tenLHP;
	}
	public void setTenLHP(String tenLHP) {
		this.tenLHP = tenLHP;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getThongTinLopHoc() {
		return thongTinLopHoc;
	}
	public void setThongTinLopHoc(String thongTinLopHoc) {
		this.thongTinLopHoc = thongTinLopHoc;
	}
	
//	 constructor
	public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc) {
		super();
		this.maLHP = maLHP;
		this.tenLHP = tenLHP;
		this.tenGV = tenGV;
		this.thongTinLopHoc = thongTinLopHoc;
	}
	
	public LopHocPhan() {
		return;
		
	}

	public void addSV(SinhVien sv) {
		int dem = 0;
        for (int i = 0; i <dsSV.length; i++) {
            if(dsSV[i] == null){
               dsSV[i] = sv;
                break;
            }
            if(dsSV[i] != null){
                dem++;
            }
            if(dem == dsSV.length)
                System.out.println("Danh sach day ko the them !");
        }
	}
	public String toStringList() {
		System.out.println(String.format(
        		"- Mã LHP: %s\n"+
        		"- Tên LHP: %s\n"+
        		"- GV giảng dạy: %s\n"+
        		"- Thông tin buổi học: %s\n"+
        		"Danh sách sinh viên\n"
		, getMaLHP(), getTenLHP(), getTenGV(),getThongTinLopHoc()));
        for(int i = 0; i < dsSV.length; i++) {
            if(dsSV[i] != null){
                System.out.println(String.format("%3s | %-15s",
                        dsSV[i].getMaSV() , dsSV[i].getHoTen()));
            }
        }
        return "";
	}
	public int getLength() {
		int count = 0;
        for (int i = 0; i < dsSV.length; i++) {
            if(dsSV[i] != null)
                count++;
        }
        return count;
	}
}
