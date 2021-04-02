package hw5;
public class Node<K, V> {

    private K key;
    private V value;

    private Node<K, V> leftNode;
    private Node<K, V> rightNode;
    private Node<K, V> parentNode;


    public Node(K key) {
        this.key = key;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> getLeft() {
        return leftNode;
    }

    public Node<K, V> getRight() {
        return rightNode;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setLeft(Node<K, V> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRight(Node<K, V> rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isRightNode() {
        return parentNode.rightNode == this;
    }

    public boolean isRoot(){
        return parentNode == null;
    }

    public Node<K, V> getParent() {
        return parentNode;
    }

    public void setParent(Node<K, V> parentNode) {
        this.parentNode = parentNode;
    }
}
