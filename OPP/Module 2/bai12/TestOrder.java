package hoHoangVanAnh.bai12;

import java.time.LocalDate;

public class TestOrder {
    public static void main(String[] args) {
        Order test = new Order(1, LocalDate.of(2020, 10, 5));
        test.addLineItem(new Product("Nước Tương", "sp4", 8000), 10);
        test.addLineItem(new Product("Gạo", "sp1", 18000), 5);
        test.addLineItem(new Product("Đường", "sp3", 10000), 1);
        test.addLineItem(new Product("Gạo", "sp1", 18000), 1);

        System.out.println(test);
    }
}