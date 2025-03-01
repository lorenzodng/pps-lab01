package tdd;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleCircularQueue implements CircularQueue {

    private int capacity;
    private int firstPosition= 0;
    private int lastPosition= -1;
    private int capacityLessOnePosition;
    private final int constantPosition= 1;
    private ArrayList<Integer> queue;

    public SimpleCircularQueue(int capacity){
        this.capacity= capacity;
        this.capacityLessOnePosition= capacity-constantPosition;
        queue= new ArrayList<>(capacity);
    }

    @Override
    public void add(int value) {
        if(lastPosition==capacityLessOnePosition){
            remove();
            queue.add(firstPosition, value);

            if(firstPosition<capacityLessOnePosition) {
                firstPosition++;
            }else{
                firstPosition=0;
            }

        }else{
            queue.add(value);
            lastPosition++;
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
