// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A stack implemented using queues.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class StackOfQueues <E> implements AmhStack <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The queue in which the stack's elements will be stored. */
    private AmhQueue<E> _queue;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty stack.
     */
    public StackOfQueues () {

	// Specifically use a WrapperQueue, which is a type of AmhQueue, to
	// store the elements.
	_queue = new WrapperQueue<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the top of the stack.
     *
     * @param element The element to add to the stack.
     * @throws IllegalStateException if the stack cannot be expanded
     *                               to accomodate the additional element.
     */
    public void push (E element) throws IllegalStateException {

        try{
            AmhQueue<E> queue2 = new WrapperQueue<E>();
            while(_queue.size() != 0) { // copy info from first queue to second queue
                queue2.add(_queue.remove());
            }
            _queue.add(element); // add element to first queue now that it is empty
            while(queue2.size() != 0) { // add preexisting elements back to queue 1
                _queue.add(queue2.remove());
            }
        } catch(IllegalStateException e) {
                System.out.println("Stack cannot be expanded.");
            }

	
    } // push ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the top of the stack.
     *
     * @return the element taken from the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */    
    public E pop () throws NoSuchElementException {


        if(_queue.size() == 0) {
            throw new NoSuchElementException("Stack is empty.");
        } else {
            return _queue.remove(); // returns and removes element from top of stack
        }

	
    } // pop ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Obtain the top element on the stack without removing it.
     *
     * @return the element at the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    public E top () throws NoSuchElementException {

        if(_queue.size() == 0) {
            throw new NoSuchElementException("Stack is empty. Cannot return top.");
        } else {
            return _queue.peek(); // returns top element without removing
        }

    } // top ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Provide the number of elements on the stack.
     *
     * @return the length of the stack.
     */
    public int size () {

        return _queue.size(); // return size of queue
	
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class StackOfQueues
// ==============================================================================
