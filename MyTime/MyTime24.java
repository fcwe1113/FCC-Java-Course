public class MyTime24 implements MyTime {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyTime24() {
    }
    public MyTime24(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {
        return this.hour;
    }
    public void setHour(int hour) {
        if (hour<0 || hour>=24) {
            throw new IllegalArgumentException("Invalid hour "+hour);
        }
        this.hour = hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public void setMinute(int minute) {
        if (minute<0 || minute>=60) {
            throw new IllegalArgumentException("Invalid minute "+minute);
        }
        this.minute = minute;
    }
    public int getSecond() {
        return this.second;
    }
    public void setSecond(int second) {
        if (second<0 || second>=60) {
            throw new IllegalArgumentException("Invalid second "+second);
        }
        this.second = second;
    }

    @Override
    public String toString() {
        // implement
        return String.format("%02d:%02d:%02d", hour, minute,second);
    }
    @Override
    public boolean equals(Object o) {
        // implement
        MyTime24 a = (MyTime24) o;
        int h = a.hour;
        int m = a.minute;
        int s = a.second;
        
        if (h == hour && m == minute && s == second){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSecondOfDay() {
        return hour*3600+minute*60+second;
    }
    @Override
	public void addSeconds(int seconds) {
        // implement
        
        second+=seconds;
        while (second > 59 || second < 0){
            if(second > 59){
                second-=60;
                minute++;
            }
        
            if(minute > 59){
                minute-=60;
                hour++;
            }
        
            if(hour > 23){
                hour-=24;
            }
            
            if(second < 0){
                second+=60;
                minute--;
            }
            
            if(minute < 0){
                minute+=60;
                hour--;
            }
        
            if(hour < 0){
                hour+=24;
            }
        }
    }
}
