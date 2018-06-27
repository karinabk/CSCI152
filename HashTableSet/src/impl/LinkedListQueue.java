/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Queue;

/**
 *
 * @author Karina
 */
public class LinkedListQueue<T> implements Queue<T> {
    
    private Node<T> front;
    private Node<T> back;
    int size;
    
    public LinkedListQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node(value);
        if(front==null){
           front=back=newNode;
        } else {
           back.setLink(newNode);
           back = newNode;
        }
        size++;
    }    

    @Override
    public T dequeue() throws Exception {
        if(size==0){
            throw new Exception("Linked Queue is empty");
        }
        T result = front.getValue();
        front=front.getLink();
        
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size =0;
    }
    
    public String toString(){
        String newString="";
        Node start = front;
        while(start != null){
            newString += start.getValue()+" ";
            start = start.getLink();
        }
        return "[ "+newString +"]";
    }
    
}
