/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import adt.Stack;

/**
 *
 * @author Karina
 */
public class LinkedListStack<T> implements Stack<T> {
        
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    
    public void push (T value){
        Node<T> newTop= new Node(value);
        newTop.setLink(top);
        top = newTop;
        size ++;

    }

    @Override
    public T pop() throws Exception {
        if (top==null){
            throw new Exception("Linked list is empty");
        }
       T result = top.getValue();
       top = top.getLink();
       size--;
       return result;
    }

    @Override
    public int getSize() {
        return size;    
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    public String toString(){
        String string = "";
        Node temp = top;
        while(temp!=null){
            string =string + temp.getValue() + " ";
            temp = temp.getLink();
        }
        return "top ["+ string+"]bottom";
    }
    
    
    
}
