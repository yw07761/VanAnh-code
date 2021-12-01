package hoHoangVanAnh.bai06;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHoaDon {
	private List<HoaDon> list;

	public DanhSachHoaDon() {
		list = new ArrayList<HoaDon>();
	}
	
	public boolean themHD(HoaDon hd) {
        if (list.contains(hd)) {
            return false;
        }
        list.add(hd);
        return true;
    }
	/*
	  public String toString() {
	        String s = HoaDon.getTieuDe() +  "\n";
	        for (HoaDon hoaDon : list) {
	            s += hoaDon + "\n"; 
	        }
	        return s;
	    }
	 
	*/
	public String xuatHDG(){
		String s = HoaDonTheoGio.getTieuDe() + "\n";
		 for (HoaDon hoaDon : list) {
			if(hoaDon instanceof HoaDonTheoGio) {
				s += hoaDon + "\n";
			}
		}
		return s;
	}
	
	public String xuatHDN(){
		String s = HoaDonTheoNgay.getTieuDe() + "\n";
		for (HoaDon hoaDon : list) {
			if(hoaDon instanceof HoaDonTheoNgay) {
				s += hoaDon + "\n";
			}
		}
		return s;
	}
	
	public boolean themHDTheoGio() throws Exception {
        HoaDonTheoGio hdg = new HoaDonTheoGio();
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(hdg)) {
                return false;
            }
        }
        list.add(hdg);
        return true;     
    }
    public boolean themHDThaoNgay() {
        HoaDonTheoNgay hdn = new HoaDonTheoNgay();
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(hdn)) {
                return false;
            }
        }
        list.add(hdn);
        return false;
    }
    public int thongKeSoLuongHDTheoGio() {
        int dem = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof HoaDonTheoGio) {
                dem++;
            }
        }
        return dem;
    }
    public int thongKeSoLuongHDTheoNgay() {
        int dem = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof HoaDonTheoNgay) {
                dem++;
            }
        }
        return dem;
    }
    
    public double tinhTongThanhTien(int month, int year) {
        int sum = 0;
        for (HoaDon hoaDon : list) {
            int hdYear = hoaDon.getNgayLDH().getYear();
            int hdMonth = hoaDon.getNgayLDH().getMonthValue();
            if (hdMonth == month && hdYear == year) {
                try {
                    sum += hoaDon.getThanhTien();
                } catch (Exception e) {
                    e.getMessage();
                }
            } 
        }
        return sum;
    }
	
}

