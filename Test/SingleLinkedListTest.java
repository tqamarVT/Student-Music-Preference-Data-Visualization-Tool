package prj5;

import student.TestCase;

/**
 * LinkedListTest class which tests the methods implemented in the LinkedList
 * class.
 * 
 * @author Taimoor Qamar
 * @version 2019.13.08
 */
public class SingleLinkedListTest extends TestCase {
    // FIELDS
    private SingleLinkedList<String> testLinkedList;
    private String[] testStringArr;


    /**
     * Initializes the state for all tests.
     */
    public void setUp() {
        this.testLinkedList = new SingleLinkedList<String>();
        this.testStringArr = new String[10];
        for (int i = 0; i < 10; i++) {
            this.testStringArr[i] = String.valueOf(i);
        }

    }


    /**
     * Tests the constructor of the LinkedList.
     */
    public void testConstructor() {
        this.testLinkedList = null;
        assertNull(testLinkedList);
        this.testLinkedList = new SingleLinkedList<String>();
        assertNotNull(this.testLinkedList);
    }


    /**
     * Tests the add method in the LinkedList Class.
     */
    public void testAdd() {
        // CASE 1: OBJECT IS NULL
        // PRECONDITIONS
        String testAddString = null;
        Exception thrown = null;
        assertNull(thrown);

        // EXECUTION
        try {
            this.testLinkedList.add(testAddString);
        }
        catch (Exception e) {
            thrown = e;
        }

        // POSTCONDITIONS
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        // CASE 2: OBJECT IS NOT NULL, AND LINKEDLIST IS EMPTY
        // POSTCONDITIONS

        // EXECUTION

        // POSTCONDITIONS

        // CASE 3: OBJECT IS NOT NULL, LINKEDLIST IS NOT EMPTY
    }


    /**
     * Tests the isEmpty method in the LinkedList Class.
     */
    public void testisEmpty() {
        // CASE 1: List is empty
        // POSTCONDITIONS
        assertTrue(this.testLinkedList.isEmpty());

        // CASE 2: List is not empty
        // POSTCONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        // POSTCONDITIONS
        assertFalse(this.testLinkedList.isEmpty());

    }


    /**
     * Tests the clear method in the LinkedList class.
     */
    public void testClear() {
        // CASE 1: IS CLEAR
        // POSTCONDITIONS
        this.testLinkedList.clear();
        assertEquals(this.testLinkedList.size(), 0);

        // CASE 2: IS NOT CLEAR
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }
        assertEquals(this.testLinkedList.size(), 10);

