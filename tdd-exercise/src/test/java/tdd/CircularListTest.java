package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int FIRST_ADD_VALUE= 0;
    private static final int SECOND_ADD_VALUE= 1;
    private static final int EXPECTED_FIRST_ADD_VALUE= 0;
    private static final int EXPECTED_SECOND_ADD_VALUE= 1;
    private SimpleCircularQueue queue;

    @BeforeEach
    void beforeEach(){
        int capacity= 2;
        queue= new SimpleCircularQueue(capacity);
    }

    @Test
    void testAdd() {
        queue.add(FIRST_ADD_VALUE);
        assertEquals(EXPECTED_FIRST_ADD_VALUE, queue.peek());
    }

    @Test
    void testRemove() {
        queue.add(FIRST_ADD_VALUE);
        queue.add(SECOND_ADD_VALUE);
        assertEquals(EXPECTED_FIRST_ADD_VALUE, queue.remove());
    }

    @Test
    void testRemoveEmptyStack(){
        assertThrows(IllegalStateException.class, ()-> queue.remove());
    }

    @Test
    void testPeek() {
        queue.add(FIRST_ADD_VALUE);
        queue.add(SECOND_ADD_VALUE);
        assertEquals(EXPECTED_FIRST_ADD_VALUE, queue.peek());
    }

    @Test
    void testFailPeek(){
        assertThrows(IllegalStateException.class, ()-> queue.peek());
    }

    @Test
    void testGetMin() {
        queue.add(SECOND_ADD_VALUE);
        queue.add(FIRST_ADD_VALUE);
        assertEquals(EXPECTED_FIRST_ADD_VALUE, queue.getMin());
    }

    @Test
    void testFailGetMin() {
        assertThrows(IllegalStateException.class, ()-> queue.getMin());
    }

    @Test
    void testGetMax() {
        queue.add(FIRST_ADD_VALUE);
        queue.add(SECOND_ADD_VALUE);
        assertEquals(EXPECTED_SECOND_ADD_VALUE, queue.getMax());
    }

    @Test
    void testFailGetMax() {
        assertThrows(IllegalStateException.class, ()-> queue.getMax());
    }

    @Test
    void testSize() {
        queue.add(FIRST_ADD_VALUE);
        int expectedSize= 1;
        assertEquals(expectedSize, queue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        queue.add(FIRST_ADD_VALUE);
        assertFalse(queue.isEmpty());
    }
}
