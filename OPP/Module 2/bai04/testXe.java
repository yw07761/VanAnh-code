package hoHoangVanAnh.bai04;

public class testXe {
	public static void main(String[] args) {
	    Xe xe1 = new Xe("Nguyễn Thu Loan","Future Neo",100,350000000);
	    Xe xe2 = new Xe("Lê Minh Tính","Ford Ranger",3000,250000000);
	    Xe xe3 = new Xe("Nguyễn Minh Triết","Landscape",1500,1000000000);

	    System.out.println(String.format("%-30s %-15s %-25s %-20s %-15s"
	            ,"Tên chủ xe" , "Loại xe" , "Trị giá xe" , "Dung Tích xylanh" , "Thuế"));
	    System.out.println(xe1);
	    System.out.println(xe2);
	    System.out.println(xe3);

	    }
}
