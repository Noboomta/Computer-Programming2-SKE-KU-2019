import java.util.ArrayList;
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
        double allWeight = 0;
        double difCourse = 0;
        double front = 0;
        double back = 0;
        for (Course c: listCourse){
            front += c.getDifficulty()*c.getCredits();
            if(c.getCredits()>0){
                back += c.getCredits();
            }
        }
        if(front/back >= 0){
            return front/back;
        }
        return 0;
//        for(Course c: listCourse){
//            allWeight += c.getDifficulty()*c.getCredits();
//            difCourse+= c.getDifficulty();
//        }
////        if(creCourse>=1){
////            return allWeight/creCourse;
////        }
////        else{
////            return 0;
////        }
//        return difCourse;
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
        return listCourse;
    }
}
