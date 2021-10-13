package hoHoangVanAnh.bai07;

public class ToaDo {
	private String ten;
    private float x;
    private float y;

    public ToaDo(String ten, float x, float y) {
        this.x = x;
        this.y = y;
        this.ten = ten;
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public String toString(){
        String st;
        st = String.format("%s(%f,%f)",getTen(),getX(),getY());
//        st = String.format("Hình tròn có tâm %s(%f,%f) " +
//                        "với bán kính %f có diện tích và chu vi lần lượt là %f và %f.",
//                getTen(),getX(),getY());
        return st;
    }
}
