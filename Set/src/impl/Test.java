package impl;

import adt.Set;


import static impl.Methods.isSubset;
import static impl.Methods.union;
import static impl.Methods.intersection;

public class Test {
    public static void main(String[] args){
        Set<Student> set1=new LLQueueSet<>();

        try{
            System.out.println(set1.removeAny());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(set1 + " Size: " + set1.getSize());

        set1.add(new Student("Iren", 666));
        set1.add(new Student("Man",98765));
        set1.add(new Student("Elzhan",7654));
        set1.add(new Student("Karina",75432));
        set1.add(new Student("Khakw",765455));
        System.out.println(set1 + " Size: " + set1.getSize());

        Student newS = new Student("Man",98765);
        try{
            Student st1 = new Student ("Arr",000);
            System.out.println(set1.remove(newS)+ " "+ set1 +" "+ set1.getSize());
            System.out.println(set1.remove(st1)+ " "+ set1 +" "+ set1.getSize());
            Student st2 = new Student ("Iren",666);
            Student st3 = new Student ("Elzhan",7654);
            set1.add(st2);
            set1.add(st3);
            System.out.println( " "+ set1 +" "+ set1.getSize());
            set1.add(new Student ("Tim",44));
            set1.add(new Student("Tom",4));
            set1.add(new Student("Ron",4));
            System.out.println(set1.removeAny()+" "+ set1 +" "+ set1.getSize());
            System.out.println(set1.removeAny()+" "+ set1 +" "+ set1.getSize());
            System.out.println(set1.removeAny()+" "+ set1 +" "+ set1.getSize());
            set1.clear();
            System.out.println(" "+ set1 +" "+ set1.getSize());
            set1.add(new Student("Tom",4));
            set1.add(new Student("Ron",4));
            System.out.println(" "+ set1 +" "+ set1.getSize());
        }catch (Exception n){

        }
        Set<String> setStr=new LLQueueSet<>();
        Set<String> setStr2= new LLStackSet<>();
        setStr2.add("A");
        setStr2.add("B");
        setStr2.add("C");
        setStr2.add("D");
        setStr.add("D");
        setStr.add("A");
        System.out.println("set1" + setStr+"set2 "+setStr2);
        System.out.println(union(setStr,setStr2));
        System.out.println("set1" + setStr+"set2 "+setStr2);

        Set<Integer> setInt1 = new LLQueueSet<>();
        Set<Integer> setInt2 = new LLStackSet<>();

        setInt1.add(1);
        setInt2.add(3);
        setInt2.add(2);
        System.out.println("set1" + setInt1+"set2 "+setInt2);
        System.out.println("INTERSECTION" + intersection(setInt1,setInt2));
        System.out.println("set1" + setInt1+"set2 "+setInt2 +" Is Subset? "+ isSubset(setInt1,setInt2));

    }
}
