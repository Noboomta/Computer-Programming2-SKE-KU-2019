//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
//import java.util.List;
//import org.junit.Assume;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * JUnit 4 test of CourseList class.
// * Requires the JUnit 4 JAR files (junit.jar and hamcrest-core.jar)
// * on your project classpath.
// */
//public class CourseListTest {
//	private static final double TOL = 1.0E-6;
//	Course[] courses;
//	CourseList clist;
//
//	@Before
//	public void setUp() throws Exception {
//		clist = new CourseList();
//		courses = new Course[] {
//			new Course("01219001", "Unrated", 5, 0), // must have difficulty 0
//			new Course("01219111", "Python", 2, 2.5),
//			new Course("01219112", "Java", 3, 5),
//			new Course("01219114", "Java", 4, 4),
//			new Course("01204444", "Quantum Physics", 4, 10)
//				};
//	}
//
//	@Test
//	public void testNewCourseList() {
//		// new courselist is empty
//		assertEquals( 0, clist.getCredits() );
//		assertEquals( 0.0, clist.getDifficulty(), TOL);
//		assertEquals(0, clist.getCourses().size());
//	}
//
//	@Test
//	public void testAddOneCourse() {
//		Course course = courses[1];
//		assertTrue( clist.add(course) );
//		assertEquals( course.getCredits(), clist.getCredits() );
//		// cannot add it again
//		assertFalse( clist.add(course) );
//	}
//
//	@Test
//	public void testDropOneCourse() {
//		Course course = courses[2];
//		String id = course.getId();
//		Assume.assumeTrue( clist.add(course) );
//		assertEquals( course, clist.drop(id) ); // drop returns the course
//		assertNull( clist.drop(id) );
//		assertEquals( 0, clist.getCourses().size() );
//	}
//
//	@Test
//	public void testInvalidAddAndDrop() {
//		for(int k=0; k<courses.length; k++) {
//			Course c = courses[k];
//			assertTrue( clist.add(c) );
//			assertTrue( clist.getCourses().contains(c) );
//		}
//		for(int k=0; k<courses.length; k++) {
//			Course c = courses[k];
//			assertFalse( clist.add(c) );
//		}
//		for(int k=0; k<courses.length; k++) {
//			Course c = courses[k];
//			String id = c.getId();
//			assertEquals( c, clist.drop(id) );
//			assertFalse( clist.getCourses().contains(c) );
//			assertNull( clist.drop(id) ); // cannot drop again
//		}
//	}
//
//	@Test
//	public void testGetCredits() {
//		assertEquals( 0, clist.getCredits() );
//		clist.add(courses[1]);
//		clist.add(courses[2]);
//		clist.add(courses[3]);
//		clist.add(courses[4]);
//		int credits = courses[1].getCredits()+courses[2].getCredits()
//		            + courses[3].getCredits()+courses[4].getCredits();
//
//		assertEquals( credits, clist.getCredits() );
//	}
//
//	@Test
//	public void testDifficulty() {
//		// empty course list has difficulty 0
//		assertEquals( 0.0, clist.getDifficulty(), TOL);
//		// first course has no rating. Test it is handled correctly.
//		Course unrated = new Course("000", "Unseen Course", 2, 0.0);
//		clist.add( unrated );
//		assertEquals( 0.0, clist.getDifficulty(), TOL );
//
//		Course c1 = new Course("001", "Easy Course", 3, 1.5);
//		clist.add(c1);
// 		assertEquals( 1.5, clist.getDifficulty(), TOL);
//		Course c2 = new Course("007", "Killer Course", 2, 10.0);
//		clist.add(c2);
//		double difficulty = (3*1.5 + 2*10.0)/5;
// 		assertEquals( difficulty, clist.getDifficulty(), TOL);
//		Course c3 = new Course("008", "Secret Course", 3, 8.2);
//		clist.add(c3);
//		difficulty = (3*1.5 + 2*10.0 + 3*8.2)/(3+2+3);
// 		assertEquals( difficulty, clist.getDifficulty(), TOL);
//	}
//
//	@Test
//	public void testGetCoursesIsView() {
//		// get a view of the course List
//		List<Course> view = clist.getCourses();
//		assertEquals(0, view.size());
//		// when courselist changes the view should update, too
//		clist.add(courses[1]);
//		assertEquals(1, view.size());
//		clist.add(courses[2]);
//		assertEquals(2, view.size());
//	}
//
//	/** An unmodifiable view throws this exception */
//	@Test(expected = java.lang.UnsupportedOperationException.class)
//	public void testViewIsUnmodifiable() {
//		clist.add(courses[1]);
//		List<Course> view = clist.getCourses();
//		// this should throw exception
//		view.add(courses[2]);
//	}
//}
