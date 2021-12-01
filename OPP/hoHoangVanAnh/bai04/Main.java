package hoHoangVanAnh.bai04;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#,##0 VNĐ");
		QuanLyNhaDat[] a= new QuanLyNhaDat[6];
		a[0] = new Dat("A111", LocalDate.of(2020, 12, 12), 50000, 5,"A" );
		a[1] = new Dat("A112", LocalDate.of(2013, 9, 10), 70000, 9, "B");
		a[2] = new Dat("A123", LocalDate.of(2020, 10, 23), 70000, 10, "C");
		a[3] = new Nha("B111", LocalDate.of(2020, 12, 04), 65000, 12, "cao cấp");
		a[4] = new Nha("B112", LocalDate.of(2020, 9, 30), 75000, 90, "thường");
		a[5] = new Nha("B123", LocalDate.of(2020, 8, 30), 95000, 50, "cao cấp");
		
		System.out.println("============================QUAN LY NHA DAT===================================");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("=============================Quan Ly Dat======================================");
		System.out.println(Dat.tieudeu());
		xuatthongtinDat(a);
		System.out.println("Tổng diện tích đất là: " + TongGDDat(a));
		System.out.println("=============================Quan Ly Nha======================================");
		System.out.println(Nha.tieudeu());
		xuatthongtinNha(a);
		System.out.println("Tổng diện tích nhà là: " + TongGDnha(a));
		System.out.println("==============================================================================");
		System.out.printf("\nTrung bình thành tiền của giao dịch tiền tệ là %s \n",df.format(trungbinhthanhtien(a)/6));
		XuatRaGiaoDich(a);
		System.out.println("------------------------------------------------------------------------------");
		}
		public static void xuatthongtinDat(QuanLyNhaDat[] a) {
			for(int i = 0; i < 6; i++) {
				if(a[i] instanceof Dat) {
					System.out.println(a[i].toString());
				}
			}
		}
		public static void xuatthongtinNha(QuanLyNhaDat[] a) {
			for(int i = 0; i < 6; i++) {
				if(a[i] instanceof Nha) {
					System.out.println(a[i].toString());
				}
			}
		}
		
		public static double trungbinhthanhtien(QuanLyNhaDat[] a) {
			double sum = 0;
			for(int i = 0; i < 6; i++) {
				sum += a[i].tinhTien();
			}
			return sum;
		}
		public static double TongGDDat(QuanLyNhaDat[] a) {
			double tongdat = 0;
			for(int i = 0; i < 6; i++) {
				if(a[i] instanceof Dat) {
					tongdat += a[i].getDienTich();
				}
			}
			return tongdat;
		}

		public static double TongGDnha(QuanLyNhaDat[] a) {
			double tongNha = 0;
			for(int i = 0; i < 6; i++) {
				if(a[i] instanceof Nha) {
					tongNha += a[i].getDienTich();
				}
			}
			return tongNha;
		}
		public static void XuatRaGiaoDich(QuanLyNhaDat[] a) {
			for(int i = 0; i < 6; i++) {
				if(a[i].getNgayGiaoDich() ==LocalDate.of(2019, 9, 10)) {
					System.out.println(a[i].toString());
				}
			}
		}
}
