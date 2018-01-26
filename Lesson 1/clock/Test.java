/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author Karina
 */
public class Test {
    public static void main(String[] args ){
        
        Clock clock = new Clock(21,59,59);
        clock.tick();
        System.out.println(clock);
    
    }
    
}
