package auto_package;

/**
 *
 * @author Karina
 */
public class Automobile {
    
    private boolean engineRunning;
    
    private double speed;
    
    private String licensePlate;

            
    public Automobile(String licensePlate){
        engineRunning = false;
        speed = 0;
        this.licensePlate = licensePlate; 
    } 
    
    public void setLicensePlate( String name ){
      licensePlate= name;
    }
  
    public String getLicensePlate(){
    return licensePlate;
    }
   
    
    public void startCar(){
        engineRunning = true;
    }
    
    public void pressGasPedal(){
        if (engineRunning){
        speed = speed + 10;
        }
    }
    
    public void pressBrake(){
        speed =0;
        
    }
    
    public void shutDown(){
        engineRunning=false;
    }
    
    public boolean isEngineRunning(){
        return engineRunning;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public double calculateDistance(double time){
        return time *speed;
    }
    
    public String toString(){
        return "Name of the car: " + licensePlate +
                " Engine running: " + engineRunning+ " Speed: "+speed;
    }
}
