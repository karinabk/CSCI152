package impl;

import adt.HashTableSet;

public class BSThashTest {
    public static void main(String[] args){
        HashTableSet<Student> newSet = new BSTHashTableSet<>(10);
        for(int k = 100; k <300; k++){
            newSet.add(new Student("BOB", k));
        }
        System.out.println(newSet.toString());

        System.out.println("load factor" + newSet.getLoadFactor() + "\n bucket size Standard deviation"
                + newSet.getBucketSizeStandardDev());

    }
}
