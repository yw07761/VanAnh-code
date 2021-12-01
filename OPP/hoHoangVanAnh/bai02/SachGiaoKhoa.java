package hoHoangVanAnh.bai02;

import  java.time.LocalDate;

public class SachGiaoKhoa extends QuanLyThuVien {
	// true là mới , false cũ
	private boolean tinhTrang;
	
	public SachGiaoKhoa() {
		super();
		tinhTrang="true" != null;
	}
	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach,ngayNhap,donGia,soLuong,nhaXuatBan);
		setTinhTrang(tinhTrang);
	}
	

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		if(tinhTrang) {
			this.tinhTrang = true; 
		} else {
			this.tinhTrang = false;
		}
	}
	
	/**
	 * hàm tính thành tiền true = mới , false = cũ
	 */
	@Override
	public double tinhTien() {
		if(tinhTrang == false) {
			return (super.tinhTien() * 0.5 );
		}else {
			return super.tinhTien();
		}
	}
	@Override
	public String toString() {
		return String.format("%s %-15b %-10.1f",super.toString(),tinhTrang,tinhTien());
	}
	public static String tieude() {
		return String.format("%-10s %-20s %-20s %-10s %-10s %-15s %-10s", "Mã sách","Ngày nhập","Đơn giá",
				"Số lượng","Nhà sản xuất","Tình trạng","Thành tiền");
	}
}