package hoHoangVanAnh.phan03;

import java.util.InputMismatchException;

/**
 * Viết chương trình in ra bội số của 3 từ 300 đến 3.
 * @author VANANH
 *
 */
public class Bai17 {
	public static void main(String args[]){
		try {
			int dem=0;
			for(int i=0;i<=300;i++)
				if(i%3==0){
					dem=dem+1;
				}
			System.out.println("Co "+dem+" so la boi so cua 3 tu 300 den 3\n");
			for(int i=1;i<=300;i++)
				if(i%3==0)
				{
				System.out.print(" "+i);
				}
		} catch (InputMismatchException e) {
			System.out.println("khong nhap chu !");
	       }	
	}
}
