package hinhTron;

public class Circle {
	double radius;
	String color;
	
	
	public Circle() {
	    this(1.0,"red");
	    
	    }
	public Circle(double radius) {
	    this(radius,"red");
	    }
	public Circle(double radius, String color) {
	    this.radius = radius;
	    this.color = color;
	    }
	
	// hanh vi
	public double getRadius(){
		return radius;
		}
	public void setRadius(double radius){
		if(radius > 0)
			this.radius = radius;
		else 
			this.radius = 1.0;
		}
	public String getColor(){
		return color;
		}
	public void setColor(String color){
		if(color.equals("")) // if(color.isEmpty())
			this.color= "red";
		else
			this.color = color;
		}
	public double getTinhDienTich() {
        return this.radius * this.radius * Math.PI;
    }
    public String toString() {
        return "Radius: " + this.radius + " - Color: " + this.color ;
    }
}
