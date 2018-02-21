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
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {
    
    private Node<T> front;
    
    int size;
    
    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
    
    @Override
    public void insert(T value) {
       Node<T> newNode = new Node(value);
       Node run = null;
       Node previous=null;
       if (size==0){
           front = newNode;
       }else {
           if (value.compareTo(front.getValue())<=0){
               newNode.setLink(front); 
               front = newNode;
           }else{
                run = front;
                while(run!=null){
                    if(value.compareTo(run.getValue())<=0){
                        newNode.setLink(run);
                        previous.setLink(newNode);
                        break;
                    }
                    previous = run;
                    run = run.getLink();
                    if (run==null){    
                        previous.setLink(newNode);
                        newNode.setLink(null);
                }
                }    
               
           }     
       }
       size++;
    }

   

    @Override
    public T dequeue() throws Exception {
        if(size==0){
            throw new Exception("Linked Queue is empty");
        }
        this.size--;
        T result = front.getValue();
        front=front.getLink();
        
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size =0;
    }
    
    public String toString(){
        String newString=" ";
        Node start = front;
        while(start != null){
            newString += start.getValue()+" ";
            start = start.getLink();
        }
        return "top[ "+newString +" ]bottom";
    }

    
}
