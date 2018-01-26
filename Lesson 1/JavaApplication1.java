/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Karina
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //box description
        int l=4, w=6, h=2;
        int vol,sur;
        // volume equals:
        vol=l*h*w;
        //surface area:
        sur=(l*w+l*h+h*w)*2;
    
        
        System.out.println("Volume of the box is " + vol + "\n Surface area is "+sur);
    }
    
}
