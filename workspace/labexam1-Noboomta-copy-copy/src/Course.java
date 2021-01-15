package src;

/**
 * A course in the university catalog.
 * A course has a course id, title (name of course), credits, 
 * and a difficulty rating.  Difficulty is 1.0 (easy) to 10.0 (hardest).
 * Difficulty of 0 means the course is unrated.
 */
public class Course {
	private String id;
	private String title;
	private int credits;
	private double difficulty;
	
	/**
	 * A constructor for subclasses that don't need
	 * to set attributes of the parent class.
	 * @param id is the course id for this course
	 */
	protected Course(String id) {
		this.id = id;
	}
	
	/**
	 * Initialize a new course object with
	 * a course id, name, credits, and difficulty rating.
	 */
	public Course(String id, String title, int credits, double difficulty) {
		this.id = id;
		this.title = title;
		this.credits = credits;
		this.difficulty = difficulty;
	}
	
	/**
	 * Initialize a new course object without a difficulty rating.
	 */
	public Course(String id, String title, int credits) {
		this(id, title, credits, 0.0);
	}
	
	/**
	 * Get the name of this course.
	 * @return the title (name) of this course
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Get the number of credits for this course.
	 * @return number of credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Get the difficulty of this course.
	 * @return course difficulty. 0-10, 0=unrated, 1=very easy, 10=very hard.
	 * Difficulty may be fractional, e.g. 2.5.
	 */
	public double getDifficulty() {
		return difficulty;
	}

	/**
	 * Get the course id.
	 * @return id of the course.
	 */
	public String getId() {
		return id;
	}
	
	/** Return a string representation of this course info. */
	public String toString() {
		return String.format("%s %s (%d)", getId(), getTitle(), getCredits());
	}

	/** Two courses are equal if the ids are the same. */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		Course other = (Course)obj;
		return this.getId().equals(other.getId());
	}
}
