/**
 * A triangle specified by three vertices.
 */
public class Triangle extends Polygon {
	private Point v1;
	private Point v2;
	private Point v3;
	
	/**
	 * Create a triangle with the given vertices.
	 * @param p1 first vertex
	 * @param p2 second vertex
	 * @param p3 third vertex
	 * @precondition the vertices are distinct in (x,y)-plane and not on a line.
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		v1 = p1;
		v2 = p2;
		v3 = p3;
	}
	
	/**
	 * Compute the perimeter of the triangle.
	 * @return perimeter of triangle
	 */
	@Override
	public double getPerimeter() {
		double perimeter = v1.distanceTo(v2) + v2.distanceTo(v3) + v3.distanceTo(v1);
		return perimeter;
	}
	public double get(){
		return getPerimeter();
	}
	
	public String toString() {
		return String.format("Triangle with corners %s, %s, %s", v1, v2, v3);
	}
}
