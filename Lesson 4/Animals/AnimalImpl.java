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
public class AnimalImpl implements Animal {
    
    private int age;
    
    private int maxAge;
    
    private boolean isAlive;
   
    public AnimalImpl(int age){
        this.age=age;
        this.maxAge = 0;
    }
            
   @Override
    public int getAge() {
       return age; 
    }

    
    @Override
    public void ageOneYear() {
        age++;
        if (age>maxAge){
            isAlive=false;
        } else isAlive=true;
    }

    @Override
    public String animalKind() {
       return "animal";
    }

    @Override
    public boolean canEat(String food) {
       return true;
    }
    
     public void feed(String food) throws Exception{
        if (!canEat(food)){
            throw new Exception ("Animal cannot eat"+food);
        }else {
            System.out.println("munch,munch");           
        }
        
    }
    public String voice(){
        return "voice";
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * @return the isAlive
     */
    public boolean isIsAlive() {
        return isAlive;
    }

    /**
     * @param maxAge the maxAge to set
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * @param isAlive the isAlive to set
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }


}
