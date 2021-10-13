package hinhTron;

public class Test {
	public static void main(String[] args) {
		// Test constructors and toString()
	      Circle c1 = new Circle(1.1, "blue");
	      System.out.println(c1);  // toString()
	      Circle c2 = new Circle(2.2);
	      System.out.println(c2);  // toString()
	      Circle c3 = new Circle();
	      System.out.println(c3);  // toString()

	      // Test Setters and Getters
	      c1.setRadius(2.2);
	      c1.setColor("green");
	      System.out.println(c1);  
	      System.out.println("radius : " + c1.getRadius());
	      System.out.println("color : " + c1.getColor());

	      // Test getArea() 
	      System.out.printf("Dien Tich hinh tron: %.2f%n", c1.getTinhDienTich());
	}
}
