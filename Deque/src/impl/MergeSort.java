/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import csci152.adt.Deque;

/**
 *
 * @author Karina
 */
public class MergeSort {
    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2){
        Deque<Integer> newDeque = new LinkedListDeque();
        int one=0,two = 0;
        for(;d1.getSize()!=0 && d2.getSize() != 0;){
            try {
                one = d1.popFromFront();
                two=d2.popFromFront();
                if (one <= two){
                    newDeque.pushToBack(one);
                    d2.pushToFront(two);
                }else {
                    newDeque.pushToBack(two);
                    d1.pushToFront(one);
                }
                if(d1.getSize() == 0){
                    while(d2.getSize() != 0){
                        newDeque.pushToBack(d2.popFromFront());
                    }
                } else if (d2.getSize() == 0){
                    while(d1.getSize() != 0){
                        newDeque.pushToBack(d1.popFromFront());
                    }
                }
            }catch(Exception e){
                System.out.println("kjhgf");
            }
            
        }
        
        return newDeque;
    }
    public static Deque<Integer> mergeSort(Deque<Integer> deq){
        if (deq.getSize()==1){
            return deq;
        }
        Deque<Integer> deq1=new LinkedListDeque();
        Deque<Integer> deq2 = new LinkedListDeque();
  
            try{
                for (int i=0;i<=deq.getSize()/2;i++){
                    deq1.pushToBack(deq.popFromBack());
                }
                
                for(;deq.getSize() != 0;){
                    deq2.pushToBack(deq.popFromBack());
                }
                System.out.println(deq1 + " " + deq2);    
            }catch (Exception e){
                        System.out.println(e.getMessage());    
            }
            

        deq1 = mergeSort(deq1);
        deq2 =mergeSort(deq2);
        return merge(deq1,deq2);
            
        }        
    }
    

