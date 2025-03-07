package tdd;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleCircularQueue implements CircularQueue {

    private final int CAPACITY;
    private int firstPosition= 0;
    private ArrayList<Integer> queue;

    public SimpleCircularQueue(int CAPACITY){
        this.CAPACITY= CAPACITY;
        queue= new ArrayList<>(CAPACITY);
    }

    @Override
    public void add(int value) {
        if(queue.size()==CAPACITY) {
            queue.set(firstPosition, value);
            firstPosition= (firstPosition+1) % CAPACITY;
        }else {
            queue.add(value);
        }
    }

    @Override
    public int remove() {
        if(!isEmpty()) {
            return queue.remove(firstPosition);
        }else throw new IllegalStateException();
    }

    @Override
    public int peek() {
        if(!isEmpty()) {
            return queue.get(firstPosition);
        }else throw new IllegalStateException();
    }

    @Override
    public int getMin() {
        if(!isEmpty()) {
            return Collections.min(queue);
        }else throw new IllegalStateException();
    }

    @Override
    public int getMax() {
        if(!isEmpty()) {
            return Collections.max(queue);
        }else throw new IllegalStateException();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
