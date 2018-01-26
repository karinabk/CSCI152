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
public class Cow extends AnimalImpl{
    
    
    public Cow(int a){
        super(a);
    }

    @Override
    public String animalKind() {
        return "Cow";
    }

    @Override
    public boolean canEat(String food) {
        if (food.equals("Grass")){ 
        return true;
        } return false;
    }    
     public void feed(String food) throws Exception{
        if (!canEat(food)){
            throw new Exception ("Cows cannot eat"+food);
        }else {
            System.out.println("munch,munch");           
        }
        
    }
    
    @Override
    public String voice(){
        return "Mu-u-u-u";
    }
    
    public String toString(){
       return "A cow which is " + getAge()+" years old";
   }
}
