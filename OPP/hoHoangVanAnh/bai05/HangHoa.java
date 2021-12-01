package hoHoangVanAnh.bai05;
	import java.text.DecimalFormat;
	import java.util.Objects;

public abstract class HangHoa {
		private String maHang;
		private String tenHang;
		private int soLuongTon;
		private double donGia;
		
		
		public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
			super();
			setMaHang(maHang);
			setTenHang(tenHang);
			setSoLuongTon(soLuongTon);
			setDonGia(donGia);
		}
		public HangHoa() {
			this("xxx","xxx",0,0);
		}
		public String getMaHang() {
			return maHang;
		}
		public void setMaHang(String maHang) {
			if(!maHang.trim().equals(""))
				this.maHang = maHang;
			else
				this.maHang = "xxx";
		}
		public String getTenHang() {
			return tenHang;
		}
		public void setTenHang(String tenHang) {
			if(!tenHang.trim().equals(""))
				this.tenHang = tenHang;
			else 
				this.tenHang = "xxx";
		}
		public int getSoLuongTon() {
			return soLuongTon;
		}
		public void setSoLuongTon(int soLuongTon) {
			if(soLuongTon >= 0)
				this.soLuongTon = soLuongTon;
			else
				this.soLuongTon = 0;
		}
		public double getDonGia() {
			return donGia;
		}
		public void setDonGia(double donGia) {
			if(donGia >= 0)
				this.donGia = donGia;
			else
				this.donGia = 0;
		}
		
		
		
		@Override
		public String toString() {
			DecimalFormat df = new DecimalFormat("#,###");
			return String.format("%-10s %-15s %-10d %-10s", maHang,tenHang,soLuongTon,df.format(donGia));
		}
		public abstract MucDoBuonBan mucDoBanBuon();
		
		public abstract double tinhTienVat();
		@Override
		public int hashCode() {
			return Objects.hash(maHang);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HangHoa other = (HangHoa) obj;
			return Objects.equals(maHang, other.maHang);
		}
		
		public static String getTieuDe() {
	        return String.format("%-10s %-15s %-10s %-10s", "Ma hang", "Ten Hang","So Luong Ton","�?ơn giá");
	    }
	}