package hoHoangVanAnh.bai02;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
		QuanLyThuVien a[] = new QuanLyThuVien[6]; 
		a[0] = new SachGiaoKhoa("S100", LocalDate.of(2020, 12, 02), 100000,10,"KD", true); 
		a[1] = new SachGiaoKhoa("S101", LocalDate.of(2020, 10, 12), 50000, 15,"KD", false);
		a[2] = new SachGiaoKhoa("S102", LocalDate.of(2020, 10, 30), 150000, 20,"BGD", true);
		a[3] = new SachThamKhao("B100", LocalDate.of(2020, 11, 10), 70000, 20,"BGD", 5000);
		a[4] = new SachThamKhao("B101", LocalDate.of(2020, 10, 23), 80000, 10,"BGD", 2000);
		a[5] = new SachThamKhao("B102", LocalDate.of(2020, 9, 20),90000, 20,"BGD", 7000);
		System.out.println("=======================================Sách Giáo Khoa=============================================================");
		System.out.println(SachGiaoKhoa.tieude());
		XuatGK(a);
		// tính tổng thành tiền
		System.out.printf("\n tổng tiền của sách giáo khoa là %s \n",df.format(TongTienGK(a)));
		
		System.out.println("=======================================Sách Tham Khảo=============================================================");
		System.out.println(SachThamKhao.tieude());
		XuatTK(a);
		// tính tổng thành tiền
		System.out.printf("\n tổng tiền của sách tham khảo là %s \n",df.format(TongTienTK(a)));
		
		System.out.println("=====================================Tổng thành tiền cao nhất======================================================");
		timThanhTienCaoNhat(a);
		/**
		 * Xuất ra các sách giáo khoa của nhà xuất bản K (yêu cầu nhập K).
		 */
		System.out.println("=============================Xuất ra các sách giáo khoa của nhà xuất bản K=========================================");
		nhapK(a);
		
		
	}
		
	public static void XuatGK(QuanLyThuVien[] a) {
		for(int i = 0; i < 6; i++) {
			if(a[i] instanceof SachGiaoKhoa)
				System.out.println(a[i].toString());
		}
	}
	public static void XuatTK(QuanLyThuVien[] a) {
		for(int i = 0; i < 6; i++) {
			if(a[i] instanceof SachThamKhao)
				System.out.println(a[i].toString());
		}
	}
	public static double TongTienGK(QuanLyThuVien[] a) {
		double tong = 0;
		for(int i = 0; i < 6; i++) {
			if(a[i] instanceof SachGiaoKhoa) {
				tong += a[i].tinhTien();
			}
		}
		return tong;
	}
	public static double TongTienTK(QuanLyThuVien[] a) {
		double tong = 0;
		for(int i = 0; i < 6; i++) {
			if(a[i] instanceof SachThamKhao) {
				tong += a[i].tinhTien();
			}
		}
		return tong;
	}
	
	public static void timThanhTienCaoNhat(QuanLyThuVien[] a) {
		DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
		if(TongTienGK(a) > TongTienTK(a)) {	 
			System.out.printf("\n Tổng thành tiền cao nhất là sách giáo khoa: %s \n",df.format(TongTienGK(a)));
		}else {
			System.out.printf("\n Tổng thành tiền cao nhất là sách tham khảo: %s \n",df.format(TongTienTK(a)));;
		}
	}
	public static void nhapK(QuanLyThuVien [] a) {
		System.out.print("Nhập nhà xuất bản: ");
		Scanner sc = new Scanner(System.in);
		String nhaxuatban = sc.nextLine();
		System.out.println(SachGiaoKhoa.tieude());
		for(int i = 0; i < 6 ; i++) {
			if(a[i].getNhaXuatBan().equals(nhaxuatban)) {
			System.out.println(a[i].toString());
			}
		}
	}
}
