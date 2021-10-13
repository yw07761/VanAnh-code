package hoHoangVanAnh.phan03;

/**
 * Viết chương trình in ra tổng của 10 số chẵn đầu tiên
 * @author VANANH
 *
 */
		
public class Bai12 {
	public static void main(String[] args) {
		int tong = 0;
        for (int i = 0; i < 10; i++)
        	tong +=i*2;
		System.out.println("Tổng của 10 số chẵn đầu tiên : "+tong);	
	}
	
}
