import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> {

    Stack<Node<K, V>> traversal = new Stack<Node<K, V>>();
    Node<K, V> root;

    public V add(K key, V value) {
        if(value == this.lookup(key)) {

        }
    }

    public V remove(K key) {
        private Node<K> curNode = this.lookup(key);

        // if node isn't in the tree
        if(curNode == null) {
            return null;
        // if node that is being looked up has no children
        } else if(curNode.getLeft() == null && curNode.getRight() == null) {

        // if node only has right child
        } else if(curNode.getLeft() == null && curNode.getRight !=null) {

        // if node only has left child
        } else if(curNode.getLeft() != null && curNode.getRight == null) {

            }

    }

    public V lookup(K key) {
        if(traversal.contains(key)) {

        }
    }

    public void inOrderTraverse() {

    }

}