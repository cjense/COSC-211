import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {
        storage = new LinkedList[capacity];
        m = capacity;
    } // ChainedHashSet ()

    public boolean insert (E key) {
        int position = hash(key);
        // if key is present, return false
        if(lookup(key) == true) {
            return false;
        // if key is not present, add it to its corresponding hashed linked list
        } else if (lookup(key) == false) {
            // if there is no linkedlist at hash position,
            // create a new linkedlist and add key to it
            if(storage[position] == null) {
                LinkedList<E> list = new LinkedList<E>();
                list.add(key);
                storage[position] = list;
            // otherwise, add key to linkedlist at hash position
            } else {
                storage[position].add(key);
                collisions++;
            }
            n++;
            return true;
        }

        return false;

    } // insert ()

    public boolean lookup (E key) {
        // check if the array contains any items
        if(storage[hash(key)] != null) {
            LinkedList<E> list = storage[hash(key)];

        // if the calculated hash value-associated list contains the key, return true
        if(list.contains(key)) {
            return true;
        } else if(!list.contains(key)) {
            return false;
        }
    } else if(storage[hash(key)] == null) {
        return false;
}

        return false;
    } // lookup ()

    public boolean remove (E key) {
        // if key is present, remove it from its list, decrement n, and return true
        if(lookup(key) == true) {
            LinkedList<E> list = storage[hash(key)];
            list.remove(key);
            n--;
            return true;
        // if key is not present, return false
        } else if (lookup(key) == false) {
            return false;
        }

        return false;
    }

    public int size () {

	return n;

    }

    public int getNumberCollisions () {

	return collisions;

    }

    private int hash (E key) {
        int index = (key.hashCode() % m);
        if(index < 0) {
            index *= -1;
        }

        return index;
    }

} // class ChainedHashSet
