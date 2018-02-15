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
public class Students extends NUpeople {
    
    private int studyYear;
    
    public Students(String n, int v,int y,boolean vg){
        super (n,v,vg);
        studyYear =y;
    }
    /**
     * aim of being in university 
     */
    public void purpose(){
        System.out.println("Purpose: Studying");
        
    }

    /**
     * @return the studyYear
     */
    public int getStudyYear() {
        return studyYear;
    }

    /**
     * @param studyYear the studyYear to set
     */
    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }
    /**
     * information about object in string representation
     * @return 
     */
    public String toString(){
        return "Name: " + getName()+"\nID number: " + getID() +"\nYear of Study: "+
                getStudyYear();
    }
}
