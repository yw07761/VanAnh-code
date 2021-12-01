package hoHoangVanAnh.bai05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class DanhMucHangHoa {
	private List<HangHoa> list;

	public DanhMucHangHoa() {
		list = new ArrayList<HangHoa>();
	}
	
	/**
	 * thêm một hàng hóa 
	 * nếu trùng mã thì không thêm đc
	 * @param hh
	 * @return
	 */
	public boolean themHH(HangHoa hh) {
		if(list.contains(hh))
			return false;
		else
			list.add(hh);
			return true;
	}
	/**
	 * lấy thông tin toàn bộ danh sách các hàng hóa
	 */
	@Override
	public String toString() {
		String s = HangHoa.getTieuDe() + "\n";
		for (HangHoa hangHoa : list) {
			s += hangHoa + "\n";
		}
		return s;
	}
	/**
	 * xuất ra thông tin hàng thực phẩm
	 * @return
	 */
	public String XuatHTP() {
		String s = HangThucPham.getTieuDe() + "\n";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangThucPham)
				s += hangHoa +"\n";
		}
		return s;
	}
	/**
	 *  xuất ra thông tin hàng điện máy
	 * @return
	 */
	public String XuatHDM() {
		String s = HangDienMay.getTieuDe() + "\n";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangDienMay)
				s += hangHoa + "\n";
		}
		return s;
	}
	/**
	 * xuất ra thông tin hàng sành sứ
	 * @return
	 */
	public String XuatHSS() {
		String s = HangSanhSu.getTieuDe() + "\n";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangSanhSu)
				s += hangHoa + "\n";
		}
		return s;
	}
	/**
	 * Viết phương thức tìm kiếm hàng hóa khi biết mã hàng (trả v�? hàng hóa tìm thấy).
	 * @param maH
	 * @return
	 */
	public DanhMucHangHoa timMHH(String maH) {
		DanhMucHangHoa ds = new DanhMucHangHoa();
		for (HangHoa hangHoa : list) {
			if(hangHoa.getMaHang().toLowerCase().contains(maH))
				ds.themHH(hangHoa);
		}
		return ds;
	}
	/**
	 * Viết phương thức sắp xếp hàng hóa theo tên hàng tăng dần.
	 */
	public void sapXepTangTheoTen() {
		Collections.sort(list, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return o1.getTenHang().compareToIgnoreCase(o2.getTenHang());
			}
		});
	}
	/**
	 * Viết phương thức sắp xếp hàng hóa theo số lượng tồn giảm dần.
	 * dùng Integer.compare
	 */
	public void sapXepGiamTheoSoLuongTon() {
		Collections.sort(list, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.getSoLuongTon(), o1.getSoLuongTon());
			}
		});
	}
	/**
	 * Viết phương thức lấy thông tin các hàng thực phẩm khó bán.
	 */
	public String Thongtinkhoaban() {
		String s = HangThucPham.getTieuDe() + "\n";
		for (HangHoa hangHoa : list) {
			if(hangHoa instanceof HangThucPham)
				if(hangHoa.mucDoBanBuon() == MucDoBuonBan.KhoBan)
					s += hangHoa + "\n";
		}
		return s;
	}
	/**
	 * Viết các phương thức xóa hàng hóa khi biết mã hàng.
	 * cách 3 : dùng removeif
	 * @param mh
	 * @return
	 */
	public boolean xoaHH(String mh) {
		return list.removeIf(hd->hd.getMaHang().equalsIgnoreCase(mh));
	}
	/**
	 * Viết các phương thức sửa thông tin đơn giá của hàng hóa khi biết mã hàng.
	 * sủa đc thì return true không sữa được thì return false
	 * @param mh
	 * @param dongia_moi
	 * @return
	 */
	public boolean suaDonGia(String mh, double dongia_moi) {
		for (HangHoa hangHoa : list) {
			if(hangHoa.getMaHang().equalsIgnoreCase(mh)) {
				hangHoa.setDonGia(dongia_moi);
				return true;
			}
		}
		return false;
		
	}
}

