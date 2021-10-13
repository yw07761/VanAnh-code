package hoHoangVanAnh.bai11;
public class Test {
    public static void main(String[] args) {
        DanhSachCongNhan ds = new DanhSachCongNhan();
        CongNhan cn = new CongNhan();
        CongNhan cn1 = new CongNhan(001 ,"Tran" , "The" ,150);
        CongNhan cn2 = new CongNhan(002 ,"Le" , "Ki" ,120);
        CongNhan cn3 = new CongNhan(003 ,"Phan" , "Tinh" ,230);
        CongNhan cn4 = new CongNhan(004 ,"Pham" , "Tran" ,250);
        CongNhan cn5= new CongNhan(005 ,"Nguyen" , "Dung" ,620);
        ds.addCN(cn1);
        ds.addCN(cn2);
        ds.addCN(cn3);
        ds.addCN(cn4);
        ds.addCN(cn5);

        System.out.println(cn1.toString());
        System.out.println(ds.toStringList());
        System.out.print("Tổng số công nhân: ");
        System.out.println(ds.soCN());
        DanhSachCongNhan.hardCN();
        DanhSachCongNhan.soft();




    }
}