// ==============================================================================
// IMPORTS

import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
// ==============================================================================



// ==============================================================================
/**
 * A queue implemented using stacks.
 *
 * @author Scott Kaplan -- sfkaplan@amherst.edu
 * @date   Feb 2021
 */
public class QueueOfStacks <E> implements AmhQueue <E> {
// ==============================================================================


    
    // ==========================================================================
    /** The stack in which the queue's elements will be stored. */
    private AmhStack<E> _stack;
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Constructor.  Create an empty queue.
     */
    public QueueOfStacks () {

	// Specifically use a WrapperStack, which is a type of AmhStack, to
	// store the elements.
	_stack = new WrapperStack<E>();

    } // StackOfQueues ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Add an element to the tail of the queue.
     *
     * @param element The element to add to the queue.
     * @throws IllegalStateException if the queue cannot be expanded
     *                               to accomodate the additional element.
     */
    public void add (E element) throws IllegalStateException {

        try{
            AmhStack<E> stack2 = new WrapperStack<E>();
            while(_stack.size() != 0) { // copy info from first stack to second stack
                stack2.push(_stack.pop());
            }
            _stack.push(element); // add element to first stack now that it is empty
            while(stack2.size() != 0) { // add preexisting elements back to stack 1
                _stack.push(stack2.pop());
            }
        } catch(IllegalStateException e) {
                System.out.println("Queue cannot be expanded.");
            }

    } // add ()
    // ==========================================================================


    
    // ==========================================================================
    /**
     * Remove an element from the head of the queue.
     *
     * @return the element taken from the head of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public E remove () throws NoSuchElementException {

        if(_stack.size() == 0) {
            throw new NoSuchElementException("Stack is empty. Cannot remove item.");
        } else {
            return _stack.pop();
        }
	
    } // remove ()
    // ==========================================================================


    
    // ==========================================================================
    public E peek () throws NoSuchElementException {

        if(_stack.size() == 0) {
            throw new NoSuchElementException("Stack is empty. Cannot peek.");
        } else {
            return _stack.top();
        }

    } // peek ()
    // ==========================================================================


    
    // ==========================================================================
    public int size () {

        return _stack.size(); // return size of stack
	
    } // size ()
    // ==========================================================================


    
// ==============================================================================
} // class QueueOfStacks
// ==============================================================================
