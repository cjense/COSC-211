
public class BinarySearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private Node<K, V> root;
    private int size = 0;

    // CONSTRUCTOR
    public BinarySearchTree() {

        this.root = null;
        this.size = 0;
    }

    // ADD
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
            findNode(key).setValue(value);
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
            // check if key to be added is greater or less than its parent,
            // add to corresponding spot (left if smaller, right if larger)
            if(key.compareTo(parentNode.getKey()) > 0) {
                parentNode.setRight(newNode);
            } else if(key.compareTo(parentNode.getKey()) < 0) {
                parentNode.setLeft(newNode);
            }
        }
        return null;
    }

    // REMOVE
    public V remove(K key) {

        // change the size to reflect removal
        if(size > 0) {
            size -= 1;
        }

        return delete(key);
    }

    // DELETE
    private V delete(K key) {

        Node<K, V> toBeRemoved = findNode(key);

        // if node is not found, return null
        if(toBeRemoved == null) {
            return null;
        }

        Node<K, V> toBeRemovedParent = toBeRemoved.getParent();
        V value = toBeRemoved.getValue();

        // if node doesn't have a left value
        if(toBeRemoved.getLeft() == null) {
            // if node is root, change root value to the right node
            if(toBeRemoved.isRoot()) {
                root = toBeRemoved.getRight();
            // set parents' children to corresponding values
            } else if(toBeRemoved.isRightNode()) {
                toBeRemovedParent.setRight(toBeRemoved.getRight());
            } else {
                toBeRemovedParent.setLeft(toBeRemoved.getRight());
            }
            // set right node to next right value
            if(toBeRemoved.getRight() != null) {
                toBeRemoved.getRight().setParent(toBeRemovedParent);
            }

            return value;

        // if node doesn't have a right value
        } else if (toBeRemoved.getRight() == null) {
            // if node is root, change root value to the left node
            if (toBeRemoved.isRoot()) {
                root = toBeRemoved.getLeft();
            // set parents' children to corresponding values
            } else if (toBeRemoved.isRightNode()) {
                toBeRemovedParent.setRight(toBeRemoved.getLeft());
            } else {
                toBeRemovedParent.setRight(toBeRemoved.getLeft());
            }
            // set left node to next left value
            if (toBeRemoved.getLeft() != null) {
                toBeRemoved.getLeft().setParent(toBeRemovedParent);
            }

            return value;

        } else {
            // if the node has two children, get successors and set keys and values accordingly
            Node<K, V> inOrderSuccessor = getInOrderSuccessor(toBeRemoved);
            delete(inOrderSuccessor.getKey());
            toBeRemoved.setKey(inOrderSuccessor.getKey());
            toBeRemoved.setValue(inOrderSuccessor.getValue());

            return value;
        }

    }

    // GET IN ORDER SUCCESSOR
    private Node<K, V> getInOrderSuccessor(Node<K, V> node) {

        // find the next succeeding node in the tree (the leftmost node one branch to the right)
        node = node.getRight();
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    // LOOKUP
    public V lookup(K key) {

        Node<K, V> pointerNode = root;
        Node<K, V> curNode;

        while (pointerNode != null) {
            //update the parent to be the current node
            curNode = pointerNode;
            //if the given key is equal to the given current key
            if (key.compareTo(curNode.getKey()) == 0) {
                //return the value
                return curNode.getValue();
            }
            //if the key is larger than our node's key,
            if (key.compareTo(pointerNode.getKey()) > 0) {
                //then assign it to the right
                pointerNode = pointerNode.getRight();
            } else {
                //assign it to the left
                pointerNode = pointerNode.getLeft();
            }

        }

        return null;
    }

    // IN ORDER

    private void inOrder(Node<K, V> node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        System.out.println(node.getKey() + " -> " + node.getValue());
        inOrder(node.getRight());
    }

    // IN ORDER TRAVERSE
    public void inOrderTraverse() {

        // traverse through the tree
        Node<K, V> pointerNode = root;
        inOrder(pointerNode);
    }

    // GET ROOT
    public Node<K, V> getroot() {

    // return the root of the tree

        return root;
    }

    // SIZE
    public int size() {

    // return the size

        return size;
    }

    // FIND NODE
    private Node<K, V> findNode(K key) {

        Node<K, V> pointerNode = root;
        Node<K, V> curNode;

        while (pointerNode != null) {
            curNode = pointerNode;
            //if the given key is equal to the given current key
            if (key.compareTo(curNode.getKey()) == 0) {
                //return the value
                return curNode;
            }
            //if the key is larger than our node's key,
            if (key.compareTo(pointerNode.getKey()) > 0) {
                //then assign it to the right
                pointerNode = pointerNode.getRight();
            } else {
                //assign it to the left
                pointerNode = pointerNode.getLeft();
            }
        }

        return null;
    }
}
