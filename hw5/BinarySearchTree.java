import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private ArrayList<Node<K, V>> traversal = new ArrayList<Node<K, V>>();
    private Node<K, V> root;
    private int size = 0;

    public V add(K key, V value) {
        Node<K, V> curNode = root;
        Node<K, V> parentNode = null;
        Node<K, V> newNode = new Node<>(key, value);

        if(root == null) {
            root = newNode;
            size++;
            return null;
        }
        // if the key already exists, replace value and return old value
        if(lookup(key) != null) {
            V oldVal = lookup(key);
            lookupNode(key).setValue(value);
            return oldVal;
        // if key is not present, add key and value to tree
        } else if(lookup(key) == null) {
            while(curNode != null) {
                parentNode = curNode;
                // check to see if key is larger or smaller than current node's key
                if(key.compareTo(curNode.getKey()) < 0) {
                    curNode = curNode.getLeft();
                } else if(key.compareTo(curNode.getKey()) > 0) {
                    curNode = curNode.getRight();
                }
            }
            newNode.setParent(parentNode);
            // check if key to be added is greater or less than its parent, add
            // to corresponding spot
            if(key.compareTo(parentNode.getKey()) > 0) {
                parentNode.setRight(newNode);
            } else if(key.compareTo(parentNode.getKey()) < 0) {
                parentNode.setLeft(newNode);
            }
        }
        return null;
    }

    public V remove(K key) {
        return null;
        // private Node<K, V> curNode = new Node<this.lookup(key), null>;

        // // if node isn't in the tree
        // if(curNode == null) {
        //     return null;
        // // if node that is being looked up has no children
        // } else if(curNode.getLeft() == null && curNode.getRight() == null) {
            
        // // if node only has right child
        // } else if(curNode.getLeft() == null && curNode.getRight() !=null) {
        //     this.lookup(key);
        //     this.add(traversal.get(key) - 1);
        // // if node only has left child
        // } else if(curNode.getLeft() != null && curNode.getRight() == null) {

        //     }

    }

    public V lookup(K key) {
        Node<K, V> curNode = null;
        Node<K, V> pointerNode = root;

        while(pointerNode != null) {
            curNode = pointerNode;

            // if key is equal to node, return value
            if(key.compareTo(curNode.getKey()) == 0) {
                return curNode.getValue();
            }
            // if node is smaller than root, go left
            if(key.compareTo(pointerNode.getKey()) < 0) {
                curNode = pointerNode.getLeft();
            // if node is bigger than root, go right
            } else if(key.compareTo(pointerNode.getKey()) > 0) {
                curNode = pointerNode.getRight();
            }
        }
        return null;
    }

    public void inOrderTraverse() {
        Node<K, V> curNode = root;

        traverse(curNode);
    }

    public void traverse(Node<K, V> curNode) {
        if(curNode == null) {
            return;
        }

        // print everything to the left
        traverse(curNode.getLeft());
        // print current node
        System.out.println(curNode);
        // print everything to the right
        traverse(curNode.getRight());

    }

    public Node<K, V> lookupNode(K key) {
        Node<K, V> curNode = null;
        Node<K, V> pointerNode = root;

        while(pointerNode != null) {
            curNode = pointerNode;

            // if key is equal to node, return value
            if(key.compareTo(curNode.getKey()) == 0) {
                return curNode;
            }
            // if node is smaller than root, go left
            if(key.compareTo(pointerNode.getKey()) < 0) {
                curNode = pointerNode.getLeft();
            // if node is bigger than root, go right
            } else if(key.compareTo(pointerNode.getKey()) > 0) {
                curNode = pointerNode.getRight();
            }
        }
        return null;
    }

}