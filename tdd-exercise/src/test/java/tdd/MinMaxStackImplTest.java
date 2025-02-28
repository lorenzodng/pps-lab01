package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    private int number;
    private int expectedNumber;
    private SimpleMinMaxStack stack;
    private String orderType;

    @Test
    public void todo() {
        assertTrue(true);
    }

    @BeforeEach
    void beforeEach(){
        stack = new SimpleMinMaxStack();
    }


    @Test
    void push() {
        number= 0;
        stack.push(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, stack.peek());
    }

    @Test
    void pop() {
        number= 0;
        stack.push(number);
        number= 1;
        stack.push(number);

        stack.pop();

        expectedNumber= 0;
        assertEquals(expectedNumber, stack.peek());
    }

    @Test
    void popEmptyStack(){
        assertThrows(IllegalStateException.class, ()-> stack.pop());
    }

    @Test
    void peek(){
        number= 0;
        stack.push(0);

        expectedNumber= 0;
        assertEquals(expectedNumber, stack.peek());
    }

    @Test
    void peekEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.peek());
    }

    @Test
    void getMin() {
        number= 0;
        stack.push(number);
        number= 1;
        stack.push(number);

        expectedNumber= 0;
        assertEquals(expectedNumber, stack.getMin());
    }

    @Test
    void getMinEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.getMin());
    }

    @Test
    void getMax() {
        number= 1;
        stack.push(number);
        number= 0;
        stack.push(number);

        expectedNumber= 1;
        assertEquals(expectedNumber, stack.getMax());
    }

    @Test
    void getMaxEmptyStack() {
        assertThrows(IllegalStateException.class, ()-> stack.getMax());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isNotEmpty() {
        number= 0;
        stack.push(number);

        assertFalse(stack.isEmpty());
    }

    @Test
    void size() {
        number= 0;
        stack.push(number);

        int elementsNumber= 1;
        assertEquals(elementsNumber, stack.size());
    }

    @Test
    void ascendingSortStack(){
        number=1;
        stack.push(number);
        number=0;
        stack.push(number);

        stack.sortStack("ascending");

        expectedNumber= 1;
        assertEquals(expectedNumber, stack.peek());
    }

    @Test
    void descendingSortStack(){
        number=0;
        stack.push(number);
        number=1;
        stack.push(number);

        stack.sortStack("descending");

        expectedNumber= 0;
        assertEquals(expectedNumber, stack.peek());
    }



}