/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;
import static csci152.impl.ModificationsLesson8.copyStack;
import static csci152.impl.ModificationsLesson8.evenCount;
import static csci152.impl.ModificationsLesson8.insert;
import static csci152.impl.ModificationsLesson8.reverseQueue;

import csci152test.Student;


/**
 *
 * @author Karina
 */
public class TestQueue {
    public static void main(String[] args){
       
        
        Stack<Integer> st = new ArrayStack();
        st.push(4);
        st.push(1);
        st.push(2);
        st.push(3);
        Queue<Integer> qu= new ArrayQueue();
        
        qu.enqueue(1);
        qu.enqueue(3);
        qu.enqueue(2);
        qu.enqueue(8);
        System.out.println("Queue "+qu);
        reverseQueue(qu);
        System.out.println("Reverse Queue "+qu);
       
        System.out.println(st);
        
        
        System.out.println(copyStack(st));
        System.out.println(st);
        
        insert(st, 3,2);
        System.out.println("number of even numbers "+evenCount(st));
        
        
    }
}
