package tdd;

import java.util.*;

public class SimpleMinMaxStack implements MinMaxStack {

   private final Stack<Integer> stack= new Stack<>();
   public enum SortOrder{
       ASCENDING, DESCENDING
   }

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
       if(!stack.isEmpty()) {
           return stack.pop();
       }else throw new IllegalStateException();
    }

    @Override
    public int peek(){
       if(!stack.isEmpty()) {
           return stack.peek();
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
       return stack.isEmpty();
    }

    @Override
    public int size() {
       return stack.size();
    }

    //more methods

    public int getMinMax(SortOrder orderType){
       PriorityQueue<Integer> priorityQueue;
       if(orderType == SortOrder.ASCENDING){
           priorityQueue= new PriorityQueue<>();
       }else{
           priorityQueue= new PriorityQueue<>(Collections.reverseOrder());
       }
       while(!stack.isEmpty()){
           priorityQueue.offer(stack.pop());
       }
       if(!priorityQueue.isEmpty()){
           return priorityQueue.peek();
       }else throw new IllegalStateException();
    }

}
