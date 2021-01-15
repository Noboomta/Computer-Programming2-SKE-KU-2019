/**
 * Create a drawing containing some shapes and
 * compute their perimeter.
 */
public class Main {
	/**
	 * Describe a shape and its perimeter.
	 * @param arg is a circle, rectangle, or other shape to describe 
	 */
	//TODO Modify this to use inheritance and polymophism.
	//TODO Don't use "instanceof" or a cast.
	public static void describeShape(Shape shape) {

		System.out.println(shape);
		// System.out.println(shape.circumference());
		System.out.printf("Perimeter: %.2f\n",shape.getPerimeter());

	}
	
	public static void main(String[] args) {
		// create some shapes
		//TODO Modify this to use inheritance
		Shape[] shapes = {
				new Circle(0, 0, 4.0),
				new Rectangle(5.0, 6.0),
				new Triangle(new Point(1,1), new Point(1,4), new Point(4,5)),
				new Circle(1, 2, 2.0)
		};
		
		// describe each shape
		System.out.println("The drawing contains:");
		for(Shape o: shapes) describeShape(o);

		Polygon p = new Polygon(new Point(1,1), new Point(1,4), new Point(4,5), new Point(5,10));
		System.out.println(p);
		System.out.printf("Perimeter: %.2f\n",p.getPerimeter());
	}
}
