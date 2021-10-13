package phan01;
/**
 * Viết chương trình nhập vào tên của mình và xuất ra màn hình “Hello + Tên”
 */
import java.util.Scanner;
public class Bai02 { 
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			// nhập tên sử dụng phương thức nextLine()
			System.out.println("Your Name: ");
			String yourName = scanner.nextLine();
			System.out.println(" Hello "+ yourName);
		}
  }
}