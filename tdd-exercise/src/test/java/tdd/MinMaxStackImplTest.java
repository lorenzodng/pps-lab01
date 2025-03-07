package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int FIRST_PUSH_VALUE= 0;
    private static final int SECOND_PUSH_VALUE= 1;
    private static final int EXPECTING_FIRST_PUSH_VALUE= 0;
    private static final int EXPECTING_SECOND_PUSH_VALUE= 1;
    private SimpleMinMaxStack stack;

    @BeforeEach
    void beforeEach(){
        stack = new SimpleMinMaxStack();
    }

    @Test
    void testPush() {
        stack.push(FIRST_PUSH_VALUE);
        assertEquals(EXPECTING_FIRST_PUSH_VALUE, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(FIRST_PUSH_VALUE);
        stack.push(SECOND_PUSH_VALUE);
        assertEquals(EXPECTING_SECOND_PUSH_VALUE, stack.pop());
    }

    @Test
    void testPopEmptyStack(){
        assertThrows(IllegalStateException.class, ()-> stack.pop());
    }

    @Test
    void testPeek(){
        stack.push(FIRST_PUSH_VALUE);
        stack.push(SECOND_PUSH_VALUE);
        assertEquals(EXPECTING_SECOND_PUSH_VALUE, stack.peek());
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.peek());
    }

    @Test
    void testGetMin() {
        stack.push(FIRST_PUSH_VALUE);
        stack.push(SECOND_PUSH_VALUE);
        assertEquals(EXPECTING_FIRST_PUSH_VALUE, stack.getMin());
    }

    @Test
    void testGetMinEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.getMin());
    }

    @Test
    void testGetMax() {
        stack.push(SECOND_PUSH_VALUE);
        stack.push(FIRST_PUSH_VALUE);
        assertEquals(EXPECTING_SECOND_PUSH_VALUE, stack.getMax());
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
        stack.push(FIRST_PUSH_VALUE);
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
        stack.push(SECOND_PUSH_VALUE);
        stack.push(FIRST_PUSH_VALUE);
        SimpleMinMaxStack.SortOrder ascending= SimpleMinMaxStack.SortOrder.ASCENDING;
        assertEquals(EXPECTING_FIRST_PUSH_VALUE, stack.getMinMax(ascending));
    }

    @Test
    void testGetMinMaxDescending(){
        stack.push(FIRST_PUSH_VALUE);
        stack.push(SECOND_PUSH_VALUE);
        SimpleMinMaxStack.SortOrder descending= SimpleMinMaxStack.SortOrder.DESCENDING;
        assertEquals(EXPECTING_SECOND_PUSH_VALUE, stack.getMinMax(descending));
    }
}