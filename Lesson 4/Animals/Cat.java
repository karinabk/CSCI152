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
public class Cat extends AnimalImpl{
    
    
    
    public Cat(int a){
        super(a);
    }
    
    public String animalKind() {
        return "Cat";
    }

    public boolean canEat(String food) {
       if(food.equals("Meat")){
           return true;
       }
       return false;
    }
     public void feed(String food) throws Exception{
        if (!canEat(food)){
            throw new Exception ("Cats cannot eat"+food);
        }else {
            System.out.println("munch,munch");           
        }
        
    }

    public String voice(){
        return "Meow";
    }
    
    public String toString(){
        return "A cat which is "+getAge()+"years old";
    }
    
}
