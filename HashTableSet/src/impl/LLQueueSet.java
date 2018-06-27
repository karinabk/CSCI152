package impl;

import adt.Set;


public class LLQueueSet<T> implements Set<T> {

    private LinkedListQueue<T> queue;

   public LLQueueSet(){
        queue = new LinkedListQueue<>();
    }
    public void add(T value){
        if (!contains(value)){
            queue.enqueue(value);
        }
    }

    public boolean contains(T value){
        for (int i=0;i<queue.getSize(); i++){
            try{
                T x = queue.dequeue();
                queue.enqueue(x);

                if(x.equals(value)){
                    return true;
                }
            }catch (Exception ex){

            }
        } return false;
    }

    public boolean remove(T value){
        for (int i=0;i<queue.getSize(); i++){
            try{
                T x = queue.dequeue();
                if(!x.equals(value)){
                    queue.enqueue(x);
                }else {
                    return true;
                }
            }catch (Exception ex){
            }
        } return false;
    }

    public T removeAny() throws Exception{
        if (queue.getSize()==0){
            throw new Exception("Set is empty");
        }
        T x = null;
        try {
            x = queue.dequeue();
        }catch (Exception e){

        }
        return x;
    }

    public int getSize(){
        return queue.getSize();
    }

    public void clear(){
        LinkedListQueue<T> newQ=new LinkedListQueue<>();
        queue=newQ;
    }

    public String toString(){
        return queue.toString();
    }
}
