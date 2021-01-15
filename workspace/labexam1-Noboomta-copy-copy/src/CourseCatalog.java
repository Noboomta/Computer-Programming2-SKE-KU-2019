package src;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * University Course Catalog containing all the courses you can enroll in.
 */
public class CourseCatalog {
	private static final String COURSELIST = "resource/courses.txt";
	private Map<String,Course> courses;
	private static CourseCatalog instance;
	
	/** Initialize the course catalog using course data from a file. */
	private CourseCatalog() {
		courses = makeCourseCatalog();
	}
	
	/**
	 * Get a singleton instance of the CourseCatalog class.
	 * This is not thread-safe.
	 * @return instance of this class.
	 */
	public static CourseCatalog getCourseCatalog() {
		if (instance == null) instance = new CourseCatalog();
		return instance;
	}
	
	/**
	 * Find one course by its course id.
	 * @param id the id of the course
	 * @return matching Course or null if no course with this id.
	 */
	public Course getCourse(String id) {
		return courses.get(id);
	}
	
	/**
	 * Get all courses in the course catalog.
	 * @return List of all courses in the course catalog.
	 * It is the caller's responsibility not to modify the collection.
	 */
	public Collection<Course> getCourses() {
		return courses.values();
	}
	
	/** 
	 * Add a course to the course catalog. 
	 * No check is made that the course id is unique. 
	 * @param course is the course to add to catalog
	 */
	public void addCourse(Course course) {
		courses.put(course.getId(), course);
	}
	
	/**
	 * Create the course data. This reads data from COURSELIST file.
	 * @return collection of courses
	 */
	private Map<String,Course> makeCourseCatalog() {
		Map<String,Course> courses = new TreeMap<>();
		InputStream in = this.getClass().getResourceAsStream(COURSELIST);
		if (in == null) {
			System.out.println("Course data file is missing: "+COURSELIST);
			return courses;
		}
		Scanner scanner = new Scanner(in);
		while( scanner.hasNextLine() ) {
			String data = scanner.nextLine().trim();
			if (data.startsWith("#")) continue; // skip comment line
			if (data.isEmpty()) continue; // skip blank line
			Course c = makeCourse(data);
			courses.put(c.getId(), c );
		}
		scanner.close();
		return courses;
	}
	
	/**
	 * Make a course using data in a string of comma-separated values,
	 * having the form: "id,course-title,credits,difficulty"
	 * @param data string of CSV course values
	 * @return course object 
	 */
	private static Course makeCourse(String data) {
		String [] args = data.split("\\s*,\\s*");
		if (args.length < 3) throw new IllegalArgumentException("Course string must contain 4 CSV values");
		String id = args[0];
		String name = args[1];
		int credits = Integer.parseInt(args[2]);
		// if no difficulty specified then its unrated
		double rating = (args.length > 3)? Double.parseDouble(args[3]) : 0;
		return new Course(id, name, credits, rating);
	}
}
