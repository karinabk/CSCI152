package impl;
import adt.Set;

public class Methods {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> tempSet = new LLQueueSet<>();
        boolean bool=true;
                for (int i = 0; i < set1.getSize(); i++) {
                    try {
                        int x = set1.removeAny();
                        tempSet.add(x);
                        if (!set2.contains(x)) {
                            bool= false;
                        }
                    }catch (Exception e){
                    }
                }
                try{
                    while(tempSet.getSize()!=0){
                        set1.add(tempSet.removeAny());
                    }
                }catch (Exception e){

                }
             return bool;
    }

    public static Set<String> union (Set<String> set1,Set<String> set2){
        Set<String> mySt = new LLQueueSet<>();
        Set<String> union = new LLQueueSet<>();
        Set<String> mySt2 = new LLQueueSet<>();
        String temp = "";
        for(int i = 0 ; i<set1.getSize();i++){
            try{temp = set1.removeAny();
                mySt.add(temp);
                if (!set2.contains(temp)){
                    union.add(temp);
                }

            }catch (Exception e){

            }
        }
        try{
            if (set1.getSize()!=0){
                while(set1.getSize()!=0){
                    String str= set1.removeAny();
                    mySt.add(str);
                    union.add(str);
                }
            }
            while(mySt.getSize()!=0){
                set1.add(mySt.removeAny());
            }
            if(set2.getSize()!=0){
                while(set2.getSize()!=0){
                    String h = set2.removeAny();
                    union.add(h);
                    mySt2.add(h);
                }
            }
            while(mySt2.getSize()!=0){
                set2.add(mySt2.removeAny());
            }
        }catch (Exception e ){

        }
        return union;
    }

    public static Set<Integer> intersection (Set<Integer> set1,Set<Integer> set2){
        Set<Integer> mySt = new LLQueueSet<>();
        Set<Integer> keep = new LLQueueSet<>();
        int temp;
        for (;set1.getSize()>0;){
            try{
                temp = set1.removeAny();
                keep.add(temp);
                if (set2.contains(temp)){
                    mySt.add(temp);
                }
            }catch (Exception e){
        System.out.println("Something is wrong");
            }

        } try{
            while(keep.getSize()!=0){
                set1.add(keep.removeAny());
            }
        }catch (Exception e) {
        }
        return mySt;
    }
}
