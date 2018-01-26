/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalproj;

/**
 *
 * @author Karina
 */
public class Test {
   
    public static void feedMeat(Animal animal){
        try {
            animal.feed("Meat");
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
                
    }
            
    public static void main(String[] args){
        
        
        Cow cow1 = new Cow(3);
        Tiger tiger1 = new Tiger(4);
        Animal cat1= new Cat(3);
        
        cow1.setMaxAge(3);
        
        feedMeat(cow1);
        
        System.out.println(tiger1.voice());
        cat1.ageOneYear();
        System.out.println(cat1);
        cow1.ageOneYear();
        cow1.ageOneYear();
      
        
        System.out.println(cow1);
        System.out.println(cow1.isIsAlive());
        
                
    }
}
