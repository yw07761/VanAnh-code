package hoHoangVanAnh.phan03;

import java.util.Scanner;

/**
 * Viết chương trình in ra số lần kí tự ‘a’ xuất hiện trong một chuỗi.
 * @author VANANH
 *
 */
public class Bai09 {
		public static void main(String[] args) {
			  String chuoi;
		      int soLan = 0;
		      try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Nhap vao 1 chuoi: ");
				  chuoi = sc.nextLine();
			}

		      char mangKiTu[] = chuoi.toCharArray();
		      for (int i = 0; i < mangKiTu.length; i++)
		      {
		         if ('a' == mangKiTu[i])
		         {
		            soLan++;
		         }
		      }
		      System.out.println("số lần kí tự ‘a’ xuất hiện trong chuỗi: " +soLan);
		   }
}

