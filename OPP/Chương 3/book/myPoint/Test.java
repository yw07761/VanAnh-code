package c03.myPoint;

public class Test {
	public static void main ( String[] args) {
		PolyLine po= new PolyLine (10);
		if(!po.appendPoint(new MyPoint(2,3)))
			System.out.println("Vuot qua kich thuoc cho phep !");
		if(!po.appendPoint(new MyPoint(7,4)))
			System.out.println("Vuot qua kich thuoc cho phep !");
		/**MyPoint p = new MyPoint(6,8);
		System.out.println(p.distance()); //sqrt(36,64) =10
		System.out.println(p.distance(10,10));
		System.out.println(p.distance(new MyPoint(10,10)));*/

		po.appendPoint(new MyPoint(2,3));
		po.appendPoint(new MyPoint(7,4));
		System.out.println(po.toString());
		System.out.println("Tong so point = " +po.getLength());
		}
}

