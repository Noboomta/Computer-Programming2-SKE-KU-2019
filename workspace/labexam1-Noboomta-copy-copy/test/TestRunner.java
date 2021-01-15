//import java.util.List;
//
//import org.junit.runner.Description;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//import org.junit.runners.Suite.SuiteClasses;
//
///**
// * This class runs the JUnit tests in other classes.
// * You don't need this if you run unit tests in your IDE directly.
// */
////@SuiteClasses(value={CourseTest.class,CourseListTest.class})
//public class TestRunner {
//
//	private static int runtests( Class<?> testclass ) {
//		Result result = org.junit.runner.JUnitCore.runClasses( testclass );
//		int count = result.getRunCount();
//		int failed = result.getFailureCount();
//		System.out.printf( "%-18.18s  Success: %d  Failure: %d\n",
//				testclass.getSimpleName(), count-failed, failed);
//		List<Failure> failures = result.getFailures();
//		for(Failure f: failures) {
//			Description d = f.getDescription();
//			System.out.println( f.getTestHeader() +": "+ f.getMessage() );
//			System.out.println( d.getDisplayName() );
//		}
//		// return the number of failures
//		return failed;
//	}
//	/**
//	 * Run JUnit tests as a stand-alone test suite,
//	 * and describe the results.
//	 */
//	public static void main(String[] args) {
//		runtests( CourseListTest.class );
//		runtests( ComboCourseTest.class );
//	}
//}
