// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.Map;
import java.util.LinkedList;
import java.util.Set;

// ==============================================================================



// ==============================================================================
/**
 * Implement a dictionary using a standard <code>Binary Search Tree</code>.
 *
 * @author Claire Jensen
 * @date   Mar 2021
 */
public class TreeMapWrapper <K, V> implements Map<K, V> {
// ==============================================================================


    
    // ==========================================================================
    /** The linked list in which the elements will be stored. */
    private LinkedList<Node<K, V>> _storage;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty dictionary.
     */
    public TreeMapWrapper () {

	_storage = new BinarySearchTree<K, V>();

    } // TreeMapWrapper ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to this list at the given, indexed position.  The index
     * must be in range, or must be immediately after the last valid index, thus
     * appending the value to the list.
     *
     * @param index   The position at which to insert the element.
     * @param element The element to add.
     * @throws IndexOutOfBoundsException if {@code index < 0 || size < index}
     * @throws IllegalStateException  if the list cannot be expanded to
     *                                accomodate the additional element.
     */
    public void add (K key, V value) throws IndexOutOfBoundsException,
						  IllegalStateException {

        _storage.add(index, element);
        
    } // add ()
    // ==========================================================================

    

    // ==========================================================================
    /**
     * Retrieve the element at the given, indexed position.
     *
     * @param index The position from which to retrieve the element.
     * @return the value at the given position.
     * @throws IndexOutOfBoundsException if {@code index < 0 && size <= index}
     */
    public E get (int index) throws IndexOutOfBoundsException {

        return _storage.get(index);
        
    } // get ()
    // ==========================================================================



    // ==========================================================================
    /**
     * Remove an element from the given, indexed position.  The list size is
     * decremented, with the elements in higher position sliding down to fill in
     * the gap.
     *
     * @param index The position at which to remove an element.
     * @return the removed element.
     * @throws IndexOutOfBoundsException if {@code index < 0 && size <= index}
     */
    public E remove (int index) throws IndexOutOfBoundsException {

        return _storage.remove(index);
        
    } // remove ()
    // ==========================================================================

    

    // ==========================================================================
    /**
     * Replace the element at the given index with another, given element.
     *
     * @param index   The position at which to replace an element.
     * @param element The new element to place at the given position.
     * @return the removed element previously at the given position.
     * @throws IndexOutOfBoundsException if {@code index < 0 && size <= index}
     */
    public E set (int index, E element) throws IndexOutOfBoundsException {

        return _storage.set(index, element);
        
    } // set ()
    // ==========================================================================

    public boolean containsKey(K key) {
        return _storage.contains(key);
    }

    public Set<K> keySet() {

    }

    // ==========================================================================
    /**
     * Provide the number of elements in the list.
     *
     * @return the length of the list.
     */
    public int size () {

        return _storage.size();
        
    } // size ()
    // ==========================================================================



// ==============================================================================
} // class WrapperList
// ==============================================================================