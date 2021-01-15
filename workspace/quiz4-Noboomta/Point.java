/**
 * A Point with (x,y) coordinates.  
 * Point is immutable so the x, y coordinates are public.
 */
public class Point {
	public final double x;
	public final double y;
	
	/**
	 * Initialize a new point.
	 * @param x x-coordinate of the point
	 * @param y y-coordinate of the point
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Return the Euclidean distance to another point.
	 * @param pt another point to compute the distance to
	 * @return distance from this point to pt
	 */
	public double distanceTo(Point pt) {
		return Math.hypot(this.x - pt.x, this.y - pt.y);
	}
	
	@Override
	public String toString() {
		return String.format("(%.2f,%.2f)", x, y);
	}
}
