package hoHoangVanAnh.bai09;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        KhachHang a = new KhachHang("KH001", "Nguyễn Văn An", 2);
        a.themSoTietKiem("STK111", LocalDate.of(2020, 3, 26), 6, 1000000, 3, 0.005f);
        a.themSoTietKiem("STK112", LocalDate.of(2020, 3, 26), 6, 10000000, 6, 0.006f);

        System.out.println(a.toString());
    }
}