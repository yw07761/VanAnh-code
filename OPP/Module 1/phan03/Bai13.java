package hoHoangVanAnh.phan03;
/**
 *Viết chương trình in ra những số lẻ từ 1 đến 99.
 * @author VANANH
 *
 */
public class Bai13 {
    public static void main(String[] args) {
        System.out.printf(" những số lẻ từ 1 đến 99: \n" );
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0) {  // (i % 2 == 1);
                System.out.print(i + " ");
            }
        }
    }
}