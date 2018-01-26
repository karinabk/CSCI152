/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_package;

/**
 *
 * @author Karina
 */
public class AutoTest {
    public static void main(String[] args){
        
        
        Automobile car1 = new Automobile("87654");
        Automobile  car2 = new Automobile("76545");
        
        
        car1.startCar();
        car2.pressGasPedal();
        car1.getLicensePlate();
        car2.getLicensePlate();
        
        System.out.println(car1.getLicensePlate());
        
        System.out.println(car1.toString());
      
        System.out.println(car2.getLicensePlate());
      
        System.out.println(car2);
    }
          
}
