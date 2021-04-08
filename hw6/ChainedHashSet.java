import java.util.LinkedList;

public class ChainedHashSet<E> implements AmhHashSet<E> {

    private LinkedList<E>[] storage;
    private int             m;
    private int             n;
    private int             collisions;
    
    public ChainedHashSet (int capacity) {

    } // ChainedHashSet ()

    public boolean insert (E key) {
        int position = hash(key);
        // if key is not present, insert it, increment n, and return true
        if(lookup(key) == false) {
            // if key is not present
            if(insert(key) == false) {
                // if there is no linkedlist at hash position,
                // create a new linkedlist and add key to it
                if(storage[position] != null) {
                    collisions++;
                    LinkedList<E> list = new LinkedList<E>();
                    list.add(key);
                    storage[position] = list;
                // otherwise, add key to linkedlist at hash position
                } else {
                    storage[position].add(key);
                }
            }
            insert(key);
            n++;
            return true;
        // if key is present, return false
        } else if (lookup(key) == true) {
            return false;
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

	return key.hashCode();
	
    }

} // class ChainedHashSet
