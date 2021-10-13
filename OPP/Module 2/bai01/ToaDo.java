package hoHoangVanAnh.bai01;

public class ToaDo {
    private int x;
    private int y;
    private String tenToaDo;
    public ToaDo(int x, int y, String tenToaDo) {
        this.x = x;
        this.y = y;
        this.tenToaDo = tenToaDo;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTenToaDo() {
        return tenToaDo;
    }

    public void setTenToaDo(String tenToaDo) {
        this.tenToaDo = tenToaDo;
    }

    @Override
    public String toString() {
        return String.format(tenToaDo + "(" + x + ";" + y + ")");
     
    }

}
