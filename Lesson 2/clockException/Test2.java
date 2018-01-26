/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockex;

/**
 *
 * @author Karina
 */
public class Test2 {
     public static void main(String[] args ){
         
    try {
        ClockEx clock = new ClockEx(7,9,59);
        clock.tick();
        try {
            clock.setMinutes(98);
            }
        catch(Exception exc){
            System.out.println(exc.getMessage());
        }
        System.out.println(clock);
    } catch(Exception exc){
       System.out.println(exc.getMessage());
        };
    }
}
