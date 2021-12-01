package hoHoangVanAnh.bai01;

import java.text.DecimalFormat;

public class Main {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,##0 VND");
		ChuyenXe [] a = new ChuyenXe[4];
		a[0] = new ChuyenXeNoiThanh("001", "Nguyễn Văn An", "86C-145466", 3000000.00, 50, 250);
        a[1] = new ChuyenXeNoiThanh("002", "Nguyễn Tiến Dũng", "86C-575734", 1500000.00, 65, 150);
        a[2] = new ChuyenXeNgoaiThanh("003", "Trần Văn An", "49F-856888", 3000000.00, "TP HCM", 04);
        a[3] = new ChuyenXeNgoaiThanh("004", "Nguyễn Thị Hoa", "49F-897812", 5000000.00, "Hà Nội",07);
        
		System.out.println("------------------------Thông tin chuyến xe nội thành-------------------");
        System.out.println(ChuyenXeNoiThanh.Ghitieude());;
        xuatDanhSachXeNoiThanh(a);
        System.out.printf("\n tổng doanh thu chuyến xe nội thành  là %s \n",
				df.format(tinhTongDanhThuCXNoiThanh(a)));
        System.out.println("------------------------Thông tin chuyến xe ngoại thành-------------------");
        System.out.println(ChuyenXeNgoaiThanh.Ghitieude());
        xuatDanhSachXeNgoaiThanh(a);
        System.out.printf("\n tổng doanh thu chuyến xe ngoại thành %s \n",
				df.format(tinhTongDanhThuCXNgoaiThanh(a)));
        System.out.println("------------------------------Tổng danh thu-------------------------------");
        System.out.printf("\n	tổng doanh thu là %s",
				df.format(tinhTongDoanhThu(a)));
		//System.out.println("Danh sach chuyen xe:");
		//xuatDsChuyenXe(a);
		
		
		
		
	}
	/**
	 * hàm in ra chuyến xe
	 * @param a
	 */
	   public static void xuatDanhSachXeNoiThanh(ChuyenXe [] a) { 
	        for (int i = 0; i < 4; i++) {
	        	if(a[i] instanceof ChuyenXeNoiThanh) {
	        		System.out.println(a[i].toString());
	        	}     
	        }
	   }
	    public static void xuatDanhSachXeNgoaiThanh(ChuyenXe [] a) { 
	        for (int i = 0; i < 4; i++) {
	            if (a[i] instanceof ChuyenXeNgoaiThanh) {
	                System.out.println(a[i].toString());  
	            }    
	        }     
	    }
	public static void xuatDsChuyenXe (ChuyenXe[] a) {
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
	private static double tinhTongDoanhThu (ChuyenXe[] a) {
		// TODO Auto-generated method stub
		double s=0;
		for(int i=0;i< a.length;i++) {
			s+=a[i].getDoanhThu();
		}
		return s;

	}
	public static double tinhTongDanhThuCXNoiThanh(ChuyenXe[] a) {
		double s=0;
		for(int i=0;i< a.length;i++) {
			if(a[i] instanceof ChuyenXeNoiThanh)
			s+=a[i].getDoanhThu();
		}
		return s;
	}
	public static double tinhTongDanhThuCXNgoaiThanh(ChuyenXe[] a) {
		double s=0;
		for(int i=0;i< a.length;i++) {
			if(a[i] instanceof ChuyenXeNgoaiThanh)
			s+=a[i].getDoanhThu();
		}
		return s;
	}
}
