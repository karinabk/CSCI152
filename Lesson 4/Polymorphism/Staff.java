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
public class Staff extends NUpeople{
    
    private String workingPlace;
    
    public Staff(String n, int id,boolean vg,String pl){
        super(n,id,vg);
        workingPlace = pl;
    }
    /**
     * purpose 
     */
    public void purpose(){
        System.out.println("Purpose: service");
    }

    /**
     * @return the workingPlace
     */
    public String getWorkingPlace() {
        return workingPlace;
    }

    /**
     * @param workingPlace the workingPlace to set
     */
    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }
    /**
     * information about object in string representation
     * @return 
     */
    public String toString(){
    return "Name: " + getName()+"\nID number: " + getID() +"\nWorking Place: "+
                getWorkingPlace();
    }
    
}
