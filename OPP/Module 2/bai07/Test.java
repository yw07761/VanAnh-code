package hoHoangVanAnh.bai07;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		// gan
		ToaDo P = new ToaDo("P", 5, 5);
		HinhTron ht1 = new HinhTron(P, 10.5);
		ht1.toString();
		System.out.println(ht1.toString());

		// nhap
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhâp tâm hình tròn : ");
		String ten = sc.next();
		System.out.print("Nhập X : ");
		float x = sc.nextFloat();
		System.out.print("Nhập Y : ");
		float y = sc.nextFloat();
		ToaDo toado = new ToaDo(ten, x, y);

		System.out.print("Nhập bán kính : ");
		double bankinh = sc.nextDouble();
		HinhTron hinhtron = new HinhTron(toado, bankinh);
		System.out.println(hinhtron);

	}
}
