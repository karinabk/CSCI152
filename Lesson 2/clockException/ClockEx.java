/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockex;

/**
 *
 * @author Karina
 */
public class ClockEx  {

   // Fields
    private int hours;
    private int minutes;
    private int seconds;
 /**
  * Starting values
  * @param h means hours
  * @param m means minutes 
  * @param s means seconds
  * @throws Exception for cases when value is not valid
  */
    // Constructor
    public ClockEx(int h, int m, int s) throws Exception {
        
        if (h>23||h<0) {
            throw new Exception ("Hours are not in range");
        }
        hours = h;
        if (s>59||s<0){
            throw new Exception ("Seconds are not in range");
        }
        seconds = s;
        if ( m>59||m<0){
            throw new Exception ("Minutes are not in range");
        }
        minutes = m;
        
    }
 /**
  * adjust the clocks on midnight time
  */
    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }
 /**
  * checking whether its morning or not
  * @return gives true if yes or false if not
  */
    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }
 /**
  * one tick increases time on one second
  */
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
    /**
     * sets seconds value
     * @param sec is for seconds
     * @throws Exception when seconds are not valid
     */
    public void setSeconds(int sec) throws Exception {
        if( sec<60 && sec>0){
        seconds=sec;
        } else {
            throw new Exception("Seconds are not in range");
        }
    }
    /**
     * sets the value for hours
     * @param hours for hours
     * @throws Exception when hours are not valid
     */
    public void setHours(int hours) throws Exception {
        if(hours<24 && hours>0){
        this.hours = hours;
        } else {
            throw new Exception("Hours are not in range");
        }
    }
    /**
     * changes minutes field to the parameter argument, argument between o and 60
     * @param minutes for minutes
     * @throws Exception when minutes are not valid
     */
    public void setMinutes(int minutes) throws Exception {
        if(minutes<60 && minutes>0){
            this.minutes = minutes;
        } else {
            throw new Exception ("Minutes are not in range");
        }
    }
    /**
     * for recieving values of minutes , seconds and hours
     * @return integer values of minutes, seconds of hours
     */
    public int getSec(){
        return seconds;
    }
    
    public int getHours(){
        return hours;
    }
    public int getMin(){
        return minutes;
    }
    /**
     * gives the result in a string
     * @return string
     */
    public String toString(){
        return " " + hours+":" + minutes+":"+ seconds; 
    }

    
}
