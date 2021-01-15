import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class CourseList
 */
public class CourseList {
    public List<Course> listCourse = new ArrayList<>();

    /**
     * Add course method.
     * @param course
     * @return
     */
    public boolean add(Course course){
        if(listCourse.contains(course)){
            return false;
        }
        else{
            listCourse.add(course);
            return true;
        }
    }

    /**
     * getDifficulty method.
     * @return difficulty.
     */
    public double getDifficulty(){
        double front = 0;
        double back = 0;
        for (Course c: listCourse){
            if(c.getDifficulty() > 0){
                back += c.getCredits();
                front += c.getDifficulty()*c.getCredits();
            }
        }
        if(back == 0){
            return 0;
        }
        return front/back;
    }

    /**
     * Drop Method.
     * @param courseId id
     * @return course
     */
    public Course drop(String courseId){
        for(Course c: listCourse){
            if(c.getId().equalsIgnoreCase(courseId)){
//                returnCourse = c;
                listCourse.remove(c);
                return c;
            }
        }
        return null;
    }

    /** getCredit method.
     * @return all credit.
     */
    public int getCredits(){
        int allCredit = 0;
        for(Course c: listCourse){
            allCredit+= c.getCredits();
        }
        return allCredit;
    }

    /**
     * getCourse.
     * @return All course.
     */
        public List<Course> getCourses(){
        return Collections.unmodifiableList(listCourse);
//        return listCourse;
    }
}