package hoHoangVanAnh.bai06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhMucPhongHoc {
private List<PhongHoc> list;
	
	/**
	 * hàm khởi tạo list
	 */
	public DanhMucPhongHoc() {
		list = new ArrayList<PhongHoc>();
	}
	
	/**
	 * Viết phương thức thêm một phòng học vào danh sách (thêm được nếu không trùng mã phòng). 
	 */
	public boolean themPH(PhongHoc ph) {
		if(list.contains(ph))
			return false;
		list.add(ph);
		return true;
	}
	/**
	 * Viết phương thức tìm kiếm một phòng học nào đó khi biết mã phòng
	 */
	public DanhMucPhongHoc timMP(String maP) {
		DanhMucPhongHoc kg = new DanhMucPhongHoc();
		for (PhongHoc phongHoc : list) {
			if(phongHoc.getMaP().toLowerCase().contains(maP))
				kg.themPH(phongHoc);
		}
		return kg;
	}
	/**
	 * xuất ra toàn bộ phòng học
	 */
	
	@Override
	public String toString() {
		String s = PhongHoc.TieuDe() +  "\n";
		for (PhongHoc phongHoc : list) {
			s += phongHoc + "\n";
		}
		return s;
	}
	/**
	 * xuất ra thông tin phòng học lý thuyết
	 * @return
	 */
	public String xuatPLT() {
		String s = PhongHoc.TieuDeLT() + "\n";
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongLyThuyet)
				s += phongHoc + "\n";
		}
		return s;
	}
	/**
	 * xuất ra thông tin phòng học Máy tính
	 * @return
	 */
	public String xuatPMT() {
		String s = PhongHoc.TieuDeMT() + "\n";
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongMayTinh)
				s += phongHoc + "\n";
		}
		return s;
	}
	/**
	 * xuất ra thông tin phòng học Thí Nghiệm
	 * @return
	 */
	public String xuatPTN() {
		String s = PhongHoc.TieuDeTN() + "\n";
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongThiNghiem)
				s += phongHoc + "\n";
		}
		return s;
	}
	/**
	 * Viết các phương thức để lấy danh sách các phòng học đạt chuẩn.
	 */
	public DanhMucPhongHoc dsPhongHocDatChuan() {
		DanhMucPhongHoc ds = new DanhMucPhongHoc();
		for (PhongHoc phongHoc : list) {
			if(phongHoc.DatChuan())
				ds.themPH(phongHoc);
		}
		return ds;
	}
	
	/**
	 *  Viết phương thức để sắp xếp danh sách tăng dần theo dãy nhà.
	 */
	public void tangdanTheoDayNha() {
		Collections.sort(list,new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}
		});
	}
	/**
	 * Viết phương thức để sắp xếp danh sách giảm dần theo diện tích
	 */
	public void giamdantheoDienTich() {
		Collections.sort(list, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return Float.compare(o2.getDienTich(), o1.getDienTich());
			}
		});
	}
	/**
	 * Viết phương thức để sắp xếp danh sách tăng dần theo số bóng đèn.
	 */
	public void tangdanTheoBongDen() {
		Collections.sort(list,new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.getBongDen(), o2.getBongDen());
			}
		});
		
	}
	/**
	 * Viết phương thức để cập nhật số máy tính cho một phòng máy tính nào đó khi biết mã phòng.
	 */
	public boolean capnhap(String map, int mayTinh_moi) {
		for (PhongHoc phongHoc : list) {
			if(phongHoc.getMaP().equalsIgnoreCase(map))
				if(phongHoc instanceof PhongMayTinh) {
					((PhongMayTinh) phongHoc).setMayTinh(mayTinh_moi);
					return true;
				}
		}
		return false;
	}
	
	/**
	 * Viết phương thức để xóa một phòng học nào đó khi biết mã phòng. Lưu ý khi test chương trình, 
		khi xóa cần phải xác minh rằng có chắc chắn xóa không.
	 */
	public boolean XoaP(String map) {
		return list.removeIf(ph -> ph.getMaP().equalsIgnoreCase(map));
	}
	/**
	 * Viết phương thức để tính tổng số phòng học
	 * truy xuất khích thức phòng học
	 * @return
	 */
	public int getsize() {
		return list.size();
	}
	/**
	 * public String TongPhongHoc() {
			String sum = "";
			for (PhongHoc phongHoc : list) {
				sum += list.size();
			}
			return sum;
		}
	 */
	public String TongPhongHoc() {
			String sum = "";
			for (PhongHoc phongHoc : list) {
				sum += list.size();
			}
			return sum;
		}
	/**
	 * Viết các phương thức để lấy danh sách các phòng máy có 60 máy.
	 */
	public DanhMucPhongHoc DsPhonghocCo60maytinh() {
		DanhMucPhongHoc kg = new DanhMucPhongHoc();
		for (PhongHoc phongHoc : list) {
			if(phongHoc instanceof PhongMayTinh)
				if(((PhongMayTinh) phongHoc).getMayTinh() >= 60)
					kg.themPH(phongHoc);
		}
		return kg;
	}
}
