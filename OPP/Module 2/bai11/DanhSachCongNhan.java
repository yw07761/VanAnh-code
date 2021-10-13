package hoHoangVanAnh.bai11;

public class DanhSachCongNhan extends CongNhan{
    static CongNhan[] arr = new CongNhan[5];
    public DanhSachCongNhan(){
    }
    public void addCN(CongNhan cn1){
        int dem = 0;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] == null){
               arr[i] = cn1;
                break;
            }
            if(arr[i] != null){
                dem++;
            }
            if(dem == arr.length)
                System.out.println("Danh sach day ko the them !");
        }
    }
    public String toStringList(){
        System.out.println("> DANH SACH CONG NHAN VIEN <");
        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                "MaSo" , "Ho" , "Ten","SoSP","Luong"));
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                        arr[i].getMaCN() , arr[i].getmHo() , arr[i].getmTen() , arr[i].getmSoSP() ,
                       String.format("%.2f" , arr[i].tinhLuong())));
            }
        }
         return "";
    }
    public static int soCN(){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null)
                count++;
        }
        return count;
    }


    public static void hardCN(){
        System.out.println("Nhung Cong Nhan Lam Tren 200 SP");
        System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                "MaSo" , "Ho" , "Ten","SoSP","Luong"));
        double  n = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                n = arr[i].getmSoSP();
                if(n > 200){
                    System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                        arr[i].getMaCN() , arr[i].getmHo() , arr[i].getmTen() , arr[i].getmSoSP() ,
                        String.format("%.2f" , arr[i].tinhLuong())));
            }
          }
        }
    }
    public static void soft(){
        System.out.println("> DANH SACH CONG NHAN VIEN DA DUOC SAP XEP THEO SO SP GIAM GIAN <");
        int n = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null) n = arr[i].getmSoSP();
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] != null) m = arr[j].getmSoSP();
                if( n <= m){
                    CongNhan swap =  arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
            }
        }
            System.out.println(String.format("%-15s %-15s %-15s %-15s %-15s",
                    arr[i].getMaCN() ,
                    arr[i].getmHo() ,
                    arr[i].getmTen() ,
                    arr[i].getmSoSP() ,
                    String.format("%.2f" , arr[i].tinhLuong())));}

    }

}