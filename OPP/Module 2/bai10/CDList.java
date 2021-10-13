package hoHoangVanAnh.bai10;
import java.util.Scanner;
public class CDList  extends CD{
    public static Scanner sc = new Scanner(System.in);

    CD[] arr = new CD[20];
    public boolean listIsEmpty(){
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null)
                result = true;
            else
                result = false;
        }
        return  result;
    }
    public void addCDList(CD a){
       if(listIsEmpty()){
           for (int i = 0; i < arr.length; i++) {
               if(arr[i] == null){
                   arr[i] = a;
                   break;
               }
           }
       }
    }
    public void addCDList() {
        if (listIsEmpty()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == null) {
                    System.out.println("Nhap vao phan tu moi ");
                    System.out.print("Ma CD : ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tua CD : ");
                    String s = sc.nextLine();
                    System.out.print("So Bai Hat: ");
                    int m = sc.nextInt();
                    System.out.print("Gia thanh : ");
                    double b = sc.nextDouble();
                    arr[i] = new CD(n, s, m, b);
                    break;
                }
            }
        }else
            System.out.println("Danh sach da day ko the them !");
    }
    public int soluongCD(CD[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null)
                count++;
        }
        return count;
    }
    public double tongGiaCD(CD[] arr){
        double tong = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                tong += arr[i].getGiaThanh();
            }
        }
        return tong;
    }
    public String listInfo(CD[] arr){
        //String s = null;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
               // s = (String.format("%-15s %-15s %-25s %-15s /n"
                      //  , arr[i].getMaCD(), arr[i].getTuaCD(), arr[i].getSoBH(), arr[i].getGiaThanh()));
                System.out.printf(String.format("%-15s %-15s %-25s %-15s "
                        , arr[i].getMaCD(), arr[i].getTuaCD(), arr[i].getSoBH(), arr[i].getGiaThanh()));
                System.out.println();
            }
        }
    return "";

    }
}