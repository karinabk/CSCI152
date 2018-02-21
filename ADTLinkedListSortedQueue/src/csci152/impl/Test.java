/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.SortedQueue;

/**
 *
 * @author Karina
 */
public class Test {
    public static void main(String[] args){
        SortedQueue<Integer> newQueue = new LinkedListSortedQueue();
        
        for (int i=90;i>=10;i=i-10){
            newQueue.insert(i);
        }
        System.out.println(newQueue + " size " + newQueue.getSize());
        try{
            newQueue.dequeue();
            newQueue.dequeue();
            newQueue.dequeue();
        
            System.out.println("after dequeue " +newQueue + " size " + newQueue.getSize());
            for (int i=100;i<=900;i=i+100){
                newQueue.insert(i);
            }       
            System.out.println(newQueue + " size " + newQueue.getSize());
            newQueue.dequeue();
            newQueue.dequeue();
            newQueue.dequeue();
            newQueue.dequeue();
            System.out.println("after dequeue " +newQueue + " size " + newQueue.getSize()); 
            for (int i=5;i<=915;i=i+10){
                newQueue.insert(i);
            }
            System.out.println(newQueue + " size " + newQueue.getSize()); 
            
            for (;newQueue.getSize() != 0;){
              newQueue.dequeue();
              System.out.println(newQueue +" " + newQueue.getSize());
            }
            System.out.println("Dequeue all " +newQueue + " size " + newQueue.getSize()); 
            
            newQueue.insert(4);
            newQueue.insert(5);
            newQueue.insert(3);
            System.out.println(newQueue + " size " + newQueue.getSize()); 
            newQueue.clear();
            System.out.println("after clear " +newQueue + " size " + newQueue.getSize()); 
            newQueue.insert(4);
            newQueue.insert(5);
            newQueue.insert(3);
            newQueue.insert(3);
            System.out.println(newQueue + " size " + newQueue.getSize()); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        
        //TEST FOR STUDENT CLASS
        
        SortedQueue<Student> st1 = new LinkedListSortedQueue();
        Student std = new Student("Babyr",333);
        Student std2 = new Student("Kamila",233);
        Student std3 = new Student("Bubenchik",111);
        st1.insert(std);
        st1.insert(std2);
        st1.insert(std3);
        System.out.println(st1);
    }
    
}
