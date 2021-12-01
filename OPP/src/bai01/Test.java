package bai01;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachNganHang a = new DanhSachNganHang();
		a.ThemTK(new TheGhiNo(1, "Tâm", 1000000));
		a.ThemTK(new TheTinDung(2, "Linh", 100000, 200000));
		a.ThemTK(new TheGhiNo(3, "Vịnh", 50000));
		a.ThemTK(new TheTinDung(4, "Huy", 500000, 400000));
		a.ThemTK(new TheGhiNo(5, "Thiện", 4000000));
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("----MENU TÀI KHOẢN------");
			System.out.println("1. Xuất ra toàn bộ danh sách");
			System.out.println("2. Đếm số lượng các tài khoản không còn khả năng chi tiêu.");
			System.out.println("3. Sửa hạn mức tín dụng khi biết mã thẻ.");
			System.out.println("4. Sắp xếp danh sách theo mã thẻ giảm dần.");
			System.out.println("0. Thoát");
			System.out.print("\n\tMời nhập lựa chọn: ");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("-------Thẻ Ghi Nợ------");
				System.out.println(a.xuatTGN());
				System.out.println("-------Thẻ Tín Dụng----");
				System.out.println(a.xuatTTD());
				break;
			case 2:
				System.out.println("số lượng tài khoản không còn khả năng chi tiêu:  " 
			+ a.Tkkhonghongkhanangchitieu());
				break;
			case 3:
				System.out.print("\n nhập mã cần sữa ");
				int maThe = sc.nextInt();
				System.out.print("\n nhập hạn mức mới");
				int hanMuc_moi = sc.nextInt();
				boolean kg = a.suahanmuc(maThe, hanMuc_moi);
				if(kg == true) {
					System.out.println("Sữa Thành Công");
					System.out.println(a);
				}else {
					System.out.println("Sửa Không Thành công");
				}
				break;
			case 4:
				a.sapxepmathegiamgian();
				System.out.println("	sau khi xắp sếp  \n" + a);
				break;
			case 0:
				System.out.println("	kết thức");
				return;
			}
		} while (n != 0);
		System.out.println("mới nhập lại");
	}

}
