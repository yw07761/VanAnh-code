package hoHoangVanAnh.bai05;

import java.time.LocalDate;
import java.util.Scanner;

public class Test {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhMucHangHoa dshh = new DanhMucHangHoa();
		dshh.themHH(new HangDienMay("1", "�?i�?u hòa", 2000, 10, 12, 10));
        dshh.themHH(new HangDienMay("2", "Ấm điện", 1000, 10, 8,10));
        dshh.themHH(new HangSanhSu("3", "Ly", 1000, 6, "A", LocalDate.of(2020, 12, 4)));
        dshh.themHH(new HangSanhSu("4", "�?ĩa", 2000, 15, "B", LocalDate.of(2021, 6, 13)));
        dshh.themHH(new HangThucPham("5", "Táo", 500, 100, "D", LocalDate.of(2020,1, 1), LocalDate.of(2021, 1, 1)));
        dshh.themHH(new HangThucPham("6", "Cam", 6000, 20, "C", LocalDate.of(2021, 10, 1), LocalDate.of(2021, 11, 3)));
        System.out.println(dshh.toString());
        Scanner sc = new Scanner(System.in);
        int x;
        
        do {
            System.out.println("MENU\n" + 
            		"1.Thêm một hàng ho�?a vào danh sa�?ch\n" + 
                    "2.Lâ�?y thông tin toàn bộ \n" + 
                    "3.Lâ�?y thông tin Hàng Thực Phẩm\n" + 
                    "4.Lâ�?y thông tin Hàng �?iện Ma�?y\n" +
                    "5.Lâ�?y thông tin hàng Sành Sư�? \n" +
                    "6.Tìm kiê�?m hàng ho�?a khi biê�?t mã hàng \n" +
                    "7.Să�?p xê�?p hàng ho�?a theo tên tăng dần \n"+ 
                    "8.Să�?p xê�?p hàng ho�?a theo sô�? lượng tồn giảm dần \n" + 
                    "9.Lâ�?y thông tin hàng thực phẩm kho�? ba�?n\n" +
                    "10.Xo�?a hàng ho�?a khi biê�?t mã hàng\n" + 
                    "11.Sữa thông tin đơn gia�? khi biê�?t mã hàng\n" + 
                    "0. Thoa�?t");
            System.out.println("\nNhập lựa chọn: ");
            x = sc.nextInt();
            System.out.println("------>>");

            switch (x) {
            case 1:
                System.out.print("\nNhập mã hàng: ");
                int MaHang = sc.nextInt();
                System.out.print("\nNhập tên hàng: ");
                sc.nextLine();
                String TenHang = sc.nextLine();
                System.out.print("\nNhập đơn gia�?: ");
                double DonGia = sc.nextDouble();
                System.out.print("\nNhập sô�? lượng tồn: ");
                int SoLuongTon = sc.nextInt();
                System.out.print("\nNhập thời gian bảo hành: ");
                int tgBH = sc.nextInt();
                System.out.print("\nNhập công suâ�?t: ");
                int CongSuat = sc.nextInt();
                if (dshh.themHH(new HangDienMay(TenHang, TenHang, SoLuongTon, DonGia, CongSuat, CongSuat))) {
                    System.out.println("Danh sa�?ch sau khi thêm");
                    System.out.println(HangDienMay.getTieuDe());
                    System.out.println(dshh);   
                } else {
                    System.out.println("Thêm không thành công");    
                }
                break;
            case 2:
                System.out.println(dshh.toString());
                break;
            case 3:
                System.out.println(dshh.XuatHTP()); 
                break;
            case 4:
                System.out.println(dshh.XuatHDM());
                break;
            case 5: 
                System.out.println(dshh.XuatHSS());
                break;
            case 6:
                System.out.print("\nNhập mã cần tìm: ");
                String k = sc.nextLine();
                DanhMucHangHoa ds_MaCanTim = dshh.timMHH(k);
                if (dshh.timMHH(k) != null ) {
                    System.out.println("Không tìm thâ�?y");
                } else {
                    System.out.println("Tìm thâ�?y");
                }
                break;
            case 7: 
                dshh.sapXepTangTheoTen();
                System.out.println("Să�?p xê�?p thành công");
                break;
            case 8:
                dshh.sapXepGiamTheoSoLuongTon();
                System.out.println("Să�?p xê�?p thành công");
                break;
            case 9:
            	System.out.println("thông tin hàng thực phẩm khó bán");
            	if (!dshh.Thongtinkhoaban().equalsIgnoreCase("")) {
					System.out.println(dshh.Thongtinkhoaban());
				}else {
					System.out.println("không có hàng thực phẩm khó bán");
				}
                break;
            case 10: 
                System.out.print("\nNhập mã cần xo�?a: ");
                String maCanXoa = sc.nextLine();
                if (dshh.xoaHH(maCanXoa)) {
                    System.out.println("Xo�?a thành công");   
                } else {
                    System.out.println("Xo�?a không thành công");    
                }
                break;
            case 11:
                System.out.print("\nNhập mã hàng: ");
                String maHang = sc.nextLine();
                System.out.print("\nNhập đơn gia�? mơ�?i: ");
                double donGia_moi = sc.nextDouble();
                if (dshh.suaDonGia(maHang, donGia_moi)) {
                    System.out.println("Sữa thành công");
                } else {
                    System.out.println("Sữa không thành công");
                }
                break;
            case 0:
            	sc.close();
		  		System.out.println("\nKết thúc");
				return;
        }
        
    } while (x != 0);
    System.out.println("");
   
	}
}



