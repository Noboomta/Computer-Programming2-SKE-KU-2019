package sample;
import javafx.concurrent.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * AllTask class, class of the Task.
 */
public class AllTask {

    public List<Task> allTask = new ArrayList<>();
    public double allProgress;

    /**
     * To add task.
     */
    public void addTask(Task task) {
        allTask.add(task);
    }

    /**
     * To return all task progress
     */
    public double getAllProgress() {
        this.setProgress();
        return this.allProgress;
    }

    /**
     * Set all progress.
     */
    public void setProgress(){
        double allProg = 0;
        for (Task task : allTask) {
            allProg += task.getProgress();
        }
        this.allProgress = allProg / allTask.size();
    }

}
