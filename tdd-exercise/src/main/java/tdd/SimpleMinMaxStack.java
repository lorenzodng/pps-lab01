package tdd;

import java.util.*;

public class SimpleMinMaxStack implements MinMaxStack {

   private Stack<Integer> stack= new Stack<>();
   private List<Integer> sortList= new ArrayList<>();
   private int numberPosition;

    @Override
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        if(!stack.isEmpty()){
            return stack.pop();
        }else try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int peek() {
        if(!stack.isEmpty()){
            return stack.peek();
        }else try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int getMin() {
        sortStack("descending");
        return peek();
    }

    @Override
    public int getMax() {
        sortStack("ascending");
        return peek();
    }

    @Override
    public boolean isEmpty() {
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return stack.size();
    }


    //more methods

    public void sortStack(String orderType){
        while(!stack.isEmpty()){
            sortList.add(stack.pop());

            if(orderType.equals("ascending")){
                Collections.sort(sortList);
            }else if(orderType.equals("descending")) {
                Collections.sort(sortList, Collections.reverseOrder());
            }
        }

        for(numberPosition=0; numberPosition<sortList.size(); numberPosition++){
            stack.push(sortList.get(numberPosition));
        }
    }
}
