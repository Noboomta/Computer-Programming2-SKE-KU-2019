package src;

import java.util.Objects;

public class ComboCourse extends Course{
    public Course course1;
    public Course course2;
    String newTitle;
    public ComboCourse(String courseId, Course a, Course b) {
        super(courseId);
        newTitle = "Combination " + (String) a.getId() + " & " + (String) b.getId();
        course1 = a;
        course2 = b;
    }
    public int getCredits(){
        return course1.getCredits() + course2.getCredits();
    }

    @Override
    public double getDifficulty() {
        if(course1.getDifficulty()>course2.getDifficulty()){
            return course1.getDifficulty();
        }
        else{
            return course2.getDifficulty();
        }
    }

    @Override
    public String getTitle() {
        return newTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboCourse that = (ComboCourse) o;
        return (this.course1 == that.course2 || this.course1 == that.course1 || this.course2 == that.course2 || this.course2 == that.course1);


    }

    @Override
    public int hashCode() {
        return Objects.hash(course1, course2, newTitle);
    }

    public boolean contains(Course other){
        return course1.equals(other) || course2.equals(other);
    }
}
