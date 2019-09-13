package prj5;

/**
 * Interface for LinkedList.
 * 
 * @author Group One
 * @version 2019.08.13
 * @param <T>
 */
public interface SimpleLinkedListInterface<T> {
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public abstract int size();


    /**
     * Add the object to the end of the list, the
     * last node
     *
     * @param obj
     *            the object to be added
     * @throws IllegalArgumentException
     *             thrown if obj is null
     */
    public abstract void add(T obj);


    /**
     * Removes the first instance of the object in
     * the list
     *
     * @return true if the removal was successful,
     *         false otherwise
     * @throws IndexOutOfBoundsException
     *             if element is not found in list
     */
// public abstract boolean remove(T obj);
// /**
// * Checks if the list is empty
// *
// * @return true if the list is empty, false otherwise
// */
    public abstract boolean isEmpty();


    /**
     * Removes all elements from the list
     *
     * @postcondition size = 0 and all nodes removed
     */
    public abstract void clear();


    /**
     * Checks if list contains the specified object
     *
     * @param obj
     *            the object to search for in the list
     * @return true if the list contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public abstract boolean contains(T obj);


    /**
     * Returns a string representation of the list
     * "[A, B, C]" (Without the quotations)
     *
     * @return a string representation of the list
     */
    public abstract String toString();
}
