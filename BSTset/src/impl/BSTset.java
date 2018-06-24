package impl;
import adt.Set;
import jdk.nashorn.api.tree.Tree;


public class BSTset<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;

    public BSTset(){
        root= null;
        size = 0;
    }

    @Override
    public void add(T value) {
        if(root == null){
            root = new TreeNode<>(value);
            size++;
            return;
        }
        if(contains(value)) return;
        size++;
        TreeNode node = addHelper(root, value);
        if(value.compareTo(node.getValue()) < 0){
            node.setLeft(new TreeNode(value));
        } else {
            node.setRight(new TreeNode(value));
        }
    }

    private TreeNode<T> addHelper(TreeNode<T> startNode,T value ){
        if(startNode.getValue().compareTo(value)<0){
            if(startNode.getRight() == null){
                return startNode;
            }
            startNode = addHelper(startNode.getRight(), value);
        } else {
            if(startNode.getLeft() == null){
                return startNode;
            }
            startNode = addHelper(startNode.getLeft(), value);
        }
        return startNode;
    }

    @Override
    public boolean contains(T value) {
        return containsHelper(root ,value);
    }

    private boolean containsHelper(TreeNode<T> node, T value){
        if(node == null){
        return false;
        }
        if (value.compareTo(node.getValue())>0) {
            return containsHelper(node.getRight(),value);
        }else if (value.compareTo(node.getValue())<0){
            return containsHelper(node.getLeft(),value);
        }else {
            return true;
        }

    }

    @Override
    public boolean remove(T value) {
         if(!contains(value)) return false;
         size--;
        TreeNode<T> previous = root;
        TreeNode<T> current = root;
        //finding the position of required node
        while(!current.getValue().equals(value)){
            previous = current;
            if(current.getValue().compareTo(value)>0){
                current=current.getLeft();
            }
            else{
                current=current.getRight();
            }
        }

        //removing the root
        if(previous == current){//when next node which does not have children must be next root
            if(current.getRight().getLeft() == null){
                current.getRight().setLeft(root.getLeft());
                root = current.getRight();
                return true;
            }
            current = current.getRight();
            while(current.getLeft()!= null){//when next root is down the tree
                previous = current;
                current = current.getLeft();
            }
            previous.setLeft(current.getRight());

            current.setLeft(root.getLeft());
            current.setRight(root.getRight());

            root = current;
            return true;
        }
        //when node has no children
        if (current.getLeft()==null&&current.getRight()==null){
            if(previous.getRight()==current){
                previous.setRight(null);
            }else{
                previous.setLeft(null);
            }
            return true;
        }
        //whin node has one right children
        if (current.getRight()!=null && current.getLeft()==null){
            if(previous.getRight()==current){
                previous.setRight(current.getRight());
            }else{
                previous.setLeft(current.getRight());
            } return true;
        }
        //when node has one left children
        if (current.getRight()==null&&current.getLeft()!=null){
            if(previous.getRight()==current){
                previous.setRight(current.getLeft());
            }else{
                previous.setLeft(current.getLeft());
            }return true;
        }
        //when node has two children
        if (current.getLeft()!=null&&current.getRight()!=null){
            TreeNode<T> smallest = current.getRight();
            TreeNode<T> prev2 = null;
             while(smallest.getLeft()!=null){
                 prev2=smallest;
                 smallest=smallest.getLeft();
            }
            if(previous.getRight()==current){
                previous.setRight(smallest);
                smallest.setRight(current.getRight());
                smallest.setLeft(current.getLeft());
                prev2.setLeft(smallest.getRight());
            }else{
                previous.setLeft(smallest);
                smallest.setLeft(current.getLeft());
                smallest.setRight(current.getRight());
                prev2.setLeft(smallest.getRight());
            }
            prev2.setLeft(null);
            return true;
        }
        return true;

    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0){
            throw new Exception("Set is empty");
        }
        T result = root.getValue();
        remove(root.getValue());

        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;

    }

    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<T> thisNode){
        if(thisNode==null){
            return " ";
        }
        return toStringHelper(thisNode.getLeft()) +
                thisNode.getValue() +
                toStringHelper(thisNode.getRight());
    }
}
