///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package csci152.impl;
//
//import csci152.adt.Queue;
//import csci152.adt.Stack;
//import static csci152.impl.NovoeImya.isIncreasing;
//
//
//
///**
// *
// * @author Karina
// */
//public class TestQueue {
//    public static void main(String[] args){
//       Queue newList = new LinkedListQueue();
//       
//       try{
//            newList.dequeue();
//              }catch (Exception ex){
//            System.out.println(ex.getMessage());
//       }
//       try{ 
//       for (int i = 0; i<8 ;i++){
//                newList.enqueue(8);
//                }
//            System.out.println("Enqueue 12 elemetns"+newList+"\n siize "+newList.getSize());
//            newList.dequeue();
//            newList.dequeue();
//            newList.dequeue();
//            System.out.println("Dequeue 3 elemetns"+newList+"\n siize "+newList.getSize());
//            for ( int k =0; k<9;k++){
//                newList.enqueue(k);
//                newList.enqueue(k);
//                newList.dequeue();
//                newList.dequeue();
//            System.out.println("Inside loop" + newList+"\nSize "+newList.getSize());
//            }
//            newList.clear();
//            System.out.println("After clear" + newList+"\nSize "+newList.getSize());
//            for (double i = 0; i< 22;i++){
//                newList.enqueue(i);
//                }
//            System.out.println("Enqueue 22 items" + newList+"\nSize "+newList.getSize());
//       }catch (Exception ex){
//            System.out.println(ex.getMessage());
//       }
//       
//    
//       
//       
//        
//    }
//}
