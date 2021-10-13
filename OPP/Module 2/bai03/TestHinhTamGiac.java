package hoHoangVanAnh.bai03;

public class TestHinhTamGiac {
	  public static void main(String[] args)
	    {
	        HinhTamGiac tamGiac1 = new HinhTamGiac(1, 4, 1);
	        HinhTamGiac tamGiac2 = new HinhTamGiac(-3, 5, 1);
	        HinhTamGiac tamGiac3 = new HinhTamGiac(2, 3, 4);
	        HinhTamGiac tamGiac4 = new HinhTamGiac(4, 4, 3);
	        HinhTamGiac tamGiac5 = new HinhTamGiac(7, 7, 7);

	        System.out.printf("%-10s %-10s %-10s %-20s %-10s %-10s\n", "CanhA", "CanhB", "CanhC", "Kieu Tam Giac", "CV", "DT");
	        System.out.println(tamGiac1.toString());
	        System.out.println(tamGiac2.toString());
	        System.out.println(tamGiac3.toString());
	        System.out.println(tamGiac4.toString());
	        System.out.println(tamGiac5.toString());
	    }
}