package impl;

import adt.HashTableSet;

public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {

    private BSTset<T>[] buckets;
    private int size;

    public BSTHashTableSet(int numBuckets){
        buckets= new  BSTset[numBuckets];
        size=0;

    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    public String toString(){
        int counter = 0;
        String string = "[ \n";
        for (int k = 0;k<buckets.length;k++){
            if(k == buckets.length-1 && buckets[buckets.length-1] == null && counter == 0) return "top[  ]bottom";
            if(buckets[k] != null){
                if(buckets[k].getSize()!=0){
                    string+= buckets[k].toString()+'\n';
                    counter++;
                }
            }

        }
        string+=" ]";
        return string;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index>buckets.length||0>index){
            throw new Exception("Index out of range");
        }
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return size/buckets.length;
    }

    @Override
    public double getBucketSizeStandardDev() {

        double prod=0;
        double mean = size / buckets.length;
        for (int j = 0; j<buckets.length;j++){
            if(buckets[j]!=null){
                prod +=Math.abs(buckets[j].getSize()-mean)*Math.abs(buckets[j].getSize()-mean);
            } else{
                prod+=mean*mean;
            }

        }
        double std=Math.sqrt(prod/buckets.length);
        return std;
    }

    @Override
    public String bucketsToString() {
        int counter = 0;
        String string = "";
        for (int k = 0;k<buckets.length;k++){
            if(buckets[buckets.length-1] == null && counter == 0) return "[  ]";
            if(buckets[k] != null){
                if(buckets[k].getSize()!=0){
                    string+= buckets[k].toString() + '\n';
                    counter++;
                }
            }else if(buckets[k]==null && counter!=0){
                string+= "[ ]\n";
            }

        }
        return string;
    }


    public void add(T value) {
        if(!contains(value)){
            if(buckets[Math.abs(value.hashCode()%buckets.length)]==null){
                buckets[Math.abs(value.hashCode()%buckets.length)]= new BSTset<>();
            }
            buckets[Math.abs(value.hashCode()%buckets.length)].add(value);
            size++;
        }


    }


    public boolean contains(T value) {
        if(buckets[Math.abs(value.hashCode()%buckets.length)]==null){
            return false;
        }

        return buckets[Math.abs(value.hashCode()%buckets.length)].contains(value);
    }


    public boolean remove(T value) {
        if (contains(value)){
            buckets[Math.abs(value.hashCode() % buckets.length)].remove(value);
            size--;
            return true;
        }
        return false;
    }


    @Override
    public T removeAny() throws Exception {
        if(size==0){
            throw new Exception("Set is empty");
        }
        T temp;
        for (int k = 0;k<buckets.length;k++){
            if(buckets[k].getSize()!=0){
                temp = buckets[k].removeAny();
                size--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size =0;
        buckets = new BSTset[buckets.length];
    }
}
