/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import csci152.adt.Deque;
import static csci152.impl.MergeSort.merge;
import static csci152.impl.MergeSort.mergeSort;

/**
 *
 * @author Karina
 */
public class Test {
    public static void main(String[] args){
        Deque<Integer> deq1= new LinkedListDeque();
        Deque<Integer> deq2 = new LinkedListDeque();
//        try {
//            deque.popFromBack();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        for(int i = 0; i<5 ; i++){
//            deque.pushToFront(i);
//        }
//            System.out.println(""+deque + deque.getSize());
//        try{
//            for (int k = 0; k<5 ;k ++){
//                deque.popFromFront();
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(""+deque + deque.getSize());
//         for(int i = 0; i<6 ; i++){
//            deque.pushToFront(i);
//        }
//         System.out.println(""+deque + deque.getSize());
//         try{
//            for (int k = 0; k<6 ;k ++){
//                deque.popFromBack();
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//         System.out.println(""+deque + deque.getSize());
//         for(int i = 0; i<7 ; i++){
//            deque.pushToFront(i);
//        }
//          System.out.println(""+deque + deque.getSize());
//          try{
//            for (int k = 0; k<7 ;k ++){
//                deque.popFromBack();
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//          System.out.println(""+deque + deque.getSize());
//            for(int i = 0; i<8 ; i++){
//            deque.pushToFront(i);
//        }
//          System.out.println(""+deque + deque.getSize());
//          try{
//            for (int k = 0; k<8 ;k ++){
//                deque.popFromBack();
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//          System.out.println(""+deque + deque.getSize());
//           for(int i = 0; i<10 ; i++){
//            deque.pushToFront(i);
//            deque.pushToBack(i);
//            System.out.println(""+deque + deque.getSize());
//           }
//             try{
//            for (int k = 0; k<8 ;k ++){
//                deque.popFromBack();
//                deque.popFromFront();
//                System.out.println(""+deque + deque.getSize());
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        deque.clear();
//        System.out.println(""+deque + deque.getSize());
                deq1.pushToBack(3);
                deq1.pushToBack(4);
                
                deq1.pushToBack(5);
                
                deq1.pushToBack(9);
                deq1.pushToBack(30);
//                deq2.pushToBack(2);
//                deq2.pushToBack(2);
//                deq2.pushToBack(7);
//                deq2.pushToBack(9);
//                deq2.pushToBack(12);
//                deq2.pushToBack(30);
//                deq2.pushToBack(30);
//                deq2.pushToBack(32);
//                System.out.println("Deque 1 "+deq1 + deq1.getSize());
//                System.out.println("Deque 2 "+deq2 + deq2.getSize());
//                System.out.println("Merge "+merge(deq1,deq2)); 
                System.out.println("Merge "+mergeSort(deq1)); 
    }
}
