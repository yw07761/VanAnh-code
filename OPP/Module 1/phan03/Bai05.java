package hoHoangVanAnh.phan03;
/**
 * Viết chương trình tìm USCLN của 2 số nhập vào.
 */
import java.util.InputMismatchException;

import java.util.Scanner;
public class Bai05 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	try {
    		System.out.print("Nhap so a = ");
            int a = scanner.nextInt();
            System.out.print("Nhap so b = ");
            int b = scanner.nextInt();
            System.out.println("USCLN cua " + a + " va  " + b + " la : " + USCLN(a, b));
		} catch (InputMismatchException e) {
			System.out.println("khÃ´ng nháº­p chá»¯");
			}       
    }
     
    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }   
}
