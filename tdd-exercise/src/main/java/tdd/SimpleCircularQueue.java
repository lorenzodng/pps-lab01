package tdd;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleCircularQueue implements CircularQueue {

    private final int CAPACITY;
    private int firstPosition= 0;
    private final ArrayList<Integer> QUEUE;

    public SimpleCircularQueue(int CAPACITY){
        this.CAPACITY= CAPACITY;
        QUEUE= new ArrayList<>(CAPACITY);
    }

    @Override
    public void add(int value) {
        if(QUEUE.size()==CAPACITY) {
            QUEUE.set(firstPosition, value);
            firstPosition= (firstPosition+1) % CAPACITY;
        }else {
            QUEUE.add(value);
        }
    }

    @Override
    public int remove() {
        if(!isEmpty()) {
            return QUEUE.remove(firstPosition);
        }else throw new IllegalStateException();
    }

    @Override
    public int peek() {
        if(!isEmpty()) {
            return QUEUE.get(firstPosition);
        }else throw new IllegalStateException();
    }

    @Override
    public int getMin() {
        if(!isEmpty()) {
            return Collections.min(QUEUE);
        }else throw new IllegalStateException();
    }

    @Override
    public int getMax() {
        if(!isEmpty()) {
            return Collections.max(QUEUE);
        }else throw new IllegalStateException();
    }

    @Override
    public int size() {
        return QUEUE.size();
    }

    @Override
    public boolean isEmpty() {
        return QUEUE.isEmpty();
    }
}
