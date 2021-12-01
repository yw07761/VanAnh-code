package hoHoangVanAnh.bai04;

import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachSinhVien a = new DanhSachSinhVien();
		a.themSV(new SinhVien(1, "A", 19));
		a.themSV(new SinhVien(2, "B", 20));
		a.themSV(new SinhVien(3, "C", 19));
		a.themSV(new SinhVien(4, "D", 20));
		a.themSV(new SinhVien(5, "E", 21));
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("\n_____MENU Sinh Viên_____");
			System.out.println("1. Xuất Danh Sách Phòng Học");
			System.out.println("2. Thêm 1 sinh viên mới  ");
			System.out.println("3.Xóa sinh viên khi biết mã");
			System.out.println("4.Sữa thông tin sinh viên(Không cho sữa mã)");
			System.out.println("5.Tìm kiếm sinh viên theo mã");
			System.out.println("6.Tìm kiếm sinh viên theo tên");
			System.out.println("7.Sắp xếp danh sách theo mã tăng dần");
			System.out.println("0. Thoát");
			System.out.print("\n\tMời nhập lựa chọn: ");
			n = sc.nextInt();
		switch(n) {
			case 2:
				 SinhVien sv = new SinhVien();
				 System.out.print("\n Nhập mã sinh viên: ");
                 sv.setMaSV(sc.nextInt());
                 System.out.print("Nhập tên sinh viên: ");
                 sc.nextLine();
                 sv.setTenSV(sc.nextLine());
                 System.out.println("Nhập năm sinh: ");
                 sv.setNam(sc.nextInt());
                 if(a.themSV(sv))
                	 System.out.println("Thêm SV vào thành công!!!");
                 else
                	 System.out.println("Thêm SV vào Không thành công!!!");
                 
				break;
			case 1:
				System.out.println(a.toString());
				break;
			case 3:
				System.out.print("\nNhập mã cần xóa: ");
				 int maCanXoa = sc.nextInt();
                 if (a.xoaSV(maCanXoa)) {
                     System.out.println("Xóa SV thành công"); 
                     System.out.println(a);
                 } else {
                     System.out.println("Xóa không thành công");    
                 }
                 break;
			case 4:
				 System.out.println("Nhập mã sinh viên:");
                 int maSV = sc.nextInt();sc.nextLine();
                 System.out.println("Nhập họ tên mới: ");
                 String hoTen_moi = sc.nextLine();
                 System.out.println("Nhập năm sinh mới: ");
                 int namSinh_moi = sc.nextInt();
                 if (a.suaSV(maSV, hoTen_moi, namSinh_moi)) {
                     System.out.println("Sữa thành công");
                     System.out.println(a);
                 } else {
                     System.out.println("Sữa không thành công");
                 }
				break;
			case 5:
				System.out.print("\n Nhập mã sinh viên cần tìm: ");
                int Ma = sc.nextInt();
                DanhSachSinhVien sv_moi = a.timSV(Ma);
                if (sv_moi.getsize() == 0) {
                    System.out.println("	không tìm thấy");
                } else {
                    System.out.println("	Tìm thấy");
                    System.out.println(sv_moi);
                } 
				break;
			case 6:
				System.out.print("\n Nhập Tên sinh viên cần tìm: ");
				sc.nextLine();
				String Ten = sc.nextLine();
				DanhSachSinhVien sv_ten = a.timtenSV(Ten);
				if(sv_ten.getsize() == 0) {
					 System.out.println("	Không tìm thấy");
        		} else {
        			System.out.println("	Tìm thấy");
        		} 
				System.out.println(sv_ten);
					
				break;
			case 7:
				a.xapxeptheomaSV();
				System.out.println("	sau khi sắp xếp \n" + a);
				break;
			case 0:
				sc.close();
				System.out.println("\nKết thúc");
				return;
		}
		}while (n != 0);
		System.out.println("nhập lại"); 
	}
}

