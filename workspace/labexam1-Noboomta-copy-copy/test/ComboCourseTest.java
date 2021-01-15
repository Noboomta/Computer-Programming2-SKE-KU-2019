//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
///**
// * JUnit 4 tests of the ComboCourse class.
// */
//public class ComboCourseTest {
//	Course c1;
//	Course c2;
//	String courseId;
//	String title;
//	int credits;
//	double difficulty;
//
//	@Before
//	public void setUp() {
//		c1 = new Course("CPE301", "Algorithms", 4, 7.5);
//		c2 = new Course("CPE302", "More Algorithms", 2, 8.5);
//		courseId = "CPE801";
//		title = "Combination CPE301 & CPE302";
//		credits = 6;
//		difficulty = 8.5;
//	}
//
//	@Test
//	public void testGetTitle() {
//		ComboCourse cc = new ComboCourse(courseId, c1, c2);
//		assertEquals(title, cc.getTitle());
//	}
//
//	@Test
//	public void testGetCredits() {
//		ComboCourse cc = new ComboCourse(courseId, c1, c2);
//		assertEquals(credits, cc.getCredits());
//	}
//
//	@Test
//	public void testGetDifficulty() {
//		ComboCourse cc = new ComboCourse(courseId, c1, c2);
//		assertEquals(difficulty, cc.getDifficulty(), 0.01);
//		ComboCourse cc2 = new ComboCourse(courseId, c2, c1);
//		assertEquals(difficulty, cc2.getDifficulty(), 0.01);
//	}
//
//	@Test
//	public void testGetId() {
//		ComboCourse cc = new ComboCourse(courseId, c1, c2);
//		assertEquals(courseId, cc.getId());
//	}
//
//	/**
//	 * ComboCourses are equal if they contain the same component
//	 * courses, in either order.  Combo CourseId does not need to match.
//	 */
//	@Test
//	public void testEqualsObject() {
//		// CPE is creative.  You can take the Algorithms sequence in either order.
//		ComboCourse cc = new ComboCourse(courseId+"A", c1, c2);
//		ComboCourse cc2 = new ComboCourse(courseId+"B", c1, c2);
//		assertNotEquals(c1, cc);
//		assertNotEquals(c2, cc);
//		assertEquals(cc, cc2);
//		// The real test
//		cc2 = new ComboCourse(courseId, c2, c1);
//		assertEquals(cc, cc2);
//	}
//
//}
