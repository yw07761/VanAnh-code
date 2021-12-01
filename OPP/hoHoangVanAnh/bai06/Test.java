package hoHoangVanAnh.bai06;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhMucPhongHoc a = new DanhMucPhongHoc();
		a.themPH(new PhongLyThuyet("123", "A12", 10, 90, true));
		a.themPH(new PhongMayTinh("124", "A11", 10, 100, 60));
		a.themPH(new PhongThiNghiem("125", "A10", 12, 90, "CNTT", 150, true));
		
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("\n_____MENU PHÒNG HỌC_____");
			System.out.println("1. Xuất Danh Sách Phòng Học");
			System.out.println("2. Tìm kiếm Phòng Học");
			System.out.println("3. Danh Sách Cách Phòng Học Đạt Chuẩn");
			System.out.println("4. Tổng Só Phòng Học");
			System.out.println("5. sắp xếp danh sách tăng dần theo dãy nhà");
			System.out.println("6. sắp xếp danh sách giảm dần theo diện tích");
			System.out.println("7. sắp xếp danh sách tăng dần theo số bóng đèn.");
			System.out.println("8. cập nhập phòng học");
			System.out.println("9. xóa 1 phòng học");
			System.out.println("10. lấy danh sách các phòng máy có 60 máy");
			System.out.println("0. Thoát");
			System.out.print("\n\tMời nhập lựa chọn: ");
			n = sc.nextInt();
		switch(n) {
			case 1:
				System.out.println("==============Phòng Lý Thuyết=============");
				System.out.println(a.xuatPLT());
				System.out.println("==============Phòng Máy Tính=============");
				System.out.println(a.xuatPMT());
				System.out.println("==============Phòng Thí Ngiệm=============");
				System.out.println(a.xuatPTN());
				break;
			case 2:
				System.out.print("\n nhập mã phòng cần tìm");
				sc.nextLine();
				String maP = sc.nextLine();
				DanhMucPhongHoc ph = a.timMP(maP);
				if(a.timMP(maP) != null) {
					System.out.println("	mã phòng cần tìm là");
					System.out.println(a.timMP(maP));
				}else {
					System.out.println("	không tìm thấy");
				}
				break;
			case 3:
				DanhMucPhongHoc pH = a.dsPhongHocDatChuan();
				if(a.getsize() != 0) {
					System.out.println("	Danh Sách Phòng Học Đạt Chuẩn");
					System.out.println(a);
				}else {
					System.out.println("	Không có	");
				}
				break;
			case 4:
				System.out.println("	Số phòng học " + a.getsize());
				break;
			case 5:
				a.tangdanTheoDayNha();
				System.out.println("	sau khi sắp xếp \n" + a);
				break;
			case 6:
				a.giamdantheoDienTich();
				System.out.println("	sau khi sắp xếp \n" + a);
				break;
			case 7:
				a.tangdanTheoBongDen();
				System.out.println("	sau khi sắp xếp \n" + a);
				break;
			case 9:
				System.out.print("\nNhập mã cần xóa: ");
				sc.nextLine();
				String maPh = sc.nextLine();
				boolean kg = a.XoaP(maPh);
				if(kg == true) {
					System.out.println("	Mã Phòng Sau Khi Xóa \n" + a.toString());
				}else {
					System.out.println("	không xóa đc");
				}
				break;
			case 8:
				System.out.print("\nNhập mã phòng cần sữa: ");
				sc.nextLine();
				String maPH = sc.nextLine();
				System.out.print("\nNhập số máy tính mới: ");
				int maTinh_moi = sc.nextInt();
				boolean tt = a.capnhap(maPH, maTinh_moi);
				if(tt == true)
					System.out.println("Sữa thành công \n" + a.xuatPMT());
				else
					 System.out.println("Sữa không thành công");
				break;
			case 10:
					DanhMucPhongHoc PH = a.DsPhonghocCo60maytinh();
					if(a.getsize() != 0) {
						System.out.println("Phòng có 60 máy tính là");
						System.out.println(a.xuatPMT());
					}else {
						System.out.println("	không có phòng có 60 máy tính");
					}
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

