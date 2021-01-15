/**
 * Rectangle with corner point at (0,0) and a width and height.
 * @author jim
 */
public class Rectangle extends Shape {
	private double width;
	private double height;
	
	/**
	 * A Rectangle with one corner fixed at (0,0).
	 * @param width the width of rectangle in x-direction
	 * @param height the height of rectangle in y-direction
	 */
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Compute and return the length around the sides of rectangle.
	 * @return total length of rectangle's perimeter
	 */
	@Override
	public double getPerimeter() {
		return 2.0*width + 2.0*height;
	}
	
	public String toString() {
		return String.format("Rectangle with width %.2f, height %.2f", width, height);

	}
}
