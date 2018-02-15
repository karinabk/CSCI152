/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphism;

/**
 *
 * @author Karina
 */
public class Professor extends NUpeople {
    
    private String workingField;
    
    public Professor(String name,int id,boolean vg,String field){
        super (name,id,vg);
        workingField= field;
        
    }
    /**
     * activities in Nazarbayev university
     */
    public void purpose(){
        System.out.println("Purpose: teaching, research conducting");
    }

    /**
     * @return the workingField
     */
    public String getWorkingField() {
        return workingField;
    }

    /**
     * @param workingField the workingField to set
     */
    public void setWorkingField(String workingField) {
        this.workingField = workingField;
    }
    /**
     * information about object in string representation
     * @return 
     */
    public String toString(){
        return "Name: " + getName()+"\nID number: " + getID() +"\nWorking Field: "+
                getWorkingField();
    }
    
    
    
}
