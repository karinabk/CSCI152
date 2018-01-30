/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author Karina
 */
public class TestQueue {
    public static void main(String[] args){
        ArrayIntQueue queue1 = new ArrayIntQueue();
        
        try {
            queue1.dequeue();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
        //add 8 items ant print it out
        for (int i = 0 ; i<8;i++){
            queue1.enqueue(i);
            
        }
        System.out.println(queue1);
        System.out.println(queue1.getSize());
        //substruct 3 items and print it out
        try{
            queue1.dequeue();
            queue1.dequeue();
            queue1.dequeue();
        } catch (Exception exc){
            System.out.println(exc.getMessage());
        }
       
         System.out.println(queue1);
        System.out.println(queue1.getSize());
        //add 2, substruct 2 9 times
        for (int i=0;i>9;i++){
            queue1.enqueue(3);
            queue1.enqueue(3);
            try{queue1.dequeue();
            queue1.dequeue();}catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
         System.out.println(queue1);
        System.out.println(queue1.getSize());
        //clears it and prints
        queue1.clear();
         System.out.println(queue1);
        System.out.println(queue1.getSize());
        
         for (int i = 0 ; i<22;i++){
            queue1.enqueue(i);    
        }
        System.out.println(queue1);
        System.out.println(queue1.getSize());
        
        
        
        
        
    }
}
