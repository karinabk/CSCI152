package automobile2;

/**
 *
 * @author Karina
 */
public class Automobile2 {

  private boolean engineRunning;
    
    private double speed;
    
    private String licensePlate;

    /**
    * Starting values 
    */
    public Automobile2(){
        engineRunning = false;
        speed = 0;
        licensePlate = "license";
    } 
    /**
     * sets name of cars
     * @param name of cars
     */
    public void setLicensePlate( String name ){
      licensePlate= name;
      
    }
    /**
     * gives name of the cars
     * @return name of the cars
     */ 
    public String getLicensePlate(){
      return licensePlate;
    }
    /**
     * turns on the car
     */  
    public void startCar(){
        engineRunning = true;
    }
    /**
     * increases the speed
     * @throws Exception stops if speed is too high
     */
    public void pressGasPedal() throws Exception{
        
        if (engineRunning){
        speed = speed + 10;
        }
        if (speed >=30){
            throw new Exception("Speed is too high");
        }
    }
    /**
     * to stop the motion
     */
    public void pressBrake(){
        speed =0;
        
    }
    /**
     * to turn off the car
     */
    public void shutDown(){
        engineRunning=false;
    }
    /**
     * checking if the car is moving or not 
     * @return true if works or false if not
     */
    public boolean isEngineRunning(){
        return engineRunning;
    }
    /**
     * gives the vlues of speed and distance 
     * @return values of speed and distance
     */
    public double getSpeed(){
        return speed;
    }
    
    public double calculateDistance(double time){
        return time *speed;
    }
    /**
     * result in the string form 
     * @return string
     */
    public String toString(){
        return "Name of the car: " + licensePlate +
                " Engine running: " + engineRunning+ " Speed: "+speed;
    }
}
