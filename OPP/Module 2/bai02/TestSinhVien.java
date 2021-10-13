package hoHoangVanAnh.bai02;
import java.util.Scanner;

/**
 * Kiểm thử cho lớp {@link SinhVien}
 * 
 * 
 *
 */
public class TestSinhVien {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Tạo 2 đối tượng sv1 và sv2 bằng constructor đầy đủ tham số
		SinhVien sv1 = new SinhVien(11111, "Nguyễn Thanh An", 6.5f, 8.5f);
		SinhVien sv2 = new SinhVien(22222, "Lê Thị Bông", 7.5f, 8.0f);
		//Tạo đối tượng sv3 bằng default constructor
		
		//Nhập dữ liệu của sinh viên sv từ bàn phím
		System.out.println("Nhập mã số của sinh viên sv3: ");
		int masv = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập họ và tên của sinh viên sv3: ");
		String hoten = sc.nextLine();
		System.out.println("Nhập điểm lý thuyết của sinh viên sv3: ");
		float LT = sc.nextFloat();
		System.out.println("Nhập điểm thực hành của sinh viên sv3: ");
		float TH = sc.nextFloat();
		//Gọi các phương thức để gán giá trị cho sv3
		SinhVien sv3 = new SinhVien(masv,hoten, LT,TH);
		//In thông tin của 3 đối tượng sv1, sv2, sv3 ra cửa sổ console
		System.out.println(String.format("%-5s %-30s %10s %10s %10s", "masv", "hoten", "diemlt", "diemth", "diemtb"));
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
		sc.close();
	}
}