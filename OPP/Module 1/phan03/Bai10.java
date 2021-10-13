package hoHoangVanAnh.phan03;
/**
 * Viết hàm tách chuỗi gốc thành chuỗi con. 
 * @author VANANH
 *
 */
import java.util.Scanner;
public class Bai10 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String chuoi;
	    char kyTu;
	    try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Nhap vao 1 chuoi: ");
			chuoi = scanner.nextLine();
		}	         
	    for (int i = 0; i < chuoi.length(); i++) {
	        kyTu = chuoi.charAt(i);	             	        
	        if (Character.isSpace(kyTu)) {	        
	            System.out.println();
	        } else {	            
	            System.out.print(kyTu);
	        }
	    }
	}
}



