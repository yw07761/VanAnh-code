package hoHoangVanAnh.bai06;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Main {
	


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DanhSachHoaDon a = new DanhSachHoaDon();
		a.themHD(new HoaDonTheoGio("001","nguyen","12b",LocalDate.of(2012, 3, 8), 2000,25));
		a.themHD(new HoaDonTheoGio("002","bao","12b", LocalDate.of(2022, 2, 6), 3000,4));
		a.themHD(new HoaDonTheoGio("003","nguyen","12b",LocalDate.of(2019, 8, 12), 4000,5));
		a.themHD(new HoaDonTheoNgay("004","dung","13b",LocalDate.of(2011, 10, 11), 5000,3));
		a.themHD(new HoaDonTheoNgay("005","dung","14b",LocalDate.of(2013, 5, 11), 2000,4));
		a.themHD(new HoaDonTheoNgay("006","nam", "13b",LocalDate.of(2014, 6, 11), 1000,2));
		System.out.println(a.xuatHDG());
		System.out.println("số lượng hóa đơn theo giờ " + a.thongKeSoLuongHDTheoGio());
		System.out.println(a.xuatHDN());
		System.out.println("số lượng hóa đơn trong ngày " + a.thongKeSoLuongHDTheoNgay());
		System.out.printf("\n tổng thành tiền cao nhất là %s \n",
				new DecimalFormat("#,###").format(a.tinhTongThanhTien(3, 2019)));
		Scanner sc = new Scanner(System.in);
		int n;
		DanhSachHoaDon b = null;
			while(true) {
			 System.out.println("\n\t-----------------------------------");
	            System.out.println("\t0. Exit");
	            System.out.println("\t1. tạo Danh Sách Hóa Đơn");
	            System.out.println("\t2. Them Hoa Don Theo Gio");
	            System.out.println("\t3. Them Hoa Don Theo Ngay");
	            System.out.println("\t4. Hien thi danh sach hoa don");
	            System.out.println("\t5. Hien thi danh sach hoa don");
	            System.out.println("\t6. Hien Thi So Luong Hoa Don Theo Gio");
	            System.out.println("\t7. Hien Thi So Luong Hoa Don Theo Ngay");
	            System.out.println("\t8. Tong thanh tien Hoa Don trong thang");
	            System.out.print("\t\n mời nhập lựa chọn");
	            n = sc.nextInt();
		while (n < 0 || n > 6) {
			System.out.print("\nNhập lại lựa chọn (0-6): ");
			n = sc.nextInt();
			}
		if(b == null && n > 1) {
			System.out.println("\nVui lòng khởi tạo Danh Sach Hóa Đơn");
		}else {
		  int month;
		int year;
		switch (n) {
		  	case 1 : 
		  			b = new DanhSachHoaDon();
		  		break;
		  	case 2 :
		  		HoaDonTheoGio hd = new HoaDonTheoGio();
		  		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  		System.out.print("\nnhập mã hóa đơn ");
		  		hd.setMahoadon(sc.nextLine());
		  		sc.nextLine();
		  		System.out.print("\nnhập tên KH ");
		  		//hd.setTenKH(sc.nextLine());
		  		sc.nextLine();
		  		System.out.print("\nnhập mã phòng ");
		  		hd.setMaphong(sc.nextLine());
		  		//sc.nextLine();
		  		System.out.print("\nnhập ngày hóa đơn ");
		  		dtf.parse(sc.nextLine());
		  		System.out.print("\nnhập đơn giá");
		  		hd.setDongia(sc.nextDouble());
		  		System.out.print("\nnhập giờ thuê: ");
		  		hd.setGioThue(sc.nextInt());
		  		if(b.themHD(hd))
		  			System.out.println("thêm vào hóa đơn giờ thành công");
		  		else
		  			System.out.println("thêm vào hóa đơn giờ không thành công");
		  		break;
		  	case 3 :
		  		DateTimeFormatter dtfn = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  		HoaDonTheoNgay hdn = new HoaDonTheoNgay();
		  		System.out.print("\nnhập mã hóa đơn ");
		  		hdn.setMahoadon(sc.nextLine());
		  		sc.nextLine();
		  		System.out.print("\nnhập tên KH ");
		  		//sc.nextLine();
		  		hdn.setTenKH(sc.nextLine());
		  		System.out.print("\nnhập ngày hóa đơn ");
		  		dtfn.parse(sc.nextLine());
		  		System.out.print("\nnhập đơn giá");
		  		hdn.setDongia(sc.nextInt());
		  		System.out.print("\nnhập ngày thuê: ");
		  		hdn.setSoNgayThue(sc.nextInt());
		  		if(b.themHD(hdn))
		  			System.out.println("thêm vào hóa đơn ngày thành công");
		  		else
		  			System.out.println("thêm vào hóa đơn ngày không thành công");
		  		break;
		  	case 4 :
		  			System.out.println(b.xuatHDG());
		  		break;
		  	case 5 : 
		  			System.out.println(b.xuatHDN());
		  		break;
		  	case 6 :
		  		System.out.println("số lượng hóa đơn theo giờ " + b.thongKeSoLuongHDTheoGio());
		  		break;
		  	case 7 :
		  		System.out.println("số lượng hóa đơn trong ngày " + b.thongKeSoLuongHDTheoNgay());
		  		break;
		  	case 8 :
		  		System.out.println("Nhap thang");
                month = sc.nextInt();
                System.out.println("Nhap nam");
                year = sc.nextInt();
                double total = b.tinhTongThanhTien(month, year);
                System.out.printf("\n tổng thành tiền cao nhất là %s \n",
        				new DecimalFormat("#,###").format(total));;
		  		break;
		  	case 0:
		  		sc.close();
		  		System.out.println("\nKết thúc");
				return;
		  }
			
		}
	}
	}
}

