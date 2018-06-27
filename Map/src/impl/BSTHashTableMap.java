package impl;

import adt.HashTableMap;

public class BSTHashTableMap<K extends Comparable,V> implements HashTableMap<K,V> {
    private TreeNode<KeyValuePair<K,V>>[] buckets;
    private int size;

    public BSTHashTableMap(int num){
        buckets = new TreeNode[num];
        size=0;
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
        if(buckets[index] == null) return 0;
        return bucketSizeHelper(buckets[index],1);
    }

    private int bucketSizeHelper(TreeNode<KeyValuePair<K,V>> node,int bucketSize){

        if (node.getLeft() != null){
            return bucketSizeHelper(node.getLeft(), bucketSize + 1 );
        } else if (node.getRight() != null){
            return bucketSizeHelper(node.getRight(), bucketSize + 1);
        }
        return bucketSize;
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
                prod +=Math.abs(bucketSizeHelper(buckets[j],1)-mean)*Math.abs(bucketSizeHelper(buckets[j],1)-mean);
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
            if(buckets[buckets.length-1] == null && counter == 0&&k==buckets.length-1) return "[  ]";
            if(buckets[k] != null){
                    string+= toStringHelper(buckets[k]) + '\n';
                    counter++;
            }else if(buckets[k]==null && counter!=0){
                string+= "[ ]\n";
            }

        }
        return string;

    }

    @Override
    public void define(K key, V value) {
        if(buckets[Math.abs(key.hashCode()%buckets.length)]==null){
            buckets[Math.abs(key.hashCode()%buckets.length)]= new TreeNode<>(new KeyValuePair<>(key,value));
            size++;
        }else {
            TreeNode root = buckets[Math.abs(key.hashCode() % buckets.length)];
            if (contains(root, key) != null) {
                contains(root, key).setValue(value);
            } else {
                TreeNode<KeyValuePair<K,V>> node = defineHelper(root,key);
                if(key.compareTo(node.getValue().getKey())<0){
                    node.setLeft(new TreeNode<>(new KeyValuePair<>(key,value)));
                }else if(key.compareTo(node.getValue().getKey())>0){
                    node.setRight(new TreeNode<>(new KeyValuePair<>(key,value)));
                }
                size++;
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

    private KeyValuePair<K,V> contains(TreeNode<KeyValuePair<K,V>> node,K key) {
        if(buckets[Math.abs(key.hashCode()%buckets.length)]==null){
            return null;
        }
        if(node==null){
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
        TreeNode<KeyValuePair<K,V>> root = buckets[Math.abs(key.hashCode()%buckets.length)];
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
        TreeNode<KeyValuePair<K,V>> root = buckets[Math.abs(key.hashCode()%buckets.length)];
        if (contains(root,key)==null) return null;
        if(root.getRight()==null&&root.getLeft()==null){
            buckets[Math.abs(key.hashCode()%buckets.length)]=null;
            size--;
            return root.getValue().getValue();
        }
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
                buckets[Math.abs(key.hashCode()%buckets.length)] = current.getRight();
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
            buckets[Math.abs(key.hashCode()%buckets.length)] = current;
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
            KeyValuePair<K, V> result = null;
            for(int i =0;i<buckets.length;i++) {
                if (buckets[i] == null) {
                } else {
                    result = buckets[i].getValue();
                    remove(buckets[i].getValue().getKey());
                    break;
                }
            }

            return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size =0;
        buckets = new TreeNode[buckets.length];
    }
    public String toString(){
        String string = "";
        for (int i =0;i<buckets.length;i++){
            string += toStringHelper(buckets[i]);
        }
        return string;
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
