import java.lang.reflect.Array;

public class Node<K, V> {

    private Node<K, V> rightNode;
    private Node<K, V> leftNode;

    private K key;
    private V value;

    public Node(K key, V value){
        value = null;
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

}
