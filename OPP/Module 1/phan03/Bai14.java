package hoHoangVanAnh.phan03;

import java.util.InputMismatchException;

/**
 * Viết chương trình xuất ra tổng các số là bội số của 7 (từ 1 đến 100).
 * @author VANANH
 *
 */
public class Bai14 {
	public static void main(String args[]){
		try {
			int Sn=0;
			for(int i=0;i<=100;i++)
				if(i%7==0){
					Sn= Sn+i;
				}
			System.out.println(" tổng các số là bội số của 7 (từ 1 đến 100) = "+""+Sn);
		} catch (InputMismatchException e) {
			System.out.println("Khong nhap chu cai, hay nhap lai !");
	       }	
	}
}