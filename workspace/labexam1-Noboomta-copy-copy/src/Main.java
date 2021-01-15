package src;

import java.util.List;
import java.util.Scanner;

/**
 * this code is a console dialog to test your CourseList class
 * and ComboCourse class.
 * 
 * TODO
 * In the main() method, create a ComboCourse for 01219116 and 01219117
 * and add it to the course catalog.
 * 
 * You don't need to modify the other methods.
 */
public class Main {
	private static final Scanner console = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// The university course catalog
		CourseCatalog catalog = CourseCatalog.getCourseCatalog();
		ComboCourse comboCourse = new ComboCourse("01219118", new Course("01219116","Programming II",3,5), new Course("01219117","Programming II Lab",1,6));
		// TODO Create a ComboCourse  with id "01219118"
		//
		// that combines these courses from the CourseCatalog:
		//      01219116 and 01219117 
		//
		// and add the ComboCourse to the CourseCatalog
		catalog.addCourse(comboCourse);

		
		// then run the interactive console dialog
		consoleDialog(catalog);
	}
	
	/** 
	 * Interactively add/drop courses in a student CourseList 
	 */
	public static CourseList consoleDialog(CourseCatalog catalog) {
		CourseList courselist = new CourseList();
		help();
		loop: 
		while(true) {
			System.out.print("cmd> ");
			String input = console.next();
			switch(input) {
			case "cat":
			case "catalog":
				printCourseCatalog(catalog);
				break;
			case "add":
				String courseId = console.next();
				addCourse(courselist, courseId);
				break;
			case "drop":
				String courseId2 = console.next();
				dropCourse(courselist, courseId2);
				break;
			case "list":
				printCourseList(courselist);
				break;
			case "quit":
			case "exit":
				break loop; // exit the while loop
			case "?":
			case "help":
				help();
				break;
			default:
				System.out.println("Enter a command or enter 'help'");
			}
		}
		return courselist;
	}
	
	
	/** Print all courses in the Course Catalog */
	public static void printCourseCatalog(CourseCatalog catalog) {
		for(Course c: catalog.getCourses()) {
			System.out.printf("%-40.40s  diff: %.1f\n", c, c.getDifficulty());
		}
	}
	
	/** Add a course to a CourseList */
	public static void addCourse(CourseList cl, String courseId) {
		Course course = CourseCatalog.getCourseCatalog().getCourse(courseId);
		
		if (course == null) System.out.println("Unknown course id "+courseId);
		else if (cl.add(course)) System.out.println("Added course: "+course);
		else System.out.printf("Cannot add %s.  Already enrolled?\n", courseId);
	}
	
	/** Drop a course from a CourseList. */
	public static void dropCourse(CourseList cl, String courseId) {
		Course dropped = cl.drop(courseId);
		if (dropped == null) System.out.println("Cannot drop "+courseId);
		else System.out.printf("Dropped %s.\nCourseList now contains %d credits\n",
				courseId, cl.getCredits());
	}
	
	/** Print what is in the course list */
	public static void printCourseList(CourseList cl) {
		List<Course> courses = cl.getCourses();
		
		if (courses.isEmpty()) System.out.println("Your course list is empty");
		else System.out.println("Your course list contains:");
		System.out.printf("%-38.38s %s\n", "Course", "Difficulty");
		for(Course c: courses) {
			System.out.printf("%-40.40s  %4.1f\n", c, c.getDifficulty());
		}
		System.out.printf("Total credits: %2d     Average difficulty: %4.1f\n",
				cl.getCredits(), cl.getDifficulty());
	}
	
	public static void help() {
		System.out.println("Enter one of:\n");
		System.out.println("catalog       show the course catalog");
		System.out.println("add 01234567  add a course to course list, using course id number");
		System.out.println("drop 01234567 drop a course from course list using course id number");
		System.out.println("list          show your course list");
		System.out.println("help          show this message");
		System.out.println("quit          exit");
	}
}
