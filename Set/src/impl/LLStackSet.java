package impl;

import adt.Set;
public class LLStackSet<T> implements Set<T> {

    private LinkedListStack<T> stack;

    public LLStackSet(){
        stack = new LinkedListStack<T>();
    }


    public void add(T value){
        if (!contains(value)){
            stack.push(value);
        }
    }

    public boolean contains(T value){
        LinkedListStack<T> temp = new LinkedListStack<>();
        for (;0<stack.getSize();){
            try{
                T x = stack.pop();
                temp.push(x);
                if(x.equals(value)){
                    while(temp.getSize()!=0){
                        stack.push(temp.pop());
                    }
                    return true;
                }
            }catch (Exception ex){

            }
        }while(temp.getSize()!=0){
            try{
                stack.push(temp.pop());
            }catch (Exception e){

            }

        }
        return false;
    }

    public boolean remove(T value){
        LinkedListStack<T> temp = new LinkedListStack<>();
        for (;0<stack.getSize(); ){
            try{
                T x = stack.pop();
                if(!x.equals(value)){
                    temp.push(x);
                }else{
                    while(temp.getSize()!=0) {
                        try {
                            stack.push(temp.pop());

                        } catch (Exception e) {

                        }
                    }
                        return true;
                }
            }catch (Exception ex){

            }
        }
        while(temp.getSize()!=0){
            try{
                stack.push(temp.pop());

            }catch (Exception e){

            }
        }
        return false;
    }

    public T removeAny() throws Exception{
        if (stack.getSize()==0){
            throw new Exception("Set is empty");
        }
        T x = null;
        try {
            x = stack.pop();
        }catch (Exception e){

        }
        return x;
    }

    public int getSize(){
        return stack.getSize();
    }
    public void clear(){
        LinkedListStack<T> newS=new LinkedListStack<T>();
        stack=newS;
    }

    public String toString(){
        return stack.toString();
    }

}
