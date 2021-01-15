class Timer {
    
    public int timeStamp = 0;

    private int second = 0;
    private int minute = 0;
    private int hour = 0;

    public void setTime(int h, int m, int s) {
        second = s; minute = m; hour = h;
        timeStamp = (hour * 3600) + (minute * 60) + second;
    }

    public void increaseTime() {
        timeStamp = (timeStamp + 1) % 86400;
    }
}