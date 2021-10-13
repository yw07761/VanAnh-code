package hoHoangVanAnh.phan03;
import java.util.InputMismatchException;
/**
 * Viết chương trình đọc một giá trị nguyên từ bàn phím và in ra số đó là số chẵn, lẻ hoặc zero
 * @author VANANH
 *
 */
import java.util.Scanner;
public class Bai16 {
	    public static void main(String[] args) {
	    	try {
	    		Scanner reader = new Scanner(System.in);
		        System.out.print("Nhap number: ");
		        int num = reader.nextInt();
		        if (num == 0) {
		        	System.out.println(num + " la so zero");
		        }
		        else if(num % 2 == 0) {
		            System.out.println(num + " la so chan");
		        }
		        else {
		            System.out.println(num + " la so le");
		        }
		        
			} catch (InputMismatchException e) {
				System.out.println("Khong nhap chu !");
		       }	      
	    }
}
