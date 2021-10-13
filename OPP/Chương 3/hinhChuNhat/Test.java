package hinhChuNhat;

public class Test {
	public static void main (String[] args) {
		HinhChuNhat h = new HinhChuNhat();
		h.setCDai(10);
		h.setCRong(5);
		System.out.println("Chương trình tinh chu vi va diện tích HCN");
		System.out.println("chu vi cua HCN vua tao là:" +h.tinhChuVi());
		System.out.println("Dien tich cua HCN vua tao là:" + h.tinhDienTich());
		System.out.println(h.layThongTin());
	}
	
}