        // POSTCONDITONS
        this.testLinkedList.clear();
        assertEquals(this.testLinkedList.size(), 0);

    }


    /**
     * Tests the contain method in the LinkedList class.
     */
    public void testContain() {
        // CASE 1: DOES NOT CONTAINS
        // PRECONDITIONS
        Boolean testBool;
        // EXECUTION
        testBool = this.testLinkedList.contains("hi");
        // POSTCONDITONS
        assertFalse(testBool);

        // CASE 2: CONTAINS
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        // EXECUTIONS
        testBool = this.testLinkedList.contains("3");

        // POSTCONDITIONS
        assertTrue(testBool);

    }


    /**
     * Tests the toString method in the LinkedList class.
     */
    public void testToString() {
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }
        String testToStringString = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";

        // POSTCONDITIONS
        assertEquals(testToStringString, this.testLinkedList.toString());

    }


    /**
     * Tests the equals method in the LinkedList class.
     */
    public void testEquals() {

        Boolean testEqualsBool;

        // CASE 1: Object PASSED IS NULL
        // PRECONDITIONS
        SingleLinkedList<String> testEqualsLinkedList = null;

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(testEqualsLinkedList);

        // POSTCONDITIONS
        assertFalse(testEqualsBool);

        // CASE 2: OBJECT PASSED IS SAME OBJECT
        // PRECONDITIONS
        testEqualsLinkedList = this.testLinkedList;

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(testEqualsLinkedList);

        // POSTCONDITIONS
        assertTrue(testEqualsBool);

        // CASE 3: OBJECT IS DIFF LINKEDLIST WITH DIFF CONTENTS AND SAME SIZE.
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        SingleLinkedList<String> llTest = new SingleLinkedList<String>();
        llTest.add("a");
        llTest.add("b");
        llTest.add("c");
        llTest.add("d");
        llTest.add("e");
        llTest.add("f");
        llTest.add("g");
        llTest.add("h");
        llTest.add("i");
        llTest.add("g");

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(llTest);

        // POSTCONDITIONS
        assertFalse(testEqualsBool);

        // CASE 4: OBJECT IS DIFF LINKEDLIST WITH DIFF CONTENTS AND DIFF SIZE.
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        llTest.clear();
        llTest.add("a");
        llTest.add("b");
        llTest.add("c");
        llTest.add("d");
        llTest.add("e");
        llTest.add("f");
        llTest.add("g");
        llTest.add("f");

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(llTest);

        // POSTCONDITIONS
        assertFalse(testEqualsBool);

        // CASE 4: OBJECT IS DIFF LINKEDLIST WITH SAME CONTENTS
        // OBJECT WITH THE SAME CONTENT, AKA EQUAL

        // PRECONDITIONS
        testEqualsLinkedList.clear();
        for (int i = 0; i < this.testStringArr.length; i++) {
            testEqualsLinkedList.add(testStringArr[i]);
        }

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(testEqualsLinkedList);

        // POSTCONDITIONS
        assertTrue(testEqualsBool);

        // CASE 6: OBJECT PASSED IS A DIFFERENT
        // CLASS

        // PRECONDITIONS
        Object testObj = new Object();

        // EXECUTION
        testEqualsBool = this.testLinkedList.equals(testObj);

        // POSTCONDITIONS
        assertFalse(testEqualsBool);

    }


    /**
     * Tests the getAt method in the LinkedList class.
     */
    public void testGetAt() {
        // CASE 1: INDEX IS OUT OF BOUNDS
        // PRECONDITIONS
        String testGetAtString = null;
        Exception thrown = null;
        assertNull(thrown);

        // EXECUTION
        try {
            testGetAtString = this.testLinkedList.getAt(5);
        }
        catch (Exception e) {
            thrown = e;
        }

        // POSTCONDITIONS
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        // CASE 2: INDEX IS IN BOUNDS
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        // EXECUTION
        testGetAtString = this.testLinkedList.getAt(0);

        // POSTCONDITIONS
        assertEquals(testGetAtString, "0");
    }


    /**
     * Tests the setData method in the LinkedList.
     */
    public void testSetData() {

        // CASE 1 : OBJECT PASSED IS NULL
        // PRECONDITIONS
        Exception thrown = null;
        String testSetDataString = null;
        assertNull(thrown);

        // EXECUTION
        try {
            this.testLinkedList.setData(0, testSetDataString);
        }
        catch (Exception e) {
            thrown = e;
        }

        // POSTCONDITIONS
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        // CASE 2: OBECT PASSED IS VALID
        // PRECONDITIONS
        testSetDataString = "i";
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }

        // EXECUTION
        this.testLinkedList.setData(9, testSetDataString);

        // POSTCONDITIONS
        assertEquals(this.testLinkedList.getAt(9), testSetDataString);

    }


    /**
     * Tests the size method in the LinkedList.
     */
    public void testSize() {
        // CASE 1: SIZE IS 0
        // POSTCONDITIONS
        assertEquals(this.testLinkedList.size(), 0);

        // CASE 2: SIZE IS 10
        // PRECONDITIONS
        for (int i = 0; i < this.testStringArr.length; i++) {
            this.testLinkedList.add(testStringArr[i]);
        }
        // POSTCONDITIONS
        assertEquals(this.testLinkedList.size(), 10);
    }

    /**
     * Tests the swap method in the LinkedList.
     */
    public void testSwap() {
        for (int i = 0; i < testStringArr.length; i++) {
            testLinkedList.add(testStringArr[i]);
        }
        assertEquals(testLinkedList.getAt(0), "0");
        testLinkedList.swap(0, 1);
        assertEquals(testLinkedList.getAt(0), "1");
        assertEquals(testLinkedList.getAt(1), "0");
        
    }

}
