package hoHoangVanAnh.bai05;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
		DanhSachHoaDon [] a = new DanhSachHoaDon[6];
		a[0] = new KhachHangVN("001", "Trần Quốc A", "08/12/2013",100, 2000, "Sinh hoạt", 100);
		a[1] = new KhachHangVN("002", "Nguyễn Văn B","09/09/2018" , 200, 1000, "Kinh doanh", 200);
		a[2] = new KhachHangVN("003", "Trần Văn C", "08/04/2020", 100, 3000, "Sản xuất", 300);
		a[3] = new KhachHangNN("004", "David","10/06/2017", 150, 4000, "Singapore");
		a[4] = new KhachHangNN("005", "Jack", "01/09/2018", 150, 4000, "NewYork");
		a[5] = new KhachHangNN("006", "Mary", "31/09/2018", 150, 4000, "Canada");
		System.out.println("===================================Các hoá đơn của khách hàng Việt Nam=========================================");
		System.out.println(KhachHangVN.tieuDieu());
		XuatThongTinVN(a);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("Tổng số lượng khách hàng VN: " + tinhTongSoLuongKHVN(a));
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("===================================Các hoá đơn của khách hàng nước ngoài=======================================");
		System.out.println(KhachHangNN.tieuDieu());
		XuatThongTinNN(a);
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("Tổng số lượng khách hàng NN: " + tinhTongSoLuongKHNG(a));
		System.out.printf("----------------------------------------------------------------------------------------------------------------");
		System.out.printf("\nTrung bình thành tiền của khách hàng người nước ngoài: %s \n",df.format(tinhTB(a)));
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("=======================Các hoá đơn trong tháng 09 năm 2018 (cùa cả 2 loại khách hàng)===========================");
		System.out.printf("%-10s %-20s %-19s %-11s %-10s %-15s %-10s %-15s\n",
				"Mã KH", "Họ Tên", "Ngày Lập HD", "Số KW", "Đơn Giá", "Loại KH/QT", "Định Mức", "Thành Tiền");
		xuatHoaDonGD(a);
	}
	public static void XuatThongTinVN(DanhSachHoaDon[] a) {
		for(int i =0; i < a.length; i++) {
			if(a[i] instanceof KhachHangVN) {
				System.out.println(a[i]);
			}
		}
	}
	public static void XuatThongTinNN(DanhSachHoaDon[] a) {
		for(int i =0; i < a.length; i++) {
			if(a[i] instanceof KhachHangNN) {
				System.out.println(a[i]);
			}
		}
	}
	public static int tinhTongSoLuongKHNG(DanhSachHoaDon[] a ) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] instanceof KhachHangNN) {
				//sum += a[i].getSoKWTieuThu(); // tinh tong so KW tieu thu
				++sum;
			}
		}	
		return sum;
	}
	public static int tinhTongSoLuongKHVN(DanhSachHoaDon[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] instanceof KhachHangVN) {
				//sum += a[i].getSoKWTieuThu(); // tinh tong so KW tieu thu
				++sum;
			}
		}	
		return sum;
	}
	

	public static double tinhTB(DanhSachHoaDon[] a) {
		long tong = 0;
		long tb = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] instanceof KhachHangNN) {
				tong += a[i].tinhTien();
				tb += tong/a.length;				
			}
		}
		return tb;	
	}
	 public static void xuatHoaDonGD(DanhSachHoaDon [] a) {
		 for (int i = 0; i < a.length; i++) {
			 String[] ngay = a[i].getNgayLapHD().split("/");
			 if(ngay[1].equals("09") && ngay[2].equals("2018")) {
				 System.out.println(a[i].toString());
				}	
			}	
	 }
	
}
