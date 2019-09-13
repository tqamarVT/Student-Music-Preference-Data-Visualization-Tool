// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and doubleegrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Group One (tqamar, adamc1, hoangcd, tdeel)

package prj5;

/**
 * Generic LinkedList class which implements the SimpleLinkedList Interace.
 * 
 * @author Group One (tqamar, adamc1, hoangcd, tdeel)
 * @version 2019.13.08
 * @param <T>
 *            General object type
 */
public class SingleLinkedList<T> implements SimpleLinkedListInterface<T> {

    /**
     * embedded Node class inside of the linkedlist
     * 
     * @param <E>
     *            General type object
     */
    public static class Node<E> {
        private E data;
        private Node<E> next;


        /**
         * sets the field data to the parameter
         * input d
         * 
         * @param d
         *            node input
         */
        public Node(E d) {
            data = d;
        }


        /**
         * sets the field next to the input parameter node
         * 
         * @param node
         *            the next node
         */
        public void setNext(Node<E> node) {
            next = node;
        }


        /**
         * returns the field next
         * 
         * @return next the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * returns the field data
         * 
         * @return the E type data
         */
        public E getData() {
            return data;
        }


        /**
         * sets data to the parameter input e type data
         * 
         * @param data
         *            E type input
         */
        public void setData(E data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;


    /**
     * the LinkedList constructor
     * sets size to 0
     * sets head to null
     */
    public SingleLinkedList() {
        size = 0;
        head = null;
    }


    /**
     * returns the integer parameter size
     * 
     * @return size integer value
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * adds a T object to the LinkedList
     * 
     * @param obj
     *            T Type that is added
     */
    @Override
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        }

        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    /**
     * returns a boolean condition that will be true
     * if size is equal to 0
     * 
     * @return the boolean condition size == 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * empties the LinkedList and sets
     * size to 0
     */
    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }


    /**
     * checks to seee if the given parameter
     * is within the LinkedList
     * 
     * @param obj
     *            T type object
     * @return true or false given the condition
     */
    @Override
    public boolean contains(T obj) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(obj)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * returns the LinkedList as a string
     * 
     * @return result string
     */
    @Override
    public String toString() {
        String result = "[";
        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }


    /**
     * checks to see if the parameter object is
     * equal to the object calling this method
     * 
     * @param obj
     *            Object that is being compared
     * @return true or false depending on condition
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SingleLinkedList<T> other = ((SingleLinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }

        }
        return false;
    }


    /**
     * Return the object at the index passed in the parameter
     * 
     * @param index
     *            the location of the object
     * @return the object at that location
     */
    public T getAt(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (null != current) {
            if (index == currentIndex) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        // check if the data was null...
        if (null == data) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }

        return data;
    }


    /**
     * Return the object at the index passed in the parameter
     * 
     * @param index
     *            the location of the object
     * @param data
     *            data to be added
     */
    public void setData(int index, T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        Node<T> current = head;

        int currentIndex = 0;

        while (null != current) {
            if (index == currentIndex) {
                current.data = data;
            }
            currentIndex++;
            current = current.next;
        }

    }


    /**
     * Will swap two songs in the linked list
     * 
     * @param j
     *            index of the first node to be swapped
     * @param i
     *            index of the second node to be swapped
     */
    public void swap(int j, int i) {
        T temp = null;
        temp = this.getAt(i);
        this.setData(i, this.getAt(j));
        this.setData(j, temp);
    }
}
