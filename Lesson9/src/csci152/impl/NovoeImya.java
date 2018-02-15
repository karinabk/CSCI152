/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 * @author Karina
 */
public class NovoeImya {
    /**
     * Chech whether or not stack is insreasing
     * @param st
     * @return 
     */
    public static boolean isIncreasing(Stack<Double> st){
        Double tempValue = 0.0, tempValue2 = 0.0;
        int size = st.getSize();
        boolean incr=true;
        Stack<Double> tempS = new LinkedListStack();
            try{
                while(st.getSize()!=0){
                    tempValue = st.pop();
                    tempS.push(tempValue);
                    tempValue2 = st.pop();
                    tempS.push(tempValue2);
                    if(tempValue < tempValue2){
                        
                       // tempS.push(tempValue);
                        incr= false;
                    }
                   // tempS.push(tempValue2);    //push another stack
                }
            }catch (Exception e){
            }
            while(size != 0){
                try{
                  st.push(tempS.pop());  
                } catch (Exception e) {
                    break;
                }
                size--;
            }
            return true;
    }
}