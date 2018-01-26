/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphism;

/**
 *
 * @author Karina
 */
public class Test {
    public static void main(String[] args){
        
        Students student1 = new Students("Marat",123,2,false);
        
        System.out.println(student1);
        student1.purpose();
        student1.mealPlan();
        student1.procrastination();
        
        
        Professor prof1 = new Professor("Irina Tsoy", 541, true,"Economics");
        System.out.println(prof1);
        prof1.mealPlan();
        prof1.purpose();
        
        Staff worker1 = new Staff ("Vasya",835, false, "canteen");
        System.out.println(worker1);
        worker1.purpose();
        worker1.procrastination();
        
        
        
    }
    
}
