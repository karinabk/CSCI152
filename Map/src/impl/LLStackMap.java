package impl;
import adt.Map;

public class LLStackMap<K,V> implements Map<K,V> {

    private LinkedListStack<KeyValuePair<K,V>> pairs;

    public LLStackMap(){
        pairs = new LinkedListStack<>();
    }


    @Override
    public void define(K key, V value) {
        LinkedListStack<KeyValuePair<K,V>> temp = new LinkedListStack<>();
        for (;0<pairs.getSize();){
            try{
                KeyValuePair x = pairs.pop();
                temp.push(x);
                if(x.getKey().equals(key)){
                    while(temp.getSize()!=0){
                        pairs.push(temp.pop());
                    }
                    x.setValue(value);
                    return ;
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(temp.getSize()!=0) {
            try {
                pairs.push(temp.pop());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        pairs.push(new KeyValuePair<>(key,value));

    }

    @Override
    public V getValue(K key) {
        LinkedListStack<KeyValuePair<K,V>> temp = new LinkedListStack<>();
        for (;0<pairs.getSize();){
            try{
                KeyValuePair x = pairs.pop();
                temp.push(x);
                if(x.getKey().equals(key)){
                    while(temp.getSize()!=0){
                        pairs.push(temp.pop());
                    }
                    return (V)x.getValue();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }while(temp.getSize()!=0) {
            try {
                pairs.push(temp.pop());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        LinkedListStack<KeyValuePair<K,V>> temp = new LinkedListStack<>();
        for (;0<pairs.getSize(); ){
            try{
                KeyValuePair x = pairs.pop();
                if(!x.getKey().equals(key)){
                    temp.push(x);

                }else{
                    while(temp.getSize()!=0) {
                        pairs.push(temp.pop());
                    }
                    return (V)x.getValue();
                }
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        while(temp.getSize()!=0){
            try{
                pairs.push(temp.pop());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(pairs.getSize()==0){
            throw new Exception("Linked List Map is empty");
        }
        return pairs.pop();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack<>();
    }

    public String toString(){
        return pairs.toString();
    }
}
