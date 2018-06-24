package impl;
import adt.Set;
public class BSTtest {
    public static void main(String[] args){
        Set <Integer> bst = new BSTset<>();
        System.out.println("BST : " + bst);
        bst.add(5);
        bst.add(12);
        bst.add(3);
        bst.add(6);
        bst.add(14);
        bst.add(2);

        bst.add(-6);
        bst.add(8);
        bst.add(0);
        System.out.println("Size: "+ bst.getSize());
        bst.add(14);
        bst.add(-6);
        bst.add(5);
        System.out.println("BST: "+ bst);
        System.out.println("12 " + bst.contains(12)+ "| 7 "+bst.contains(7) + "| 2 " + bst.contains(2) + " | -8 "+bst.contains(-8)
                + " | 5 " + bst.contains(5));
        System.out.println("BST: "+ bst +"Size"+ bst.getSize());
        try {
            System.out.println("remove 0 : " + bst.remove(0)+"remove 6"+bst.remove(6)+"remove 3"+bst.remove(3)
                    + "SIZE: " + bst.getSize());
            System.out.println(bst);
            bst.add(6);
            bst.add(13);
            bst.add(99);
            bst.add(11);
            System.out.println( bst+ " Size  "+bst.getSize());
            System.out.println("LOOOK  "+bst.remove(12) +bst.remove(5) + "" + bst + " SIZE "+bst.getSize());

            System.out.println( bst.removeAny() + "REmove  "+bst + "SIZE " + bst.getSize() );
            System.out.println( bst.removeAny() + "REmove  "+bst + "SIZE " + bst.getSize() );
            System.out.println( bst.removeAny() + "REmove  "+bst + "SIZE " + bst.getSize() );
            bst.clear();
            System.out.println("AFTER CLEAR " +  bst + bst.getSize());
            bst.add(55);
            System.out.println(""+ bst + bst.getSize());
            bst.add(24);
            System.out.println(""+ bst + bst.getSize());
            bst.add(78);
            System.out.println(""+ bst + bst.getSize());
            bst.add(51);

            System.out.println(""+ bst + bst.getSize());
        }catch (Exception e){

        }
        }
}
