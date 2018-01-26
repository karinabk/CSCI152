/**
 *
 * @author Karina
 */
public class Clock {

      // Fields
    private int hours;
    private int minutes;
    private int seconds;
 
    // Constructor
    public Clock(int h, int m, int s)  {
        
        if (h>23||h<0){
            hours = 0;
            minutes =0;
            seconds =0;
        } else {hours = h; minutes = m; seconds = s;
        
        }
        if (s>59||s<0){
            hours = 0;
            minutes =0;
            seconds =0;
        } else {hours = h; minutes = m; seconds = s;
        
        }
        if ( m>59||m<0){
            hours = 0;
            minutes =0;
            seconds =0;
        } else {hours = h; minutes = m; seconds = s; 
        
        }
        
    }
 
    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }
 
    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }
 
    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
            if (minutes >=60){
                minutes=0; 
                hours++;
                }
                if (hours >=24){
                    hours =0;  }
            
        }    
     
    }
    
    public void setSec(int sec){
        if( sec<60||sec>0){
        seconds=sec;
        }
    }
    public void setHours(int hours){
        if(hours<24||hours>0){
        this.hours = hours;
        }
    }
    public void setMin(int minutes){
        if(minutes<60||minutes>0){
            this.minutes = minutes;
        }
    }
    
    public int getSec(){
        return seconds;
    }
    public int getHours(){
        return hours;
    }
    public int getMin(){
        return minutes;
    }
    
    public String toString(){
        return " " + hours+":" + minutes+":"+ seconds; 
    }
}
