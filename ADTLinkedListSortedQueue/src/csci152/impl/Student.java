/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author Karina
 */
public class Student implements Comparable<Student> {
    
    private String name;
    private int ID;
    
    public Student(String n,int id){
        name = n;
        ID = id;
    }

    @Override
    public int compareTo(Student std) {
//        if(ID>=std.getID()) return 1;
//        else return -1;
        
        return name.compareTo(std.getName());
    }
    
   

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
     public String toString(){
        return "Name:" + getName()+" ID: "+getID();
    }
}
