package hoHoangVanAnh.phan03;
import java.util.InputMismatchException;
/**
 * Viết chương trình in ra tổng 1+3+5 …. +n nếu n là số chẵn, 2+4+6+ …. n nếu n là số lẻ.
 * @author VANANH
 *
 */
import java.util.Scanner;
public class Bai03 {
		private static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			try {
				System.out.print("Nhap n = ");
		        int n = scanner.nextInt();
		        if (n<0)
		        	System.out.println("n khong hop le");
		        else {
					if(n % 2 == 0) 
						System.out.println("Tong le = " +(tinhTongLe(n)+n));
					else
						System.out.println("Tong Chan = " +(tinhTongChan(n)+n));
		       }
			}catch (InputMismatchException e) {
				System.out.println("Khong nhap chu !");
		       }	
		}
		static int tinhTongChan (int N) {
			int tong = 0;
			for (int i = 2; i <= N; i++) {
				if(i % 2 == 0)
					tong += i;
			}
			return tong;
		} 
		static int tinhTongLe (int N) {
			int tong = 0;
			for (int i = 1; i <= N; i++) {
				if(i % 2 != 0)
					tong += i;
			}
			return tong;
		} 
}
