package c03.myPoint;

public class PolyLine {
	private MyPoint [] points;
	private int count;
	
	//hàm khởi tạo
	public PolyLine (int n) {
		points = new MyPoint[n];
		count = 0; // hiện tại mảng MyPoint = 0
	}
	//Thêm point
	public boolean appendPoint(MyPoint p) {
		if(count >= points.length)
			return false;
		points[count]=p;
		count ++;
		return true;
		
	}
	public String toString() {
		String s="";
		for(int i=0; i< count; i++) {
			s+=points[i].toString()+"";
		}
		return s;
	}
	public int getLength() {
		return count;
	}
}
