/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;
import csci152.adt.IntStack;

/**
 *
 * @author Karina
 */
public class TestLesson8 {
    /**
     * creats a copy of the given stack
     * @param stk 
     * @return 
     */
    public static IntStack copyStack(IntStack stk){
        IntStack origStk = new ArrayIntStack();
        IntStack tempStk = new ArrayIntStack();
        IntStack save = new ArrayIntStack();
        int pop = 0;
        try{
            while(stk.getSize()!=0){
                pop = stk.pop();
                tempStk.push(pop);
                save.push(pop);
            }
            while(tempStk.getSize()!=0)
                origStk.push(tempStk.pop());
            while(save.getSize()!=0){
                stk.push(save.pop());
            }
            
            
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return origStk;
    }
    /**
     * returns the amount of even number in the stack
     * @param stk
     * @return 
     */
    public static int evenCount(IntStack stk){
        IntStack origStk = new ArrayIntStack();
        int counter =0;
        
        
        try {
            while (stk.getSize()!=0){
                int last=stk.pop();
                if (last%2==0){
                    counter++;
                }
                origStk.push(last);
            }
            while(origStk.getSize()!=0)
                stk.push(origStk.pop());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return counter; 
    }
    /**
     * changes the order in the queue from top to bottom
     * @param toRev 
     */
    public static void reverseQueue(IntQueue toRev){
        IntStack stk = new ArrayIntStack();
       try{ 
        while(toRev.getSize()!=0)
            stk.push(toRev.dequeue());
        
        while (stk.getSize()!=0)
            toRev.enqueue(stk.pop());
        
       }catch (Exception e){
           System.out.println(e.getMessage());
                  
       }
       
    }
    /**
     * changes the order in the stack from top to bottom
     * @param toRev 
     */
    public static void reverseStack(IntStack toRev){
        IntQueue temp = new ArrayIntQueue();
        
        try{
            while (toRev.getSize()!=0)
                temp.enqueue(toRev.pop());
            while(temp.getSize()!=0)
                toRev.push(temp.dequeue());
            
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        } 
          
    }
    /**
     * places new given integer in the position
     * @param st
     * @param pos
     * @param val 
     */
    public static void insert(IntStack st, int pos, int val){
          IntStack temp = new ArrayIntStack();
          try{ 
            while (st.getSize()!=pos)
                temp.push(st.pop());
                st.push(val);
            while(temp.getSize()!=0)
                st.push(temp.pop());
                
          }catch (Exception exc){
              System.out.println(exc.getMessage());
          }
          
       }
    
    
    
}
