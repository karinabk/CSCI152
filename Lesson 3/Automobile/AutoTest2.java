/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobile2;

/**
 *
 * @author Karina
 */
public class AutoTest2 {
    public static void main(String[] args){
        
       try { 
        Automobile2 car1 = new Automobile2();
        Automobile2  car2 = new Automobile2();
        
        car1.setLicensePlate("9876543");
        car2.setLicensePlate("354677");
        car1.startCar();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car1.pressGasPedal();
        car2.pressGasPedal();
        car1.getLicensePlate();
        car2.getLicensePlate();
        
        System.out.println(car1.getLicensePlate());
        
      System.out.println(car1.toString());
      
      System.out.println(car2.getLicensePlate());
      
        System.out.println(car2);
       } catch (Exception exc){
           System.out.println(exc.getMessage());
       }
       
       
    }
    
}
