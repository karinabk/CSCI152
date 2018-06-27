package impl;
import adt.HashTableSet;
import adt.HashTableStats;

public class StudentTest {
    public static void main(String[] args){
        HashTableSet<Student> set = new LLQHashTableSet<>(100);
        for(int k = 100; k <300; k++){
            set.add(new Student("BOB", k));
        }

        System.out.println(set.toString());

        System.out.println("load factor" + set.getLoadFactor() + "\n bucket size Standard deviation"
                + set.getBucketSizeStandardDev());

    }
}
