package hoHoangVanAnh.bai03;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
		GiaoDich[] a = new GiaoDich[6];
		a[0] = new GiaoDichVang("S100", 1000000, 10, LocalDate.of(2021, 12, 02), "9999");
		a[1] = new GiaoDichVang("S101", 2000000, 30, LocalDate.of(2021, 10, 10), "Tây");
		a[2] = new GiaoDichVang("S102", 1500000, 30, LocalDate.of(2021, 11, 11), "Vàng Y");
		a[3] = new GiaoDichTienTe("A100", 5000000, 10, LocalDate.of(2021, 12, 10),10000, "VND");
		a[4] = new GiaoDichTienTe("A101", 7000000, 15, LocalDate.of(2021, 10, 11),22630.00, "USD");
		a[5] = new GiaoDichTienTe("A102", 8000000, 17, LocalDate.of(2021, 11, 30),25712.02, "EURO");
		
		System.out.println("-----------------------------------Giao Dịch Vàng-------------------------------");
		System.out.println(GiaoDichVang.ghiteudieu());
		XuatVang(a);
		System.out.printf("Tổng số lượng vàng là %s \n",df.format(TongVang(a)));

		System.out.println("-----------------------------------Giao Dịch Tiền Tệ----------------------------");
		System.out.println(GiaoDichTienTe.teudieu());
		XuatTien(a);
		System.out.printf("\n Tổng số lượng tiền tệ là %s \n",df.format(TongTien(a)));
		
		System.out.println("-----------------Trung bình thành tiền của giao dịch tiền tệ--------------------");
		System.out.printf("\n Trung bình thành tiền của giao dịch tiền tệ là %s \n",df.format(TBTien(a)));
	
		System.out.println("\n------------Giao dịch có đơn giá trên 1 tỷ--------------");
		xuatGD(a);
	}
	
	public static void XuatVang(GiaoDich[] a) {
		for(int i = 0; i< a.length; i++) {
			if(a[i] instanceof GiaoDichVang)
				System.out.println(a[i].toString());
		}
	}
	public static void XuatTien(GiaoDich[] a) {
		for(int i = 0; i< a.length; i++) {
			if(a[i] instanceof GiaoDichTienTe)
				System.out.println(a[i].toString());
		}
	}
	public static double TongVang(GiaoDich[] a) {
		double tong = 0;
		for(int i = 0;i< a.length; i++) {
			if(a[i] instanceof GiaoDichVang) {
				tong += a[i].tinhTien();
			}
		}
		return tong;
	}
	public static double TongTien(GiaoDich[] a) {
		double tong = 0;
		for(int i = 0;i< a.length; i++) {
			if(a[i] instanceof GiaoDichTienTe) {
				tong += a[i].tinhTien();
			}
		}
		return tong;
	}
	public static double TBTien(GiaoDich[] a) {
		double tong = 0;
		double tb = 0;
		for(int i = 0; i < 6; i++) {
			if(a[i] instanceof GiaoDichTienTe) {
				tong += a[i].tinhTien();
				tb += tong /3;
			}
		}
		return tb;
	}
	/**
	 * xuất ra giao trên 1 tỷ
	 * @param a
	 */
	public static void xuatGD(GiaoDich[] a) {
		System.out.println(GiaoDichTienTe.teudieu());
		for(int i = 0; i < 6; i++) {
			if(a[i].tinhTien() >= 100000000) {
				System.out.println(a[i].toString());
			}
		}
	}
}
