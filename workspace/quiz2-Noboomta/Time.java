/**
 * The class Time to be calculate hours minutes and seconds, also can add more time
 * and check if the class is equals.
 * @author Puvana Swatvanith, 6210545734, Noboomta
 */
public class Time{

    //initialize second in int
    private int seconds;
    //initialize hours in int
    private int hours;
    //initialize minutes in int
    private int minutes;

    /**
     * the constructor to set 3 valuable combined with hours, minutes, and second
     * by hours if from seconds/3600, minutes is from the left second/60, and second if the left second.
     * @param seconds the value that the user set in the initialize class.
     */
    public Time(int seconds){
        
        int hr = seconds/3600;
        seconds = seconds%3600;
        int mn = seconds/60;
        seconds = seconds%60;
        int sec = seconds;
        this.hours = hr;
        this.minutes = mn;
        this.seconds = sec;
    }

    /**
     * the constructor to set 3 valuable combined with hours, minutes, and second
     * by hours if from seconds/3600, minutes is from the left second/60, and second if the left second.
     * @param hr the value to store the hours value to be set at the last
     * @param mn the value to store the value to be set at the last.
     * @param sec the value that the user set in the initialize class.
     * @param totalSecond the int value to store hours*3600 + minutes*60 + seconds.
     */
    public Time(int hours, int minutes, int seconds){

        int totalSecond = hours*3600 + minutes*60 + seconds;
        int hr = totalSecond/3600;
        totalSecond = totalSecond%3600;
        int mn = totalSecond/60;
        totalSecond = totalSecond%60;
        int sec = totalSecond;
        this.hours = hr;
        this.minutes = mn;
        this.seconds = sec;
    }

    /**
     * the method to return the hours
     * @return hours in the class
     */
    public int getHours(){
        return this.hours;
    }

    /**
     * the method to return the minutes
     * @return minutes in the class
     */
    public int getMinutes(){
        return this.minutes;
    }

    /**
     * the method to return the seconds
     * @return seconds in the class
     */
    public int getSeconds(){
        return this.seconds;
    }

    /**
     * method to return the new class Time by add from the new to the old one.
     * @param time the Object class Time which store its own hours, minutes,seconds.
     * @return new Time class which have already store the new second from the lod and the add one.
     */
    public Time add(Time time){

        int totalSec = 0;
        totalSec += time.hours*3600 + time.minutes*60 + time.seconds;
        totalSec += this.hours*3600 + this.minutes*60 + this.seconds;
        return new Time(totalSec);
    }

    /**
     * the method which check if this and the other class is the same class, and also contained with the same value.(hours, minutes, seconds).
     */
    public boolean equals(Object other){

        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Time obj = (Time) other;
        if (this.seconds == obj.seconds && this.hours == obj.hours && this.minutes == obj.minutes){
            return true;
        }
        return false;
    }

    /** the method to return the String which generated to the format h:mm:ss
     * by h is hours, mm is minutes, and ss is seconds.
     */
    public String toString(){
        return String.format("%d:%02d:%02d",this.hours,this.minutes,this.seconds);
    }
}