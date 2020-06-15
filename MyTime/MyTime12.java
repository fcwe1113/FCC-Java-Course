public class MyTime12 implements MyTime {
    public static final String AM = "AM";
    public static final String PM = "PM";
    private int hour = 12;
    private int minute = 0;
    private int second = 0;
    private String period = MyTime12.AM;

    public MyTime12() {
    }
    public MyTime12(int hour, int minute, int second, String peroid) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setPeriod(period);
    }

    public int getHour() {
        return this.hour;
    }
    public void setHour(int hour) {
        if (hour < 1 || hour > 11) {
            throw new IllegalArgumentException("Invalid hour "+hour);
        }
        this.hour = hour;
    }
    public int getMinute() {
        return this.minute;
    }
    public void setMinute (int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute "+minute);
        }
        this.minute = minute;
    }
    public int getSecond() {
        return this.second;
    }
    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Invalid second "+second);
        }
        this.second = second;
    }
    public String getPeriod() {
        return this.period;
    }
    
    public void setPeriod(String period){
        if (period.toUpperCase() != "AM" || period.toUpperCase() != "PM"){
            throw new IllegalArgumentException("Invalid entry "+period);
        }
        if (period.toUpperCase() == "AM"){
            this.period = MyTime12.AM;
        } else {
            this.period = MyTime12.PM;
        }
    }

    public void addSeconds(int seconds){
        second+=seconds;
        while (second > 59 || second < 0){
            if (second > 59){
                second -= 60;
                minute++;
            }
            
            if (minute > 59){
                minute-=60;
                hour++;
            }
            
            if (hour > 12){
                hour-=12;
                if (period == "AM"){
                    period = MyTime12.AM;
                } else {
                    period = MyTime12.PM;
                }
            }
            
            if (second < 0){
                second+=60;
                minute--;
            }
            
            if (minute < 0){
                minute+=60;
                hour--;
            }
            
            if (hour < 1){
                hour+=12;
                if (period == "AM"){
                    period = MyTime12.AM;
                } else {
                    period = MyTime12.PM;
                }
            }
        }
    }
    
    public int getSecondOfDay(){
        if(period == "PM"){
            return second + minute * 60 + (hour + 12) * 3600;
        } else {
            return second + minute * 60 + hour * 3600;
        }
    }
    
    public String toString(){
        return String.format("%02d:%02d:%02d %s", hour, minute, second, period);
    }
    
    public boolean equals(Object o){
        MyTime12 a = (MyTime12) o;
        int h = a.hour;
        int m = a.minute;
        int s = a.second;
        String p = a.period;
        
        if(h == hour && m == minute && s == second && p.equals(period)){
            return true;
        } else {
            return false;
        }
    }
}
