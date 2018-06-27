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
 * @param <T>
 */
public class    LinkedListDeque<T> implements Deque<T> {
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;
    
    public LinkedListDeque(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if(front==null){
            front=back=newNode;
        }else{
            newNode.setNext(front);
            front.setPrevious(newNode);
            front=newNode;
        }
        size ++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if(front==null){
           front=back=newNode;
        } else {
           back.setNext(newNode);
           newNode.setPrevious(back);
           back = newNode;
        }
        size++;
    }

    @Override
    public T popFromFront() throws Exception {
       if(size==0){
            throw new Exception("Deque is empty");
        }
        T result = front.getValue();
        if(size ==1){
            back = null;
            front = null;
        }else if(size != 1) {
        front.setPrevious(null);
        front=front.getNext();     
        }
        size--;
        return result;
    }

    @Override
    public T popFromBack() throws Exception {
         if(size==0){
            throw new Exception("Deque is empty");
        }
        T result = back.getValue();
        if(size ==1){
            back = null;
            front = null;
        }else if(size != 1) {
        back.setNext(null);
        back=back.getPrevious();     
        }
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        back = null;
        front = null;
        size = 0;
    }
    public String toString(){
        String newString=" ";
        DoublyLinkedNode start = front;
        while(start != null){
            newString += start.getValue()+" ";
            start = start.getNext();
        }
        return "top[ "+newString +" ]bottom";
    }
    
}
