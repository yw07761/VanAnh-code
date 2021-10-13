package phan02;

public class PrePostDemo {
	public static void main (String [] args) {
		int i =3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(--i);
		System.out.println(i--);
		System.out.println(i);
	}
}
// dòng 7 sẽ xuất ra i = 4 sau khi ta khai báo i = 3 và i++ sẽ tăng i lên 1 đơn vị
// dòng 9 kq = 5, ++i sẽ tăng giá trị của i, và sau đó trả về giá trị tăng.