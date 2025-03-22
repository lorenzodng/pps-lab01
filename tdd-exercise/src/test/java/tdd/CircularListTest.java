package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private SimpleCircularQueue queue;

    @BeforeEach
    void beforeEach(){
        int initialCapacity= 2;
        queue= new SimpleCircularQueue(initialCapacity);
    }

    @Test
    void testAdd() {
        int value= 0;
        queue.add(value);
        int expectedValue= 0;
        assertEquals(expectedValue, queue.peek());
    }

    @Test
    void testRemove() {
        int value= 0;
        queue.add(value);
        value= 1;
        queue.add(value);
        int expectedValue= 0;
        assertEquals(expectedValue, queue.remove());
    }

    @Test
    void testRemoveEmptyStack(){
        assertThrows(IllegalStateException.class, ()-> queue.remove());
    }

    @Test
    void testPeek() {
        int value= 0;
        queue.add(value);
        value= 1;
        queue.add(value);
        int expectedValue= 0;
        assertEquals(expectedValue, queue.peek());
    }

    @Test
    void testFailPeek(){
        assertThrows(IllegalStateException.class, ()-> queue.peek());
    }

    @Test
    void testGetMin() {
        int value= 1;
        queue.add(value);
        value= 0;
        queue.add(value);
        int expectedValue= 0;
        assertEquals(expectedValue, queue.getMin());
    }

    @Test
    void testFailGetMin() {
        assertThrows(IllegalStateException.class, ()-> queue.getMin());
    }

    @Test
    void testGetMax() {
        int value= 0;
        queue.add(value);
        value= 1;
        queue.add(value);
        int expectedValue= 1;
        assertEquals(expectedValue, queue.getMax());
    }

    @Test
    void testFailGetMax() {
        assertThrows(IllegalStateException.class, ()-> queue.getMax());
    }

    @Test
    void testSize() {
        int value= 0;
        queue.add(value);
        int expectedSize= 1;
        assertEquals(expectedSize, queue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        int value= 0;
        queue.add(value);
        assertFalse(queue.isEmpty());
    }
}
