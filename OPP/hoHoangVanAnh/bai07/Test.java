package hoHoangVanAnh.bai07;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SoftwareHouse a = new SoftwareHouse("FPT");
	a.ThemEmp(new Programmer(1, "Nguyễn Văn Nam",30000, "Java"));
	a.ThemEmp(new Administrator(2, "Trần Chí Khang", 40000, "Lầu 2"));
	a.ThemEmp(new ProjectLeader(3, "Nguyễn Văn Toàn", 50000, "Python"));
	
	Scanner sc = new Scanner(System.in);
	int n;
	do {
		System.out.println("\n_____MENU EMPLOYEE_____");
		System.out.println("1. Thêm 1 Nhân Viên vào công ty");
		System.out.println("2. Xuất toàn bộ thông tin nhân viên");
		System.out.println("3. Tính tổng tiền phải trả cho nhân viên");
		System.out.println("4. Sắp xếp danh sách nhân viên theo tên");
		System.out.println("5. Trả về thông tin các lập trình viên");
		System.out.println("6. Cập nhật phòng ban");
		System.out.println("7. Xóa nhân viên theo mã số");
		System.out.println("0. Thoát");
		System.out.print("\n\tMời nhập lựa chọn: ");
		n = sc.nextInt();
		switch (n) {
		case 1:
			 System.out.print("\nNhập mã số nhân viên: ");
             int id = sc.nextInt();
             System.out.print("\nNhập tên nhân viên: ");
             sc.nextLine();
             String tenNV = sc.nextLine();
             System.out.print("\nNhập lương cơ bản: ");
             double luongCB = sc.nextDouble();
             System.out.print("Nhập ngôn ngữ: ");
             sc.nextLine();
             String ngonNgu = sc.nextLine();
             if (a.ThemEmp(new Programmer(id, tenNV, luongCB, ngonNgu))) {
                 System.out.println("Danh sách sau khi tiêm: ");
                 System.out.println(a);
             } else 
                 System.out.println("Thêm không thành công");
             break;
		case 2:
			System.out.println(a.displayAllStaff());
			break;
		case 3:
			Locale locale = new Locale("en", "US");      
            NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
            System.out.printf("Tổng tiền phải trả cho nhân viên: %s \n",
            		currency.format(a.getMonthlySalaryBill()));
            break;
		case 4:
			a.xapdanhsachtheoten();
			System.out.println(a);
		case 5:
			System.out.println(a.getThongTinLapTrinhVien());
		case 6:
			System.out.print("\nnhập mã số cần tìm");
			int ID = sc.nextInt();
			System.out.print("Nhập Phòng ban mới");
			sc.nextLine();
			String deptNew = sc.nextLine();
			if(a.updateDepartmentForAdmin(ID, deptNew)) {
				System.out.println("	sữa thành công");
				System.out.println(a);
			}else {
				System.out.println("	sữa không thành công");
			}
			break;
		case 7:
			System.out.print("\nNhập mã cần xóa: ");
			int iD = sc.nextInt();
			if(a.deleteEmployee(iD)) {
				System.out.println("	xóa thành công");
				System.out.println(a);
			}else {
				System.out.println("	xóa không thành công");
			}
		case 0:
			sc.close();
			System.out.println("\nKết thúc");
			return;
		}
	} while(n != 0);
	System.out.println("nhập lại"); 
	}

}

