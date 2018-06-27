package impl;
import adt.HashTableSet;

import java.util.Random;

public class TesterTime {
    public static void main(String[] args){

    HashTableSet<Integer> set = new BSTHashTableSet<>(10);
        Random rand = new Random();

     System.out.println("Starting timing tests...");
    long time1, time2, duration;
    time1 = System.currentTimeMillis();


     for (int i = 0; i < 50000; i++) {
        set.add(rand.nextInt());

    }

    time2 = System.currentTimeMillis();
    duration = time2 - time1;

     System.out.println("Time taken in ms: " + duration);
     System.out.println("Load factor: " + set.getLoadFactor() +"Bucket Size Standard deviation"+set.getBucketSizeStandardDev());
}
}
