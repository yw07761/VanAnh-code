package hoHoangVanAnh.bai07;

public class HinhTron {
	private  ToaDo tam;
    private double banKinh;

    public HinhTron(ToaDo tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public ToaDo getTam() {
        return tam;
    }

    public void setTam(ToaDo tam) {
        this.tam = tam;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public double tinhChuvi(){
        return banKinh*2*3.14;
    }
    public double tinhDientich(){
        return banKinh*banKinh*3.14;
    }

    @Override
    public String toString() {
        return  "Diện tích và chu vi hình tròn tâm " + tam.getTen() +"(" + tam.getX() + "," + tam.getY() + ") " +
                "có bán kính " + banKinh + "m " + "là " + tinhDientich() + " và " + tinhChuvi();
    }
}
