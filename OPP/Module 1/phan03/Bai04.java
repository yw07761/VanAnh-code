package hoHoangVanAnh.phan03;
/**
 * Viết chương trình giải phương trình bậc 1.
 * @author VANANH
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Bai04 {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		try {
			int a,b;
			System.out.println("Nhap he so a :");
			a = scanner.nextInt();
			System.out.println("Nhap he so b :");
			b = scanner.nextInt();
			double kq = GiaiPTbac1(a,b);
			System.out.print("Nghiem phuong trinh la= " + kq);
		} catch (InputMismatchException e) {
			System.out.println("khong nhap chu !");
		}catch (Exception e) {
			System.out.println (e.getMessage());
			}
		}
	private static double GiaiPTbac1(int a, int b) throws Exception {
		if (a==0) {
			if (b==0) {
			throw new Exception ("Phuong trinh vo so nghiem");
			}
			else {
			throw new Exception ("Phuong trinh vo nghiem");
			}
		}else {
			double nghiempt = -b / a;
			return nghiempt; 
			}
	
	}
}


