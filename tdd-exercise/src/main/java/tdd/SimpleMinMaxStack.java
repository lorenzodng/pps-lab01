package tdd;

import java.util.*;

public class SimpleMinMaxStack implements MinMaxStack {

   private final Stack<Integer> STACK= new Stack<>();
   public enum SortOrder{
       ASCENDING, DESCENDING
   }

    @Override
    public void push(int value) {
       STACK.push(value);
    }

    @Override
    public int pop() {
       if(!STACK.isEmpty()) {
           return STACK.pop();
       }else throw new IllegalStateException();
    }

    @Override
    public int peek(){
       if(!STACK.isEmpty()) {
           return STACK.peek();
       }else throw new IllegalStateException();
    }

    @Override
    public int getMin() {
       SortOrder descending= SortOrder.ASCENDING;
       return getMinMax(descending);
    }

    @Override
    public int getMax() {
        SortOrder ascending= SortOrder.DESCENDING;
        return getMinMax(ascending);
    }

    @Override
    public boolean isEmpty() {
       return STACK.isEmpty();
    }

    @Override
    public int size() {
       return STACK.size();
    }

    //more methods

    public int getMinMax(SortOrder orderType){
       PriorityQueue<Integer> priorityQueue;
       if(orderType == SortOrder.ASCENDING){
           priorityQueue= new PriorityQueue<>();
       }else{
           priorityQueue= new PriorityQueue<>(Collections.reverseOrder());
       }
       while(!STACK.isEmpty()){
           priorityQueue.offer(STACK.pop());
       }
       if(!priorityQueue.isEmpty()){
           return priorityQueue.peek();
       }else throw new IllegalStateException();
    }

}
