/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
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
    
    public static boolean isPalindrome(Queue<Character> q) {
        Queue<Character> temp = new LinkedListQueue();
        Stack<Character> comp = new LinkedListStack();
        int size = q.getSize();
        Character ch1=null;
        Character ch2 = null;
        boolean bool = true;
   
       try{
       if (size%2==0){
            for( int i = 0; i<= size/2-1; i++){
                ch1 = q.dequeue();
//                q.enqueue('F');
//                System.out.println("proverka for q inside for "+q );
                temp.enqueue(ch1);
                comp.push(ch1);
                
            }
            
            while(q.getSize()!=0){
                ch1 = q.dequeue();
                temp.enqueue(ch1);
                ch2=comp.pop();
                
                if (ch1!=ch2){
                    bool = false;
                }
                System.out.println(q.getSize());
            }
            
           q.enqueue('g');
           System.out.println("proverka v konce" + q);
           System.out.println("zapolnenie"+q);
            while(temp.getSize()!=0){
                q.enqueue(temp.dequeue());
                System.out.println("obratno"+q+temp);
            }
//            q = temp;
              System.out.println("zapolnenie"+q);
        }else {
            for( int i = 0; i<= size/2-1; i++){
                ch1 = q.dequeue();
                temp.enqueue(ch1);
                comp.push(ch1);
                System.out.println("proverka"+q +"comp"+ comp+"temp"+temp+i);
            }
            temp.enqueue(q.dequeue());

            while(q.getSize()!=0){
                ch1 = q.dequeue();
                temp.enqueue(ch1);
                ch2=comp.pop();
                System.out.println("proverka while"+q +"comp"+ comp+"temp"+temp);
                if (ch1==ch2){
                    
                }else {
                    bool= false;
                }
            }
            while(temp.getSize()!=0){
                q.enqueue(temp.dequeue());
            }
                  
        }}catch (Exception e){
            System.out.println(e.getMessage());
        }
        return bool;
        
    }
    public static void main(String[] args){
        Queue<Character> cha = new LinkedListQueue();
        cha.enqueue('a');
        cha.enqueue('A');
        cha.enqueue('H');
       
        cha.enqueue('h');
        cha.enqueue('A');
        cha.enqueue('a');
        System.out.println(cha);  
        System.out.println(isPalindrome(cha));
        System.out.println(cha);
        
        
    }
}