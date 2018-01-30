/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import java.util.Arrays;

/**
 *
 * @author Karina
 */
public class TestStack {
    public static void main (String[] args){
        ArrayIntStack stack1 = new ArrayIntStack();
        
        //tries to pop from empty stack
        try{
        stack1.pop();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } 
        
        //push 12 elements and prints stack and size
      
        for (int i=0; i<12;i++){
            stack1.push(i);
        }
        System.out.println(stack1);
        System.out.println(stack1.getSize());
        
        // pops several items and prints stack and size
        try{
            stack1.pop();
            stack1.pop();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
        System.out.println(stack1);
        System.out.println(stack1.getSize());
        
        //clears stack and pronts stack and size
        stack1.clear();
        System.out.println(stack1);
        System.out.println(stack1.getSize());
        
        // push 20 items and prints stack and size
        for (int i=0; i<20;i++){
            stack1.push(i);
        }
        System.out.println(stack1);
        System.out.println(stack1.getSize());
    }
    
}
