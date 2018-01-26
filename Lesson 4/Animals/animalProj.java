package animalproj;

/**
 *
 * @author Karina
 */
public interface Animal {
    /**
     * returns the kind of the animal
     * @return kind of the animal
     */
    public String animalKind();
    /**
     * allows to set the value for maxAge variable
     * @param maxAge 
     */
    public void setMaxAge(int maxAge);
    /**
     * returns the age of the animal
     * @return age of the animal
     */
    
    public int getAge();
    /**
     * check whether or not animal could eat this type of food
     * @param food for animal
     * @return yes of not
     */
    public boolean canEat(String food);
    /**
     * feeds an animal
     * @param food
     * @throws Exception in case if the animal cannot eat this
     */
    public void feed(String food)throws Exception;
    
    /**
     * makes animal one year older
     */
            
    public void ageOneYear();
    /**
     * returns sounds that animal makes
     */
    public String voice();
    
}
