package hoHoangVanAnh.phan03;
/**
 * Viết chương trình nhập vào số nguyên n và thực hiện: Xuất ra màn hình n số đầu tiên của chuỗi Fibonaci (có hai giá trị đầu là 1 và 1).
 *
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai18 {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int num1 = 1, num2 = 1;
		try {
			System.out.print("Nhap n = ");
	        int n = scanner.nextInt();
	        if (n<0)
	        	System.out.println("n khong hop le");
	        else {
	        	System.out.print("Chuoi Fibonacci voi "+n+" so dau tien la : ");
	        }
	        int i=1;
	        while(i<=n)
	        {
	            System.out.print(num1+" ");
	            int sumOfPrevTwo = num1 + num2;
	            num1 = num2;
	            num2 = sumOfPrevTwo;
	            i++;
	        }
	        System.out.println();
		}catch (InputMismatchException e) {
			System.out.println("Khong nhap chu !");
	       }
	}
		
}
