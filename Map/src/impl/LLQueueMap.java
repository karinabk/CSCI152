package impl;

import adt.Map;

public class LLQueueMap<K,V> implements Map<K,V> {

    private LinkedListQueue<KeyValuePair<K,V>> pairs;

    public LLQueueMap(){
        pairs = new LinkedListQueue<>();
    }

    @Override
    public void define(K key, V value) {
        for (int i = 0; i<pairs.getSize();i++){
            try{
                KeyValuePair temp = pairs.dequeue();
                pairs.enqueue(temp);
                if (temp.getKey().equals(key)){
                    temp.setValue(value);
                    return ;
                }
            }catch (Exception ex){
                System.out.println("Error in the Define");
            }
        }
        pairs.enqueue(new KeyValuePair(key,value));
    }

    @Override
    public V getValue(K key) {
        for (int i = 0; i<pairs.getSize();i++){
            try{
                KeyValuePair temp = pairs.dequeue();
                pairs.enqueue(temp);
                if (temp.getKey().equals(key)){
                    return (V) temp.getValue();
                }
            }catch (Exception ex){
                System.out.println("Eror in the getValue");
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        for (int i = 0; i<pairs.getSize();i++){
            try{
                KeyValuePair temp = pairs.dequeue();
                if (!temp.getKey().equals(key)){
                    pairs.enqueue(temp);
                }else {
                    return (V) temp.getValue();
                }
            }catch (Exception ex){
                System.out.println("Error in the remove");
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(pairs.getSize()==0){
            throw new Exception("Linked List Map is empty");
        }
        return pairs.dequeue();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue<>();

    }

    public String toString(){
        return pairs.toString();
    }

}
