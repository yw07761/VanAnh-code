package hoHoangVanAnh.bai05;
import java.time.LocalDate;

public class TestHangThucPham {
	    public static void main(String[] args) throws Exception {
	        String maHang = "004";
	        String tenHang = "Bột Giặt";
	        float donGia = 17000;
	        LocalDate ngaySx = LocalDate.of(2020,12, 24);
	        LocalDate ngayHH = LocalDate.of(2021, 12, 24);

	        try
	        {
	            HangThucPham hang1 = new HangThucPham("001", "Gao", 10000000,
	                    LocalDate.of(2020, 7, 10), LocalDate.of(2021, 7, 10));
	            HangThucPham hang2 = new HangThucPham("002", "Mi", 500000,
	                    LocalDate.of(2020, 5, 22), LocalDate.of(2021, 11, 22));
	            HangThucPham hang3 = new HangThucPham("003", "Nước", 1000000,
	                    LocalDate.of(2017, 3, 1), LocalDate.of(2020, 3, 8));

	            System.out.printf("%-10s %-15s %-20s %-10s %20s %15s\n", "MaHang", "TenHang", "DonGia",
	                    "NgaySanXuat", "NgayHetHan", "GhiChu");
	            System.out.println("====================================================================================================");
	            System.out.println(hang1);
	            System.out.println(hang2);
	            System.out.println(hang3);

	            HangThucPham hang4 = new HangThucPham(maHang, tenHang, donGia, ngaySx, ngayHH);
	            System.out.println(hang4);
	        }
	        catch (Exception ex) {
	        }
	    }
}

