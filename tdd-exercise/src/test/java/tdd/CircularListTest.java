package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final int capacity= 2;
    private int number;
    private int expectedNumber;
    private SimpleCircularQueue queue;


    @BeforeEach
    void beforeEach(){
        queue= new SimpleCircularQueue(capacity);
    }


    @Test
    void add() {
        number= 0;
        queue.add(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, queue.peek());
    }

    @Test
    void remove() {
        number= 0;
        queue.add(number);
        number= 1;
        queue.add(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, queue.remove());
    }

    @Test
    void failRemove(){
        assertThrows(IllegalStateException.class, ()-> queue.remove());
    }

    @Test
    void peek() {
        number= 0;
        queue.add(number);
        number= 1;
        queue.add(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, queue.peek());
    }

    @Test
    void failPeek(){
        assertThrows(IllegalStateException.class, ()-> queue.peek());
    }

    @Test
    void getMin() {
        number= 1;
        queue.add(number);
        number= 0;
        queue.add(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, queue.getMin());
    }

    @Test
    void failGetMin() {
        assertThrows(IllegalStateException.class, ()-> queue.getMin());
    }

    @Test
    void getMax() {
        number= 0;
        queue.add(number);
        number= 1;
        queue.add(number);

        expectedNumber= 1;
        assertEquals(expectedNumber, queue.getMax());
    }

    @Test
    void failGetMax() {
        assertThrows(IllegalStateException.class, ()-> queue.getMax());
    }

    @Test
    void size() {
        number= 0;
        queue.add(number);

        expectedNumber= 1;
        assertEquals(expectedNumber, queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isNotEmpty() {
        number= 0;
        queue.add(number);
        assertFalse(queue.isEmpty());
    }
}
