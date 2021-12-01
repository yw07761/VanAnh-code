package bai01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachNganHang {
	private List<NganHang> list;
	
	/**
	 * hàm khởi tạo list
	 */
	public DanhSachNganHang() {
		list = new ArrayList<NganHang>();
	}
	/**
	 * thêm vào 1 tài khoản không thêm nếu trùm mã
	 * @param tk
	 * @return
	 */
	public boolean ThemTK(NganHang tk) {
		if(list.contains(tk))
			return false;
		list.add(tk);
		return true;
	}
	
	
	/**
	 * in ra toàn bộ
	 */
	@Override
	public String toString() {
		String s = NganHang.tieude() +  "\n";
		for (NganHang nganHang : list) {
			s += nganHang + "\n";
		}
		return s;
	}
	/**
	 * xuất thẻ ghi nơ
	 * @return
	 */
	public String xuatTGN() {
		String s = TheGhiNo.tieude() + "\n";
		for (NganHang nganHang : list) {
			if(nganHang instanceof TheGhiNo)
			s += nganHang + "\n";
		}
		return s;
	}
	/**
	 * xuất thẻ tín dụng
	 * @return
	 */
	public String xuatTTD() {
		String s = TheTinDung.tieude() + "\n";
		for (NganHang nganHang : list) {
			if(nganHang instanceof TheTinDung)
			s += nganHang + "\n";
		}
		return s;
	}
	/**
	 * Sửa hạn mức tín dụng khi biết mã thẻ.
	 * @param maThe
	 * @param hanMuc_moi
	 * @return
	 */
	public boolean suahanmuc(int maThe, int hanMuc_moi) {
		for (NganHang nganHang : list) {
			if(nganHang.getMaThe() == maThe) {
				if(nganHang instanceof TheTinDung) {
					((TheTinDung) nganHang).setHanMuc(hanMuc_moi);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Đếm số lượng các tài khoản không còn khả năng chi tiêu.
	 * @return
	 */
	public int Tkkhonghongkhanangchitieu() {
		for (NganHang nganHang : list) {
			if(nganHang.KhaNangchitieu() == false)
				getsize();
		}
		return list.size();
	}
	
	public int getsize() {
		return list.size();
	}
	/**
	 * sắp xếp giảm dẫn mã thẻ
	 */
	public void sapxepmathegiamgian() {
		Collections.sort(list, new Comparator<NganHang>() {

			@Override
			public int compare(NganHang o1, NganHang o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o2.getMaThe(), o1.getMaThe());
			}
		});
	}
	
	
}

