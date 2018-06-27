package impl;

import adt.HashTableMap;

public class LLQHashTableMap<K extends Comparable,V> implements HashTableMap<K,V> {

    private LinkedListQueue<KeyValuePair<K,V>>[] buckets;
    private int size;

    public LLQHashTableMap(int num){
        size =0;
        buckets = new LinkedListQueue[num];
    }


    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
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
            }else{
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
            if(buckets[buckets.length-1] == null && counter == 0&&k==buckets.length-1) return "[  ]";
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

    @Override
    public void define(K key, V value) {
        if(buckets[Math.abs(key.hashCode()%buckets.length)]==null){
            buckets[Math.abs(key.hashCode()%buckets.length)]= new LinkedListQueue<>();
        }
        if(contains(key)==null){
            buckets[Math.abs(key.hashCode()%buckets.length)].enqueue(new KeyValuePair<>(key,value));
            size++;
        }else{
            KeyValuePair temp = contains(key);
            temp.setValue(value);
        }
    }
    private KeyValuePair<K,V> contains(K key) {
        if(buckets[Math.abs(key.hashCode()%buckets.length)]==null){
            return null;
        }
        int sizeAr = buckets[Math.abs(key.hashCode()%buckets.length)].getSize();
        for (int i = 0; i<sizeAr; i++){
            try {
                KeyValuePair<K,V> temp;
                temp = buckets[Math.abs(key.hashCode() % buckets.length)].dequeue();
                buckets[Math.abs(key.hashCode()%buckets.length)].enqueue(temp);
                if(temp.getKey().equals(key)){
                    return temp;
                }
            }catch(Exception e){
                System.out.println("");
            }
        }
        return null;
    }

    @Override
    public V getValue(K key) {
        if (contains(key)==null)  return null;
        return contains(key).getValue();
    }

    @Override
    public V remove(K key) {
        if (contains(key)!=null){
            for(int j = 0 ;j<buckets[Math.abs(key.hashCode() % buckets.length)].getSize();j++) {
                try {
                    KeyValuePair<K,V> temp = buckets[Math.abs(key.hashCode() % buckets.length)].dequeue();
                    if (!temp.getKey().equals(key)) {
                        buckets[Math.abs(key.hashCode() % buckets.length)].enqueue(temp);
                    }
                    size--;
                    return temp.getValue();
                } catch (Exception e) {
                    System.out.println("error");
                }
            }

        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size==0){
            throw new Exception("Map is empty");
        }
        KeyValuePair<K,V> temp;
        for (int k = 0;k<buckets.length;k++){
            if(buckets[k].getSize()!=0){
                temp = buckets[k].dequeue();
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
        buckets = new LinkedListQueue[buckets.length];
    }

    public String toString(){
        int counter = 0;
        String string = "[ \n";
        for (int k = 0;k<buckets.length;k++){
            if(k == buckets.length-1 && buckets[buckets.length-1] == null && counter == 0) return "[  ]";
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

}
