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
public class Tiger extends AnimalImpl{
  
    
    public Tiger(int a){
        super(a);
    }

    @Override
    public String animalKind() {
        return "Tiger";
    }

    

    @Override
    public boolean canEat(String food) {
       if(food.equals("Meat")){
           return true;
       }
       return false;
    }
    
    public void feed(String food) throws Exception{
        if (!canEat(food)){
            throw new Exception ("Tigers cannot eat"+food);
        }else {
            System.out.println("munch,munch");           
        }
        
    }
    

    public String voice(){
        return "R-r-r-r";
    }
    
    public String toString(){
        return "A tiger which is "+getAge()+"years old";
    }
    
}
