package hoHoangVanAnh.bai10;

public class TestCD {
	public static void main(String[] args) {
        CD cd1 = new CD(123 , "SomeThing" , 5 , 210000);
        CDList cl1 = new CDList();
        CD cd2 = new CD(124, "Somethingelse" , 3 ,150000);


        //cl1.addCDList();
        cl1.addCDList(cd1);
       // cl1.addCDList();
        cl1.addCDList(cd2);

        System.out.println(String.format("%-15s %-15s %-25s %-15s " ,"MaCD" , "TuaCD" , "So luong bai hat" ,"Gia thanh"));
        System.out.println( cl1.listInfo(cl1.arr));

        System.out.println("Tong so CD : "+cl1.soluongCD(cl1.arr));
        System.out.println("Tong gia CD : "+cl1.tongGiaCD(cl1.arr));
    }
}
