package impl;
import adt.Map;

public class BSTMap<K extends Comparable,V> implements Map<K,V> {

    private TreeNode<KeyValuePair<K,V>> root;
    private int size;

    public BSTMap(){
        root=null;
        size=0;
    }

    @Override
    public void define(K key, V value) {
        if(root == null){
            root = new TreeNode(new KeyValuePair(key,value));
            size++;
            return;
        }
        if(contains(root,key)!=null){
            KeyValuePair<K,V> newNode = contains(root,key);
            newNode.setValue(value);

        }else{
            size++;
            TreeNode<KeyValuePair<K, V>> node = defineHelper(root,key);
            if(key.compareTo(node.getValue().getKey()) < 0){
                node.setLeft(new TreeNode(new KeyValuePair(key,value)));
            } else if(key.compareTo(node.getValue().getKey())>0){
                node.setRight(new TreeNode(new KeyValuePair(key,value)));
            }else{
                node.getValue().setKey(key);
            }
        }

    }

    private TreeNode<KeyValuePair<K,V>> defineHelper(TreeNode<KeyValuePair<K,V>> startNode,K key ){

        if(startNode.getValue().getKey().compareTo(key)<0){
            if(startNode.getRight() == null){
                return startNode;
            }
            startNode = defineHelper(startNode.getRight(), key);
        }
        if(startNode.getValue().getKey().compareTo(key)>0) {
            if(startNode.getLeft() == null){
                return startNode;
            }
            startNode = defineHelper(startNode.getLeft(), key);
        }
        return startNode;

    }

    private KeyValuePair<K,V> contains(TreeNode<KeyValuePair<K,V>> node, K key){
        if(node == null){
            return null;
        }
        if (key.compareTo(node.getValue().getKey())>0) {
            return contains(node.getRight(),key);
        }else if (key.compareTo(node.getValue().getKey())<0){
            return contains(node.getLeft(),key);
        }else {
            return node.getValue();
        }

    }

    @Override
    public V getValue(K key) {
        return getValueHelper(root,key);
    }
    private V getValueHelper(TreeNode<KeyValuePair<K,V>> node, K key){
        if(node == null){
            return null;
        }
        if (key.compareTo(node.getValue().getKey())>0) {
            return getValueHelper(node.getRight(),key);
        }else if (key.compareTo(node.getValue().getKey())<0){
            return getValueHelper(node.getLeft(),key);
        }else {
            return node.getValue().getValue();
        }

    }

    @Override
    public V remove(K key) {
        if (contains(root,key)==null) return null;
        size--;
        TreeNode<KeyValuePair<K, V>> previous = root;
        TreeNode<KeyValuePair<K, V>> current = root;
        //finding the position of required node
        while (!current.getValue().getKey().equals(key)) {
            previous = current;
            if (current.getValue().getKey().compareTo(key) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        //removing the root
        if (previous == current) {//when next node which does not have children must be next root
            if (current.getRight().getLeft() == null) {
                current.getRight().setLeft(root.getLeft());
                root = current.getRight();
                return current.getValue().getValue();
            }
            current = current.getRight();
            while (current.getLeft() != null) {//when next root is down the tree
                previous = current;
                current = current.getLeft();
            }
            previous.setLeft(current.getRight());

            current.setLeft(root.getLeft());
            current.setRight(root.getRight());
            previous = root;
            root = current;
            return previous.getValue().getValue();
        }
        //when node has no children
        if (current.getLeft() == null && current.getRight() == null) {
            if (previous.getRight() == current) {
                previous.setRight(null);
            } else {
                previous.setLeft(null);
            }
            return current.getValue().getValue();
        }
        //when node has one right children
        if (current.getRight() != null && current.getLeft() == null) {
            if (previous.getRight() == current) {
                previous.setRight(current.getRight());
            } else {
                previous.setLeft(current.getRight());
            }
            return current.getValue().getValue();
        }
        //when node has one left children
        if (current.getRight() == null && current.getLeft() != null) {
            if (previous.getRight() == current) {
                previous.setRight(current.getLeft());
            } else {
                previous.setLeft(current.getLeft());
            }
            return current.getValue().getValue();
        }
        //when node has two children
        if (current.getLeft() != null && current.getRight() != null) {
            TreeNode<KeyValuePair<K, V>> smallest = current.getRight();
            TreeNode<KeyValuePair<K, V>> prev2 = null;
            while (smallest.getLeft() != null) {
                prev2 = smallest;
                smallest = smallest.getLeft();
            }
            if (previous.getRight() == current) {
                previous.setRight(smallest);
                smallest.setRight(current.getRight());
                smallest.setLeft(current.getLeft());
                prev2.setLeft(smallest.getRight());
            } else {
                previous.setLeft(smallest);
                smallest.setLeft(current.getLeft());
                smallest.setRight(current.getRight());
                prev2.setLeft(smallest.getRight());
            }
            prev2.setLeft(null);
            return current.getValue().getValue();
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0){
            throw new Exception("Map is empty");
        }
        KeyValuePair<K,V> result = root.getValue();
        remove(root.getValue().getKey());

        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root =null;
        size =0 ;
    }
    public String toString(){
        return toStringHelper(root);
    }

    private String toStringHelper(TreeNode<KeyValuePair<K,V>> thisNode){
        if(thisNode==null){
            return " ";
        }
        return toStringHelper(thisNode.getLeft()) +
                thisNode.getValue() +
                toStringHelper(thisNode.getRight());
    }
}
