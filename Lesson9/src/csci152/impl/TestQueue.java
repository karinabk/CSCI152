/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;
import static csci152.impl.NovoeImya.isIncreasing;



/**
 *
 * @author Karina
 */
public class TestQueue {
    public static void main(String[] args){
       Stack newList = new LinkedListStack();
       
       try{
            newList.pop();
              }catch (Exception ex){
            System.out.println(ex.getMessage());
       }
       try{ 
       for (int i = 0; i< 12;i++){
                newList.push(i);
                }
            System.out.println("Push 12 elemetns"+newList+"\n siize "+newList.getSize());
            newList.pop();
            newList.pop();
            System.out.println("Pop 2 elemetns"+newList+"\n siize "+newList.getSize());
            newList.clear();
            System.out.println("After clear" + newList+"\nSize "+newList.getSize());
            for (double i = 0; i< 22;i++){
                newList.push(i);
                }
            System.out.println("Push 22 items" + newList+"\nSize "+newList.getSize());
       }catch (Exception ex){
            System.out.println(ex.getMessage());
       }
       
        newList.push(2.0);
        System.out.println(newList);
        System.out.println(isIncreasing(newList));   
        System.out.println(newList);
       
       
        
    }
}
