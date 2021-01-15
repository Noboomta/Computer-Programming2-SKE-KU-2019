package test;

import java.util.Objects;

/**
 * Class ComboCourse extends Course.
 */
public class ComboCourse extends Course{
    public Course course1;
    public Course course2;
    String newTitle;

    /**
     * Constructor.
     * @param courseId id
     * @param a Course
     * @param b Course
     */
    public ComboCourse(String courseId, Course a, Course b) {
        super(courseId,"Combination " +  a.getId() + " & " +  b.getId(), a.getCredits()+b.getCredits(), a.getDifficulty()+b.getDifficulty());
        this.newTitle = "Combination " +  a.getId() + " & " +  b.getId();
        this.course1 = a;
        this.course2 = b;
    }

    /**
     * getCredit method.
     * @return credit.
     */
    public int getCredits(){
        return course1.getCredits() + course2.getCredits();
    }

    /**
     * getDifficulty.
     * @return difficulty sum.
     */
    @Override
    public double getDifficulty() {
        return course1.getDifficulty() + course2.getDifficulty();
    }

    /**
     * Title
     * @return title
     */
    @Override
    public String getTitle() {
        return this.newTitle;
    }

    /**
     * Equals method.
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboCourse that = (ComboCourse) o;
        return (this.course1.equals(that.course2) || this.course1.equals(that.course1) || this.course2.equals(that.course2) || this.course2.equals(that.course1));


    }

    @Override
    public int hashCode() {
        return Objects.hash(course1, course2, newTitle);
    }

    /**
     * cCheck if Course is in the ComboCourse.
     * @param other Course
     * @return boolean.
     */
    public boolean contains(Course other){
        return course1.equals(other) || course2.equals(other);
    }
}
