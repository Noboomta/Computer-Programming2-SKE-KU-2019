/**
 * Circle with a given radius and center.
 */
public class Circle extends Shape {
	private Point center;
	private double radius;
	
	/** Create a circle with given center and a given radius. */
	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/** Create a circle with center at (x,y) and a given radius. */
	public Circle(double x, double y, double radius) {
		this(new Point(x,y), radius);
	}
	
	public String toString() {
		return String.format("Circle at %s, radius %f", center.toString(), radius);
	}
	
	/**
	 * Get the circumference of the circle
	 */
	@Override
	public double getPerimeter() {
		return 2.0*Math.PI*this.radius;
	}
}
