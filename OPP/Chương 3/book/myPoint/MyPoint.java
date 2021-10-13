package c03.myPoint;

/**
 * @author VANANH
 *
 */
public class MyPoint {
	private int x;
	private int y;
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
	public MyPoint() {
		this(0,0);
	}
	public MyPoint(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public int[] getXY() {
		int[] kq = new int [2];
		kq[0]= x;
		kq[1]= y;
		return kq;
		
	}
	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}
	/**
	 // tính khoảng cách giữa 2 tọa độ hiện tại đến (0,0) 
	public double distance() {
		return Math.sqrt((this.x- 0)* (this.x - 0) + (this.y - 0) * (this.y - 0 ));
	}
	 // tính khoảng cách giữa 2 tọa độ hiện tại đến (x,y)
	public double distance(int x2, int y2) {
		return Math.sqrt((this.x - x2)* (this.x - x2) + (this.y - y2) * (this.y - y2 ));
	}
	 // tính khoảng cách giữa 2 tọa độ hiện tại đến tọa độ p
	public double distance( MyPoint p) {
		return Math.sqrt((this.x- p.x)* (this.x - p.x) + (this.y - p.y) * (this.y - p.y ));
	}
	 */
	public String toString() {
		return String.format("(%d,%d)",x,y);
	}
	
}
