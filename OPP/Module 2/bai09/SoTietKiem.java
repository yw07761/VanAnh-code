package hoHoangVanAnh.bai09;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SoTietKiem {
    private String maSo;
    private LocalDate ngayMoSo;
    private double soTienGoi;
    private int kyHan;
    private float laiSuat;
    private int soThangGoi;

    /**
     * @return String return the maSo
     */
    public String getMaSo() {
        return maSo;
    }

    /**
     * @param maSo the maSo to set
     */
    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    /**
     * @return LocalDate return the ngayMoSo
     */
    public LocalDate getNgayMoSo() {
        return ngayMoSo;
    }

    /**
     * @param ngayMoSo the ngayMoSo to set
     */
    public void setNgayMoSo(LocalDate ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    /**
     * @param soThangGoi the soThangGoi to set
     */
    public void setSoThangGoi(int soThangGoi) {
        this.soThangGoi = soThangGoi;
    }

    /**
     * @return int return the soThangGoi
     */
    public int getSoThangGoi() {
        return soThangGoi;
    }

    /**
     * @return double return the soTienGoi
     */
    public double getSoTienGoi() {
        return soTienGoi;
    }

    /**
     * @param soTienGoi the soTienGoi to set
     */
    public void setSoTienGoi(double soTienGoi) {
        this.soTienGoi = soTienGoi;
    }

    /**
     * @return int return the kyHan
     */
    public int getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(int kyHan) {
        this.kyHan = kyHan;
    }

    /**
     * @return float return the laiSuat
     */
    public float getLaiSuat() {
        return laiSuat;
    }

    /**
     * @param laiSuat the laiSuat to set
     */
    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    /**
     * @param maSo
     * @param ngayMoSo
     * @param soTienGoi
     * @param kyHan
     * @param laiSuat
     */
    public SoTietKiem(String maSo, LocalDate ngayMoSo, int soThangGoi, double soTienGoi, int kyHan, float laiSuat) {
        this.maSo = maSo;
        this.ngayMoSo = ngayMoSo;
        this.soThangGoi = soThangGoi;
        this.soTienGoi = soTienGoi;
        this.kyHan = kyHan;
        this.laiSuat = laiSuat;
    }

    public int tinhSoThangGoiThuc() {
        LocalDate hienTai = LocalDate.now();
        Period chechLech = Period.between(ngayMoSo, hienTai);
        int result = 0;
        if (ngayMoSo.isBefore(LocalDate.now()))
            result = chechLech.getMonths();
        else if (ngayMoSo.isAfter(LocalDate.now()))
            result = kyHan;
        return result;
    }

    public double tinhTienLai() {
        return soTienGoi * laiSuat * tinhSoThangGoiThuc();
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");

        return String.format("%s - ngày mở %10s Kỳ hạn %d tháng, lãi suất %.3f - Số tháng gởi: %d; Tiền lãi: %s", 
        maSo, dtf.format(ngayMoSo), kyHan, laiSuat, getSoThangGoi(), df.format(tinhTienLai()));
    }
}