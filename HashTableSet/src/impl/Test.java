package impl;


import adt.HashTableSet;

public class Test {
    public static void main(String[] args){
        HashTableSet<Integer> newSet = new LLQHashTableSet(10);
        try{
            newSet.removeAny();

        }catch(Exception e){
          //      System.out.println(e.getMessage());
        }
        for (int i=1 ; i<21;i++){
            newSet.add(i);
        }
//        System.out.println(""+newSet + newSet.getSize()+"");

        for(int k = 1;k<21;k++){
            if (k%2==0){
                newSet.remove(k);
            }
        }
        System.out.println(""+newSet + newSet.getSize()+"");

        System.out.println(""+newSet.remove(10)+newSet.remove(100));
        System.out.println(""+newSet + newSet.getSize()+"");
        for(int k = 1;k<31;k++){
            newSet.add(k);
        }
        System.out.println(""+newSet + newSet.getSize()+"");
        try {
            for (int k = 0; k < 10; k++) {
                System.out.println(newSet.removeAny());
            }
        }catch(Exception e){

        }
        System.out.println(""+newSet + newSet.getSize()+"");
        newSet.clear();
        System.out.println(""+newSet + newSet.getSize()+"");
        for(int k = 51;k<80;k++){
            if (k%2==1){
                newSet.add(k);
            }
        }
        System.out.println(""+newSet.bucketsToString() + newSet.getSize()+"");
        System.out.println(newSet.getBucketSizeStandardDev());
        newSet.clear();
        for(int i = 0; i < 11; i++) newSet.add(i);
        System.out.println(newSet.getBucketSizeStandardDev());
    }
}
