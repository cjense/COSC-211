import java.lang.reflect.Array;

public class Node<K, V> {

    private Node<K, V> rightNode;
    private Node<K, V> leftNode;
    private Node<K, V> parentNode;

    private K key;
    private V value;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Node<K, V> getParent() {
        return this.parentNode;
    }

    public void setParent(Node<K, V> parentNode) {
        this.parentNode = parentNode;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Node<K, V> getRight() {
        return this.rightNode;
    }

    public Node<K, V> getLeft() {
        return this.leftNode;
    }

    public void setLeft(Node<K, V> newNode) {
        this.leftNode = newNode;
    }

    public void setRight(Node<K, V> newNode) {
        this.rightNode = newNode;
    }

}
