package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private SimpleMinMaxStack stack;

    @BeforeEach
    void beforeEach(){
        stack = new SimpleMinMaxStack();
    }

    @Test
    void testPush() {
        int value= 0;
        stack.push(value);
        int expectedValue= 0;
        assertEquals(expectedValue, stack.peek());
    }

    @Test
    void testPop() {
        int value= 0;
        stack.push(value);
        value= 1;
        stack.push(value);
        int expectedValuePop= 1;
        int expectedValuePeek= 0;
        assertEquals(expectedValuePop, stack.pop());
        assertEquals(expectedValuePeek, stack.peek());
    }

    @Test
    void testPopEmptyStack(){
        assertThrows(IllegalStateException.class, ()-> stack.pop());
    }

    @Test
    void testPeek(){
        int value= 0;
        stack.push(value);
        value= 1;
        stack.push(value);
        int expectedValue= 1;
        assertEquals(expectedValue, stack.peek());
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.peek());
    }

    @Test
    void testGetMin() {
        int value= 0;
        stack.push(value);
        value= 1;
        stack.push(value);
        int expectedValue= 0;
        assertEquals(expectedValue, stack.getMin());
    }

    @Test
    void testGetMinEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.getMin());
    }

    @Test
    void testGetMax() {
        int value= 1;
        stack.push(value);
        value= 0;
        stack.push(value);
        int expectedValue= 1;
        assertEquals(expectedValue, stack.getMax());
    }

    @Test
    void testGetMaxEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.getMax());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        int value= 0;
        stack.push(value);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testSize() {
        int expectedSize= 0;
        assertEquals(expectedSize, stack.size());
    }

    //more tests

    @Test
    void testGetMinMaxAscending(){
        int value= 1;
        stack.push(value);
        value= 0;
        stack.push(value);
        SimpleMinMaxStack.SortOrder ascending= SimpleMinMaxStack.SortOrder.ASCENDING;
        int expectedValue= 0;
        assertEquals(expectedValue, stack.getMinMax(ascending));
    }

    @Test
    void testGetMinMaxDescending(){
        int value= 0;
        stack.push(value);
        value= 1;
        stack.push(value);
        SimpleMinMaxStack.SortOrder descending= SimpleMinMaxStack.SortOrder.DESCENDING;
        int expectedValue= 1;
        assertEquals(expectedValue, stack.getMinMax(descending));
    }
}