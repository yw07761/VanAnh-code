package hoHoangVanAnh.bai08;

public class TestLHP {
	public static void main(String[] args) {
        LopHocPhan lhp = new LopHocPhan ("123456","LT hướng đối tượng", "Cô Hà", "Thứ 7, tiết 4-6, phòng A1.1");
        SinhVien sv = new SinhVien();
        SinhVien sv1 = new SinhVien("123","Nguyen Van A");
        SinhVien sv2 = new SinhVien("543","Le Thi B");
        SinhVien sv3 = new SinhVien("321","Luong Van C");
        lhp.addSV(sv1);
        lhp.addSV(sv2);
        lhp.addSV(sv3);
		
		System.out.println(lhp.toStringList());
		System.out.print("Tông số sinh viên: ");
		System.out.println(lhp.getLength());
    }
}
