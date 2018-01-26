package polymorphism;

/**
 *
 * @author Karina
 */
public class NUpeople {
    
    private String name;
    private int ID;
    private boolean vegetarian;
    
    public NUpeople(String n,int v, boolean vg){
        name = n;
        ID = v;
        vegetarian=vg;
    }
    /**
     * duties in Nazarbayev University
     */
    public void purpose(){
        System.out.println("Work");
    }
    /**
     * how much hours wer ewasted
     */
    public void procrastination(){
        System.out.println("Wasting one hour of your time");
    }
        /**
         * details about meal, preferences in food 
         */
    public void mealPlan(){
        if (vegetarian){
            System.out.println("Meal information: vegetarian");
        } else {
            System.out.println("Meal information: usual");
        }
    }
    /**
     * information about object in string representation
     * @return 
     */
    public String toString(){
        return "Name: " + getName()+ "\n ID number: " + getID();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @return the isVegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }

    /**
     * @param isVegetarian the isVegetarian to set
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }



}
