package hoHoangVanAnh.bai04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachSinhVien {
	private List<SinhVien> list;

	/**
	 * hàm khởi tạo
	 */
	public DanhSachSinhVien() {
		list = new ArrayList<SinhVien>();
	}
	/**
	 * in thông tin sinh viên
	 */
	
	@Override
	public String toString() {
		String s = SinhVien.tieude() + "\n";
		for (SinhVien sinhVien : list) {
			s += sinhVien + "\n";
		}
		return s;
	}
	/**
	 * thêm sinh viên nếu trùng mã thì không thêm đc
	 * @param sv
	 * @return
	 */
	public boolean themSV(SinhVien sv) {
		if(list.contains(sv))
			return false;
		list.add(sv);
		return true;
	}
	/**
	 * xóa sinh viên nhập mã vào
	 * @param maSV
	 * @return
	 */
	public boolean xoaSV(int maSV) {
		return list.removeIf(sv -> sv.getMaSV() == maSV);
	}
	/**
	 * sửa SV không được sữa mã
	 * @param maSV
	 * @param tenSV_moi
	 * @param nam_moi
	 * @return
	 */
	public boolean suaSV(int maSV, String tenSV_moi ,int nam_moi) {
		for (SinhVien sinhVien : list) {
			if(sinhVien.getMaSV() == maSV) {
				sinhVien.setTenSV(tenSV_moi);
				sinhVien.setNam(nam_moi);
				return true;
			}		
		}
		return false;
	}
	/**
	 * tìm kiếm sinh viên theo mã
	 * @param maSV
	 * @return
	 */
	public DanhSachSinhVien timSV(int maSV) {
		DanhSachSinhVien kg = new DanhSachSinhVien();
		for (SinhVien sinhVien : list) {
			if(sinhVien.getMaSV() == maSV)
				kg.themSV(sinhVien);
		}
		return kg;
	}
	/**
	 * tìm kiếm sinh viên theo tên
	 * @param tenSV
	 * @return
	 */
	public DanhSachSinhVien timtenSV(String tenSV) {
		DanhSachSinhVien kg = new DanhSachSinhVien();
		for (SinhVien sinhVien : list) {
			if(sinhVien.getTenSV().toLowerCase().equalsIgnoreCase(tenSV))
				kg.themSV(sinhVien);
		}
		return kg;
	}
	/**
	 * sắp xếp theo mã SV
	 */
	public void xapxeptheomaSV() {
		Collections.sort(list, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getMaSV(), o2.getMaSV());
			}
		});
	}
	
	public int getsize() {
		return list.size();
	}
}
